/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ami.converter.video;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;
import java.io.File;

/**
 *
 * @author Andrias
 */
public class VideoEncoder {

    /**
     *
     * @param sourcePath
     * @param destinationPath
     * @throws IllegalArgumentException
     * @throws EncoderException
     */
    public void encode(String sourcePath, String destinationPath) throws IllegalArgumentException, EncoderException {
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        
        VideoAttributes video;
        video = new VideoAttributes();
        video.setCodec("codecName");
        EncodingAttributes attrs;
        attrs = new EncodingAttributes();
        attrs.setFormat(destinationPath.substring(destinationPath.lastIndexOf(".") + 1));
        attrs.setVideoAttributes(video);
        
        Encoder encoder;
        encoder = new Encoder();
        encoder.encode(sourceFile, destinationFile, attrs);
    }
}
