# ami-converter

**ami-converter** is a desktop-based multimedia converter. Multimedia itself
contains data or information such as text, image, audio, and video. This
application can convert the natural form of multimedia to the converted one(s).
The natural form of multimedia that supported by the application is described
as follows:

* Image: Bitmap (BMP), JPEG, PNG, and GIF image files
* Audio: Wave (WAV), MP2, MP3, AAC, FLAC, OGG, and WMA audio files
* Video: Avi (AVI), MPEG-1, MPEG-2, H.264/MPEG-4 AVC, FLV, and WMV video files

If you choose the audio file, you can control the bitrate. Bitrate is from 16 to
320 kbps. Then, if you choose the video file, you can set not only the bitrate
but also the frame-rate. The frame-rate is from 15 to 60 fps. 

Beside that, this application gives you the information about multimedia file.
This information contains the original size of file, the compressed size,
compression rate/ratio, and time of execution when the conversion is performed.

Screenshot of ami-converter is given below

<img src="http://static.meisyal.web.id/images/misc/ami-converter.png" />

## How to Run

### Requirements

This project needs Java Development Kit (JDK), we recommend version 8 or any latest
version, and JAVE. JAVE (Java Audio Video Encoder) library is Java wrapper on the
[ffmpeg][ffmpeg] project. See, details of JAVE library [here][jave].

This program runs on both Windows and Linux. We have tested on Windows and Ubuntu 14.04.
So, you have to adjust your envinroment in order the program can run properly. Feel
free to e-mail us or submit an [issue][issue] if you have any problem.

### Running the Program

Please, follow the steps below:

1. Clone this repository on your local computer.
2. Import the cloned source code into NetBeans IDE*.
3. Add JAVE library on your Java `classpath`.
4. Build and run the program.

* If you use another Java IDE such as Intellij IDEA and Eclispe, you should adjust this
step.

## License

This project is released under MIT License. Please, check [LICENSE][license] file for
more information. JAVE library is Free Software and it is licensed under GPL. All
other contents are redistributed their original license terms.

ami-converter is originally multimedia network assignment (coding project). Multimedia
Network course, class of 2015, [Department of Informatics][ifits], [Institut Teknologi
Sepuluh Nopember][its] Surabaya.

Copyright © 2015 - Afina, Meisyal, and Irfan.

[ffmpeg]: http://ffmpeg.mplayerhq.hu/
[jave]: http://www.sauronsoftware.it/projects/jave/index.php
[issue]: https://github.com/meisyal/ami-converter/issues
[license]: https://github.com/meisyal/ami-converter/blob/master/LICENSE
[ifits]: http://if.its.ac.id
[its]: https://its.ac.id
