package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UtilityTool {
    public BufferedImage scaleImage(BufferedImage original, int w, int h)
    {
        BufferedImage scaleImage = new BufferedImage(w,h,original.getType());
        Graphics2D g2 = scaleImage.createGraphics();
        g2.drawImage(original,0,0,w,h,null);
        g2.dispose();
        return scaleImage;

    }

}
