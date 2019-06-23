package view;

import model.Gate;
import model.Gates.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

abstract public class GetGateTexture {

    public static BufferedImage getTexture (Gate gate) {
        BufferedImage texture = null;
        String fileName = "src/Resources/GateTextures/Source.png";
        if (gate instanceof AND) {
            fileName = "src/Resources/GateTextures/AND.png";
        } else if (gate instanceof Light) {
            fileName = "src/Resources/GateTextures/Light.png";
        } else if (gate instanceof NOT) {
            fileName = "src/Resources/GateTextures/NOT.png";
        } else if (gate instanceof OR) {
            fileName = "src/Resources/GateTextures/OR.png";
        }
        try {
            File imgFile = new File(fileName);
            texture = ImageIO.read(imgFile);
        } catch (IOException ioe) {
            System.err.println("Could not load " + fileName);
        }
        return texture;
    }

    public static BufferedImage replaceColor(BufferedImage img, Color initial, Color replacement) {
        WritableRaster raster = img.getRaster();
        for (int xx = 0; xx < raster.getWidth(); xx++) {
            for (int yy = 0; yy < raster.getHeight(); yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                if (pixels[0] == initial.getRed()
                        && pixels[1] == initial.getGreen()
                        && pixels[2] == initial.getBlue()) {
                    pixels[0] = replacement.getRed();
                    pixels[1] = replacement.getGreen();
                    pixels[2] = replacement.getBlue();
                    raster.setPixel(xx, yy, pixels);
                }
            }
        }
        return img;
    }
}
