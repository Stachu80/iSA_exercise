package mstasinski.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Resize {


    public static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        int IMG_WIDTH = originalImage.getWidth() / 2;
        int IMG_HEIGHT = originalImage.getHeight() / 2;

        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }
}
