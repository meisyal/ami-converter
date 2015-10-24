/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ami.converter.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

/**
 *
 * @author Andrias
 */
public class JpegEncoder {

    /**
     *
     * @param sourcePath
     * @param destinationPath
     * @throws IOException
     */
    public void encodeJpeg(String sourcePath, String destinationPath) throws IOException {
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(sourceFile);
        
        Iterator iter;
        iter = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter writer;
        writer = (ImageWriter) iter.next();
        ImageWriteParam iwp;
        iwp = writer.getDefaultWriteParam();
        
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality(1);
        
        FileImageOutputStream output;
        output = new FileImageOutputStream(destinationFile);
        writer.setOutput(output);
        
        IIOImage image;
        image = new IIOImage(bufferedImage, null, null);
        writer.write(null, image, iwp);
        writer.dispose();
    }
}
