/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ami.converter;

import it.sauronsoftware.jave.EncoderException;
import com.ami.converter.image.ImageEncoder;
import com.ami.converter.audio.AudioEncoder;
import com.ami.converter.video.VideoEncoder;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Afina, Meisyal, Irfan
 */
public class MainGUI extends javax.swing.JFrame {
    int type;
    int count[];
    long sourceSize;
    long destSize;
    String[][] inputExtension;
    String[][][] outputExtension;
    String[][] videoCodec;
    String[][] audioCodec;
    String[] audioBitRate;
    String[] videoBitRate;
    String selectedCodec;
    File currOpen;
    File currSave;
    
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        this.count = new int[3];
        count[0] = 3;
        count[1] = 6;
        count[2] = 5;
        
        this.inputExtension = new String[][]{{"Bitmap image files", "Wave audio files", 
            "Avi video files"}, {"bmp", "wav", "avi"}};
        this.outputExtension = new String[][][]{{{"JPEG image files", "PNG image files", 
            "GIF image files"}, {"MP3 audio files", "AAC audio files", "MP2 audio files",
            "FLAC audio files", "OGG audio files", "WMA audio files"}, {"MPEG video files",
            "MPEG2 video files", "h.264/MPEG4 AVC video files", "FLV video files",
            "WMV video files"}}, {{"jpg", "png", "gif"}, {"mp3", "aac", "mp2", "flac",
            "ogg", "asf"}, {"vob", "vob", "mp4", "flv", "asf"}}};
        
        this.audioCodec = new String[][]{{"MP3", "AAC", "MP2", "FLAC", "OGG", "WMA"},
            {"libmp3lame", "libfaac", "mp2", "flac", "libvorbis", "wmav2"}};
        this.videoCodec=new String[][]{{"MPEG", "MPEG2", "h.264/MPEG4", "FLV", "WMV"},
            {"mpeg1video", "mpeg2video", "mpeg4", "flv", "wmv2"}};
        
        this.audioBitRate = new String[]{"16", "24", "32", "48", "64", "96",
            "128", "192", "256", "320"};
        this.videoBitRate = new String[]{"128", "400", "750", "1000", "2500",
            "3800", "4500", "6800", "9800"};
        
        setLocationRelativeTo(null);
        setTitle("AMI Converter");
        CmdConvert.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        CboType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TxtSource = new javax.swing.JTextField();
        CmdBrowse1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TxtDestination = new javax.swing.JTextField();
        CmdBrowse2 = new javax.swing.JButton();
        CmdConvert = new javax.swing.JButton();
        CmdExit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        PGBar = new javax.swing.JProgressBar();
        jSeparator6 = new javax.swing.JSeparator();
        LblResult = new javax.swing.JLabel();
        LblSize2 = new javax.swing.JLabel();
        LblSize1 = new javax.swing.JLabel();
        CmdOpen = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compression Result");
        setLocationByPlatform(true);
        setResizable(false);

        CboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Image", "Audio", "Video" }));
        CboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboTypeActionPerformed(evt);
            }
        });

        jLabel1.setText("Multimedia type:");

        jLabel2.setText("Source file");

        TxtSource.setEditable(false);
        TxtSource.setText("Choose a source file by clicking the \"Browse...\" button");
        TxtSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSourceActionPerformed(evt);
            }
        });
        TxtSource.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtSourcePropertyChange(evt);
            }
        });

        CmdBrowse1.setText("Browse...");
        CmdBrowse1.setToolTipText("");
        CmdBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdBrowse1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Destination file");

        TxtDestination.setEditable(false);
        TxtDestination.setText("Choose a destination file by clicking the \"Browse...\" button");
        TxtDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDestinationActionPerformed(evt);
            }
        });

        CmdBrowse2.setText("Browse...");
        CmdBrowse2.setEnabled(false);
        CmdBrowse2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdBrowse2ActionPerformed(evt);
            }
        });

        CmdConvert.setText("Convert");
        CmdConvert.setEnabled(false);
        CmdConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdConvertActionPerformed(evt);
            }
        });

        CmdExit.setText("Exit");
        CmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdExitActionPerformed(evt);
            }
        });

        jLabel4.setText("Copyright © 2015 AMI - Rahmat Irfan (5112100008), Andrias Meisyal (5112100116), and Afina Lina Nurlaili (5112100171)");

        jLabel5.setText("Compression Result/Rate:");

        jLabel6.setText("Original file size is");

        jLabel7.setText("Compressed file size is");

        LblSize2.setText("KiB");

        LblSize1.setText("KiB");

        CmdOpen.setText("Open");
        CmdOpen.setEnabled(false);
        CmdOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdOpenActionPerformed(evt);
            }
        });

        jLabel8.setText("0 %");

        jLabel9.setText("Bitrate control");

        jLabel10.setText("kb/s");

        jLabel11.setText("Frame-rate");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "15", "25", "30", "50", "60" }));

        jLabel12.setText("frame/s");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose bitrate..." }));

        jLabel13.setText("Execution time:");

        jLabel14.setText("0 s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6)
                    .addComponent(PGBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TxtSource, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtDestination, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(CmdOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CmdConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CmdBrowse1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CmdBrowse2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CmdExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblSize2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblSize1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(CmdBrowse1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmdBrowse2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(22, 22, 22)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmdExit)
                    .addComponent(CmdConvert)
                    .addComponent(CmdOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PGBar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LblResult)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LblSize1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(LblSize2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmdBrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdBrowse1ActionPerformed
        JFileChooser OPF;
        OPF = new JFileChooser();
        
        if (currOpen != null) {
            OPF.setCurrentDirectory(currOpen);
        }
        
        FileFilter fileFilterExt = new FileNameExtensionFilter(inputExtension[0][type], 
                inputExtension[1][type]);
        OPF.addChoosableFileFilter(fileFilterExt);
        for (int i = 0; i < count[type]; i++) {
            FileNameExtensionFilter fileFilter;
            fileFilter = new FileNameExtensionFilter(outputExtension[0][type][i],
                    outputExtension[1][type][i]);
            OPF.addChoosableFileFilter(fileFilter);
        }
        
        OPF.setAcceptAllFileFilterUsed(false);
        int result = OPF.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {   
            TxtSource.setText(OPF.getSelectedFile().getPath());
            File selectedFile = OPF.getSelectedFile();
            // user OPF a file
            
            // disable convert button when there isn't selectedCodec file
            if (selectedFile != null && selectedFile.isFile()) {
                // get original file size
                String originalSize = getFileSize(selectedFile);
                sourceSize = selectedFile.length();
                LblSize1.setText(originalSize);
                CmdBrowse2.setEnabled(true);
                CmdConvert.setEnabled(false);
                CmdOpen.setEnabled(false);   
            }
            
            currOpen = OPF.getCurrentDirectory();
        } else {
            currOpen = OPF.getCurrentDirectory();
        }
        
        PGBar.setValue(PGBar.getMinimum());
        jLabel14.setText("0 s");
    }//GEN-LAST:event_CmdBrowse1ActionPerformed

    private void CboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboTypeActionPerformed
         type = CboType.getSelectedIndex();
         DefaultComboBoxModel audioModel = new DefaultComboBoxModel(audioBitRate);
         DefaultComboBoxModel videoModel = new DefaultComboBoxModel(videoBitRate);
         
         if (type == 0) {
             jComboBox2.setEnabled(false);
         } else if (type == 1) {
             jComboBox2.setModel(audioModel);
             jComboBox2.setEnabled(true);
             jComboBox1.setEnabled(false);
         } else {
             jComboBox2.setModel(videoModel);
             jComboBox2.setEnabled(true);
             jComboBox1.setEnabled(true);
         }
    }//GEN-LAST:event_CboTypeActionPerformed

    private void TxtDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDestinationActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TxtDestinationActionPerformed

    private void CmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdExitActionPerformed
        // Exit from program
        System.exit(0);
    }//GEN-LAST:event_CmdExitActionPerformed

    private void CmdConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdConvertActionPerformed
        long startTime = System.nanoTime();
        
        if (type == 0) {
            ImageEncoder imgEnc;
            imgEnc = new ImageEncoder();
            
            try {
                imgEnc.encode(TxtSource.getText(), TxtDestination.getText());
            } catch (IOException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (type == 1) {
            AudioEncoder audEnc;
            audEnc = new AudioEncoder();

            audEnc.setCodec(selectedCodec);
            System.out.println(selectedCodec);
            
            try {
                audEnc.encode(TxtSource.getText(), TxtDestination.getText(),
                        jComboBox2.getSelectedItem().toString());
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncoderException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            VideoEncoder vidEnc;
            vidEnc = new VideoEncoder();
            vidEnc.setCodec(selectedCodec);
            
            try {
                vidEnc.encode(TxtSource.getText(), TxtDestination.getText(),
                        jComboBox2.getSelectedItem().toString(),
                        jComboBox1.getSelectedItem().toString());
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncoderException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInSecond = (double) duration / 1000000000.0;
        
        PGBar.setValue(PGBar.getMaximum());
        jLabel14.setText(String.valueOf(durationInSecond) + " s");
        CmdOpen.setEnabled(true);
        
        File selectedFile = new File(TxtDestination.getText());
        
        if (selectedFile != null && selectedFile.isFile()) {
            // get compressed file size
            String compressedSize = getFileSize(selectedFile);
            destSize = selectedFile.length();
            LblSize2.setText(compressedSize);
        }
        
        getCompressionRatio();
    }//GEN-LAST:event_CmdConvertActionPerformed

    private void CmdBrowse2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdBrowse2ActionPerformed
        JFileChooser SPF;
        SPF = new JFileChooser();
        
        if (currSave != null) {
            SPF.setCurrentDirectory(currSave);
        }
        
        for (int i = 0; i < count[type]; i++) {
            FileNameExtensionFilter fileFilter;
            fileFilter = new FileNameExtensionFilter(outputExtension[0][type][i],
                    outputExtension[1][type][i]);
            SPF.addChoosableFileFilter(fileFilter);
        }
        
        SPF.setAcceptAllFileFilterUsed(false);
        int result = SPF.showSaveDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            CmdConvert.setEnabled(true);
            FileNameExtensionFilter selectedFilter; 
            selectedFilter = (FileNameExtensionFilter) SPF.getFileFilter();
            
            for (String ext : selectedFilter.getExtensions()) {
                System.out.println(ext);
            }
            
            if (!SPF.getSelectedFile().getPath().endsWith(selectedFilter.getExtensions()[0])) {
                TxtDestination.setText(SPF.getSelectedFile().getPath() + "." + 
                        selectedFilter.getExtensions()[0]);
            } else {
                TxtDestination.setText(SPF.getSelectedFile().getPath());
            }

            if (type == 2) {
                for (int j = 0; j < count[2]; j++) {
                    if (selectedFilter.getDescription().contains(videoCodec[0][j])) {
                        selectedCodec = videoCodec[1][j];
                    }
                }
            } else if (type == 1) {
                for (int j = 0; j < count[1]; j++){
                    if(selectedFilter.getDescription().contains(audioCodec[0][j])) {
                        selectedCodec = audioCodec[1][j];
                    }
                }
            }
            
            System.out.println(TxtDestination.getText().substring(
                    TxtDestination.getText().lastIndexOf(".") + 1));
            
            File selectedFile = SPF.getSelectedFile();
            currSave = SPF.getCurrentDirectory();
            // user OPF a file
        }
        else {
            currSave = SPF.getCurrentDirectory();
        }
    }//GEN-LAST:event_CmdBrowse2ActionPerformed

    private void CmdOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdOpenActionPerformed
        try {
            Desktop.getDesktop().open(new File(TxtDestination.getText()));
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CmdOpenActionPerformed

    private void TxtSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSourceActionPerformed

    private void TxtSourcePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtSourcePropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TxtSourcePropertyChange
    
    private String getFileSize(File selectedFile) {
        double bytes = selectedFile.length();
        
        final String[] units = new String[]{"Bi", "KiB", "MiB", "GiB", "TiB"};
        int digitGroups = (int) (Math.log10((bytes))/(Math.log10(1024)));
        DecimalFormat df = new DecimalFormat("#,##0.#");
        String convertedSize = df.format(bytes/Math.pow(1024, digitGroups)) +
                " " + units[digitGroups];
        
        return convertedSize;
    }
    
    private void getCompressionRatio() {
        String originalSizeText;
        originalSizeText = LblSize1.getText();
        String compressedSizeText;
        compressedSizeText = LblSize2.getText();
        
        double originalSizeValue;
        originalSizeValue = (double) sourceSize;
        
        double compressedSizeValue;
        compressedSizeValue = (double) destSize;
        
        double compressionRatio;
        compressionRatio = (compressedSizeValue / originalSizeValue) * 100.0;
        
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        
        jLabel8.setText(String.valueOf(df.format(compressionRatio) + " %"));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CboType;
    private javax.swing.JButton CmdBrowse1;
    private javax.swing.JButton CmdBrowse2;
    private javax.swing.JButton CmdConvert;
    private javax.swing.JButton CmdExit;
    private javax.swing.JButton CmdOpen;
    private javax.swing.JLabel LblResult;
    private javax.swing.JLabel LblSize1;
    private javax.swing.JLabel LblSize2;
    private javax.swing.JProgressBar PGBar;
    private javax.swing.JTextField TxtDestination;
    private javax.swing.JTextField TxtSource;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    // End of variables declaration//GEN-END:variables
}
