package sudoku;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public enum SoundEffect {
    BACKGROUND("sudoku/audio/background.wav"),
    COMPLETE("sudoku/audio/complete.wav"),
    CORRECT("sudoku/audio/correct.wav"),
    WRONG("sudoku/audio/wrong.wav");

    /** Nested enumeration for specifying volume */
    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH
    }

    public static Volume volume = Volume.MEDIUM;

    /** Each sound effect has its own clip, loaded with its own sound file. */
    private Clip clip;

    /** Private constructor to construct each element of the enum with its own sound file. */
    private SoundEffect(String soundFileName) {
        try {
            // Use URL (instead of File) to read from disk and JAR.
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            if (url == null) {
                throw new IllegalArgumentException("Couldn't find file: " + soundFileName);
            }
            // Set up an audio input stream piped from the sound file.
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /** Play or replay the sound effect from the beginning, by rewinding. */
    public void play() {
        if (volume != Volume.MUTE) {
            if (clip.isRunning()) {
                clip.stop(); // Stop the player if it is still running
            }
            clip.setFramePosition(0); // Rewind to the beginning
            clip.start(); // Start playing
        }
    }

    /** Loop the sound effect continuously. */
    public void loop() {
        if (volume != Volume.MUTE) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0); // Rewind to the beginning
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Play in loop
        }
    }

    /** Stop the currently playing sound effect. */
    public void stop() {
        if (clip.isRunning()) {
            clip.stop(); // Stop the clip if it's running
        }
    }

    /** Optional static method to pre-load all the sound files. */
    static void initSounds() {
        values(); // Calls the constructor for all the elements
    }
}