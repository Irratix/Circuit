package view;

import model.Gate;
import model.Gates.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
}
