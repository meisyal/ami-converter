# ami-converter

**ami-converter** is a desktop-based multimedia converter. Multimedia itself
contains data or information such as text, image, audio, and video. This
application can convert the natural form of multimedia to the converted one(s).
The natural form of multimedia that supported by the application is described
as follows:

* Image: Bitmap (BMP), JPEG, PNG, and GIF image files
* Audio: Wave (WAV), MP2, MP3, AAC, FLAC, OGG, and WMA audio files
* Video: Avi (AVI), MPEG-1, MPEG-2, H.264/MPEG-4 AVC, FLV, and WMV video files

If you choose the audio file, you can choose the bitrate. Bitrate is from 16 to
320 kbps. Then, if you choose the video file, you can set not only bitrate but
also frame-rate. Frame-rate is from 15 to 60 fps. 

Beside that, this application gives you the information about multimedia file.
This information contains the original size of file, the compressed size,
compression rate/ratio, and time of execution when the conversion is performed.

## How to Run

### Requirements

This project need Java Development Kit (JDK), we recommend version 8 or any latest
version, and JAVE. JAVE (Java Audio Video Encoder) library is Java wrapper on the
[ffmpeg][ffmpeg] project. See, details of JAVE library [here][jave].

This program run on both Windows and Linux. We have tested on Windows and Ubuntu 14.04.
So, you have to adjust your envinroment in order the program can run properly.

### Running the Program

Please, follow the steps below:

1. Clone this repository on your local computer.
2. Import the cloned source code into NetBeans IDE.
3. Add JAVE library on your Java `classpath`.
4. Build and run the program.

## License

This project is released under MIT License. Please, check [LICENSE][license] file for
more information. All other contents are redistributed their original license
terms.

ami-converter is originally multimedia network assignment.

Copyright (C) 2015 - Afina, Meisyal, and Irfan.

[ffmpeg]: http://ffmpeg.mplayerhq.hu/
[jave]: http://www.sauronsoftware.it/projects/jave/index.php
[license]: https://github.com/meisyal/ami-converter/blob/master/LICENSE