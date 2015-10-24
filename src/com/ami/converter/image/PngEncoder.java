/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ami.converter.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Andrias
 */
public class PngEncoder {

    /**
     *
     * @param sourcePath
     * @param destinationPath
     * @throws IOException
     */
    public void encodePng(String sourcePath, String destinationPath) throws IOException {
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(sourceFile);
        
        ImageIO.write(bufferedImage, "png", destinationFile);
    }
}
