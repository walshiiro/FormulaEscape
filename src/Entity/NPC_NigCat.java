package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPC_NigCat extends Entity{

    public NPC_NigCat(GamePanel gp)
    {
        super(gp);

        direction="down1";
        speed=2;
        getNPCImage();

    }
    public void getNPCImage()
    {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/npc/behind1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/npc/behind2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/front1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/npc/front2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/npc/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/npc/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/npc/rright1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/npc/right2.png"));
        } catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
