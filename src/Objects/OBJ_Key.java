package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends SuperObjects {
    public OBJ_Key()
    {
        name = "Key";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Items/key.png"));
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }




    }

}
