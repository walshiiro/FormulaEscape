package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest extends SuperObjects {
    public Chest()
    {
        name = "Chest";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Items/chest.png"));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;



    }

}
