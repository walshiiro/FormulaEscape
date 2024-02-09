package Main;

import Entity.NPC_NigCat;
import Objects.Boots;
import Objects.Chest;
import Objects.OBJ_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;


    }
    public void setObject()
    {
        gp.objs[0]= new OBJ_Key();
        gp.objs[0].worldX = 30*gp.tileSize;
        gp.objs[0].worldY = 23*gp.tileSize;

        gp.objs[1] = new Chest();
        gp.objs[1].worldX = 25*gp.tileSize;
        gp.objs[1].worldY = 30*gp.tileSize;

        gp.objs[2] = new Boots();
        gp.objs[2].worldX = 15*gp.tileSize;
        gp.objs[2].worldY = 30*gp.tileSize;
    }
    public void setNPC()
    {
    gp.npc[0] = new NPC_NigCat(gp);
    gp.npc[0].worldX= 50*gp.tileSize;
    gp.npc[0].worldY = 95*gp.tileSize;

    }
}
