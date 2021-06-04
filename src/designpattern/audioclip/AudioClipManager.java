package designpattern.audioclip;

import java.applet.AudioClip;

/**
 * This class can be used to avoid playing two audio clips at the same
 * time.  The class has only one instance that can be accessed through
 * its getInstance method.  When you play audio clips through that
 * object, it stops the last audio clip it was playing before
 * it starts the newly requested one.  If all audio clips are played
 * through the AudioClipManager object then there will never be more
 * than one audio clip playing at the same time.
 */
public class AudioClipManager implements AudioClip {

    //PATTERN: SINGLETON

    //privates static final attrubute! -> nur eine Instanz global möglich
    private static final AudioClipManager myInstance = new AudioClipManager();

    /**
     * The previously requested audio clip.
     */
    private AudioClip prevClip;

    //privater Konstruktor
    private AudioClipManager() {}

    public static AudioClipManager getInstance() {
        return myInstance;
    }

    /**
     * Start playing this audio clip. Each time this method is called,
     * the clip is restarted from the beginning.
     */
    public void play() {
        if (prevClip != null) {
            prevClip.play();
        }
    }

    /**
     * Stop the previously requested audio clip and play the given audio
     * clip.
     *
     * @param clip the new audio clip to play
     */
    public void play(AudioClip clip) {
        if (prevClip != null) {
            prevClip.stop();
        }
        prevClip = clip;
        clip.play();
    }

    /**
     * Starts playing this audio clip in a loop.
     */
    public void loop() {
        if (prevClip != null) {
            prevClip.loop();
        }
    }

    /**
     * Stop the previously requested audio clip and play the given audio
     * clip in a loop.
     *
     * @param clip the new audio clip to play
     */
    public void loop(AudioClip clip) {
        if (prevClip != null) {
            prevClip.stop();
        }
        prevClip = clip;
        clip.loop();
    }

    /**
     * Stops playing this audio clip.
     */
    public void stop() {
        if (prevClip != null) {
            prevClip.stop();
        }
    }
}
