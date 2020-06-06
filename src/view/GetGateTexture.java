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
        String fileName = null;
        if (gate instanceof AND) {
            fileName = "src/Resources/GateTextures/AND.png";
        } else if (gate instanceof Light) {
            if (gate.evaluate()) {
                fileName = "src/Resources/GateTextures/LIGHT_ON.png";
            } else {
                fileName = "src/Resources/GateTextures/LIGHT_OFF.png";
            }
        } else if (gate instanceof NOT) {
            fileName = "src/Resources/GateTextures/NOT.png";
        } else if (gate instanceof OR) {
            fileName = "src/Resources/GateTextures/OR.png";
        } else if (gate instanceof XOR) {
            fileName = "src/Resources/GateTextures/XOR.png";
        } else if (gate instanceof Chip) {
            fileName = "src/Resources/GateTextures/Chip.png";
        } else if (gate instanceof Source) {
            fileName = "src/Resources/GateTextures/Source.png";
        }
        try {
            File imgFile = new File(fileName);
            texture = ImageIO.read(imgFile);
        } catch (IOException ioe) {
            System.err.println("Could not load " + fileName);
        }
        return texture;
    }

    public static BufferedImage getGlowTexture(Gate gate) {
        BufferedImage texture = null;
        String fileName = null;
        if (gate instanceof AND) {
            fileName = "src/Resources/GateTextures/GLOW_AND.png";
        } else if (gate instanceof Light) {
            fileName = "src/Resources/GateTextures/GLOW_WHITE.png";
        } else if (gate instanceof NOT) {
            fileName = "src/Resources/GateTextures/GLOW_NOT.png";
        } else if (gate instanceof OR) {
            fileName = "src/Resources/GateTextures/GLOW_OR.png";
        } else if (gate instanceof XOR) {
            fileName = "src/Resources/GateTextures/GLOW_XOR.png";
        } else if (gate instanceof Chip) {
            fileName = "src/Resources/GateTextures/GLOW_CIRCUIT.png";
        } else if (gate instanceof Source) {
            fileName = "src/Resources/GateTextures/GLOW_WHITE.png";
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

    public static BufferedImage makeDarker(BufferedImage img) {
        WritableRaster raster = img.getRaster();
        for (int xx = 0; xx < raster.getWidth(); xx++) {
            for (int yy = 0; yy < raster.getHeight(); yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = 3*pixels[0] / 5;
                pixels[1] = 3*pixels[1] / 5;
                pixels[2] = 3*pixels[2] / 5;
                raster.setPixel(xx, yy, pixels);
            }
        }
        return img;
    }

    public static BufferedImage makeRed(BufferedImage img) {
        WritableRaster raster = img.getRaster();
        for (int xx = 0; xx < raster.getWidth(); xx++) {
            for (int yy = 0; yy < raster.getHeight(); yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = 255;
                pixels[1] = 75;
                pixels[2] = 75;
                raster.setPixel(xx, yy, pixels);
            }
        }
        return img;
    }
}
