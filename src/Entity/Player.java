package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Rectangle;
import java.security.Key;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler KeyH;
    public final int screenX;
    public final int screenY;
   public int Keycount =0;

    public Player(GamePanel gp, KeyHandler KeyH)
    {
        this.gp = gp;
        this.KeyH = KeyH;
        setDefaultValue();
        getPlayerImage();
        screenX=gp.screenWidth/2 - (gp.tileSize/2);
        screenY=gp.screenHeight/2 - (gp.tileSize/2);
        solidArea = new Rectangle(12,18,10,8);
        solidAreaDefaultX = 12;
        solidAreaDefaultY = 8;


    }




    public void setDefaultValue()
    {
        worldX = gp.tileSize*15;
        worldY= gp.tileSize*10;
        speed=3;
        direction="down";

    }
  public void getPlayerImage()
    {


        try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/behind1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/behind2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/front1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/front2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            idle = ImageIO.read(getClass().getResourceAsStream("/player/idle.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/idle2.png"));


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    public void update()
    {
        if(KeyH.goUp || KeyH.goDown || KeyH.goLeft || KeyH.goRight )
        {
        if(KeyH.goUp == true)
        {
           direction="up";


        }
        if(KeyH.goDown == true)
        {
            direction="down";


        }
        if(KeyH.goLeft == true)
        {
            direction="left";


        }
        if(KeyH.goRight == true)
        {
            direction="right";


        }
        collisionOn = false;
        gp.cChecker.CheckTile(this);
       int objCheck = gp.cChecker.CheckObj(this,true);
        pickUpWeapon(objCheck);


        if(collisionOn==false)
        {
            switch (direction)
            {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;


            }
        }


        spriteCounter++;
        if(spriteCounter>15) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        }
       /* else {
            direction="idle";
            spriteCounter=14;
            if(spriteCounter>15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } */


    }
    public void pickUpWeapon(int i)
    {
        if(i != 999)
        {
            String objectName = gp.objs[i].name;
            switch (objectName)
            {
                case "Key":
                    Keycount++;
                    gp.objs[i]=null;
                    gp.Ui.showNotification("You got a key!");
                    break;
                case "Chest":
                    if(Keycount>0) {
                        Keycount--;
                        gp.objs[i] = null;
                    }

                    break;
                case "Boots":


                    speed+=2;
                    gp.objs[i]=null;

                    break;



            }
        }
    }

    public void draw(Graphics2D g2)
    {
     //  g2.setColor(Color.white);

     //  g2.fillRect(playerX,playerY,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }

                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }

                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }

                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
           /*case "idle": {
                if (spriteNum == 1) {
                    image = idle;
                }
                if (spriteNum == 2) {
                    image = idle2;
                }

                break;
            } */
        }
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }
}
