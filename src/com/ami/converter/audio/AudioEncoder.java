/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ami.converter.audio;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrias
 */
public class AudioEncoder {

    /**
     *
     * @param sourcePath
     * @param destinationPath
     * @throws it.sauronsoftware.jave.EncoderException
     */
    
    public void encode(String sourcePath, String destinationPath) throws IllegalArgumentException, EncoderException {
        String type=destinationPath.substring(destinationPath.lastIndexOf(".")+1);
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        Encoder encoder;
        encoder = new Encoder();
        AudioAttributes audio;
        audio = new AudioAttributes();
        
        EncodingAttributes attrs;
        attrs = new EncodingAttributes();
        attrs.setFormat(destinationPath.substring(destinationPath.lastIndexOf(".") + 1));
        attrs.setAudioAttributes(audio);
        for(String enc : encoder.getAudioEncoders())
        {
            if(enc.contains(type))
            {
                audio.setCodec(enc);
            }
        }
       
        encoder.encode(sourceFile, destinationFile, attrs);
    }
}
