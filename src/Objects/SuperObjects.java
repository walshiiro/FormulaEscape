package Objects;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObjects {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int WorldX, WorldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY =0;
    public void draw(Graphics2D g2, GamePanel gp)
    {
        int screenX = WorldX - gp.player.worldX + gp.player.screenX;
        int screenY = WorldY - gp.player.worldY + gp.player.screenY;
        if(WorldX + gp.tileSize > gp.player.worldX -gp.player.screenX &&
                WorldX -gp.tileSize <gp.player.worldX + gp.player.screenX &&
                WorldY + gp.tileSize > gp.tileSize + - gp.player.screenY
                && WorldY -gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
