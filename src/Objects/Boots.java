package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Boots extends SuperObjects{
    public Boots()
    {
        name ="Boots";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Items/diamond_boots.png"));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        collision=true;
    }
}
