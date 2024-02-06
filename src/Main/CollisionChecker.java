package Main;

import Entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp)
    {
        this.gp = gp;
    }
    public void CheckTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY  = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;
        switch (entity.direction)
        {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tilemanager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tilemanager.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tilemanager.tile[tileNum1].collision || gp.tilemanager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }

                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tilemanager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tilemanager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tilemanager.tile[tileNum1].collision || gp.tilemanager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tilemanager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tilemanager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tilemanager.tile[tileNum1].collision || gp.tilemanager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tilemanager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tilemanager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tilemanager.tile[tileNum1].collision || gp.tilemanager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }
                break;

        }

    }
    public int CheckObj(Entity entity, boolean player)
    {
        int index =999;

        for(int i=0;i<gp.objs.length;i++) {
            if (gp.objs[i] != null) {
                //Entity
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                //Item
                gp.objs[i].solidArea.x = gp.objs[i].WorldX + gp.objs[i].solidArea.x;
                gp.objs[i].solidArea.y = gp.objs[i].WorldY + gp.objs[i].solidArea.y;


                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;

                        if (entity.solidArea.intersects(gp.objs[i].solidArea)) {
                            if(gp.objs[i].collision)
                                entity.collisionOn = true;
                            if(player)
                            {
                                index =i;
                            }

                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;

                        if (entity.solidArea.intersects(gp.objs[i].solidArea)) {
                            if(gp.objs[i].collision)
                                entity.collisionOn = true;
                            if(player)
                            {
                                index =i;
                            }

                        }
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.objs[i].solidArea)) {
                            if(gp.objs[i].collision)
                                entity.collisionOn = true;
                            if(player)
                            {
                                index =i;
                            }

                        }
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.objs[i].solidArea)) {
                            if(gp.objs[i].collision)
                                entity.collisionOn = true;
                            if(player)
                            {
                                index =i;
                            }

                        }
                        break;

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.objs[i].solidArea.x = gp.objs[i].solidAreaDefaultX;
                gp.objs[i].solidArea.y = gp.objs[i].solidAreaDefaultY;
            }
        }


        return index;
    }
}
