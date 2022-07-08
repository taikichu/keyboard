package keyboard;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class player {
    Long nowFrame;
    Clip clip;

    String thestatus;

    AudioInputStream audioStream;
    public player(String thePath)
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        audioStream =
                AudioSystem.getAudioInputStream(
                        new File(thePath)
                                .getAbsoluteFile());
        clip = AudioSystem.getClip();

        clip.open(audioStream);

        clip.loop(0);
    }
    public void play()
    {
        clip.start();

    }
}