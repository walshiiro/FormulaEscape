package Main;

import Objects.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.Key;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage KeyImage;
    public String meesaage="";
    public boolean messageOn = false;
    int notiCount=0;
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN,25);
        OBJ_Key Key = new OBJ_Key();
        KeyImage = Key.image;


    }
    public void showNotification(String text)
    {
        meesaage=text;
         messageOn=true;
    }
    public void draw(Graphics2D g2)
    {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(KeyImage, gp.tileSize/2, gp.tileSize/2,gp.tileSize,gp.tileSize,null);

        g2.drawString("x "+gp.player.Keycount,90,50);

        if(messageOn)
        {
            notiCount++;
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(meesaage,gp.tileSize/2,gp.tileSize*5);
            if(notiCount>120)
            {
                messageOn=false;
                notiCount=0;
            }

        }

    }
}
