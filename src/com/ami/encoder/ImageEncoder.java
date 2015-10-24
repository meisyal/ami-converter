/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ami.encoder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS-PC
 */
public class ImageEncoder {
    String filetype;
    public int encode(String sourcePath, String destinationPath) throws IOException{
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(sourceFile);
        ImageIO.write(bufferedImage, destinationPath.substring(destinationPath.lastIndexOf(".")+1), destinationFile);
        return 0;
    }
    
}
