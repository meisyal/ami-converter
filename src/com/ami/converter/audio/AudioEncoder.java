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
    private String codec;
    public void encode(String sourcePath, String destinationPath, String bitRate) throws IllegalArgumentException, EncoderException {
        String formatType = destinationPath.substring(destinationPath.lastIndexOf(".") + 1);
        int bitrate = Integer.parseInt(bitRate);
        
        File sourceFile;
        sourceFile = new File(sourcePath);
        File destinationFile;
        destinationFile = new File(destinationPath);
        Encoder encoder;
        encoder = new Encoder();
        AudioAttributes audio;
        audio = new AudioAttributes();
        audio.setBitRate(bitrate);
        EncodingAttributes attrs;
        attrs = new EncodingAttributes();
        attrs.setFormat(formatType);
        attrs.setAudioAttributes(audio);

        if (!getCodec().isEmpty()) {
            audio.setCodec(codec);
        } else {
            for (String enc : encoder.getAudioEncoders()) {
                if (enc.contains(formatType)) {
                    audio.setCodec(enc);
                }
            }
        }
      
        encoder.encode(sourceFile, destinationFile, attrs);
    }

    /**
     * @return the codec
     */
    public String getCodec() {
        return codec;
    }

    /**
     * @param Codec the codec to set
     */
    public void setCodec(String Codec) {
        this.codec = Codec;
    }
}
