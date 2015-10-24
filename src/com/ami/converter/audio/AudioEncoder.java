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
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        
        AudioAttributes audio;
        audio = new AudioAttributes();
        audio.setCodec("codecName");
        EncodingAttributes attrs;
        attrs = new EncodingAttributes();
        attrs.setFormat(destinationPath.substring(destinationPath.lastIndexOf(".") + 1));
        attrs.setAudioAttributes(audio);
        
        Encoder encoder;
        encoder = new Encoder();
        encoder.encode(sourceFile, destinationFile, attrs);
    }
}
