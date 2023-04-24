package com.group7.view.sfx;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class sfxController {
    Clip clip;
    AudioInputStream audioInputStream;
    String filePath;

    public sfxController(){}


    public void cardFlip(){
        filePath = "src/main/java/com/group7/view/sfx/cardFlip.wav";
        playSound(filePath);
    }

    public void acknowledge(){
        filePath = "src/main/java/com/group7/view/sfx/ack.wav";
        playSound(filePath);
    }
    public void playSound(String filePath){
        // create AudioInputStream object
        try {
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create clip reference
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        // open audioInputStream to the clip
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        clip.start();
    }

}
