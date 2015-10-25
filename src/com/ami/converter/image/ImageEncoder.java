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
 * @author ASUS-PC
 */
public class ImageEncoder {

    /**
     *
     * @param sourcePath
     * @param destinationPath
     * @throws IOException
     */
    public void encode(String sourcePath, String destinationPath) throws IOException{
        String formatType = destinationPath.substring(destinationPath.lastIndexOf(".") + 1);
                
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(sourceFile);
        ImageIO.write(bufferedImage, formatType, destinationFile);
    }
}
