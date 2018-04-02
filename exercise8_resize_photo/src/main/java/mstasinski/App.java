package mstasinski;

import mstasinski.util.Resize;
import mstasinski.util.Resize;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(new File("D:\\AKADEMIA_INFO_SHARE_NEW\\exercise\\photo\\photoIn.jpg"));
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            BufferedImage resizeImageJpg = Resize.resizeImage(originalImage, type);
            ImageIO.write(resizeImageJpg, "jpg", new File("D:\\AKADEMIA_INFO_SHARE_NEW\\exercise\\photo\\photoOut.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
