package Entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX,worldY,speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,idle,idle2;
    public String direction;

    public int spriteCounter=0;
    public int spriteNum =1;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn = false;
    public Entity(GamePanel gp)
    {
        this.gp = gp;
    }
    public void draw(Graphics2D g2, GamePanel gp)
    {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        if(worldX + gp.tileSize > gp.player.worldX -gp.player.screenX &&
                worldX -gp.tileSize <gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.tileSize + - gp.player.screenY
                && worldY -gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }


}
