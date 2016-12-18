package memes.smashsoundboard;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
//Inheritence test

public abstract class SoundActivity extends AppCompatActivity {
    //protected MediaPlayer player = new MediaPlayer();
    private AudioAttributes audioAttribute;
    protected SoundPool soundPlayer;
    protected AudioManager audioManager;
    protected int lastAudio;
    protected boolean isPlaying;
    protected SoundMap addButtonIds;
    protected HashMap<Integer, Integer> soundChains, loadedSoundChains;

    protected class SoundMap extends TreeMap<Integer, Act> {
        public void add(int id) {
            put(id, Act.DEF);
        }
    }

    protected class SoundTimer extends Thread{

        private int id;
        private int loops;
        protected SoundTimer(int Rid, int loop)
        {
            id = Rid;
            loops = loop;
        }
        protected SoundTimer(int Rid)
        {
            id = Rid;
            loops = 1;
        }
        protected long getSoundDuration()
        {
            MediaPlayer timer = MediaPlayer.create(SoundActivity.this, id);
            long time = timer.getDuration() * loops;
            timer.release();
            return time;
        }
        public void run(){
            try
            {
                wait(getSoundDuration());
            }
            catch (InterruptedException e)
            {
                return;
            }
        }
    }

    //Methods

    /**
     * Use:
     * addButtonIds.add(buttonID) to add a button with default action
     * addButtonIds.put(buttonID, Act) to add a button with a different action
     * soundChains.put(sound, nextSound) to chain nextSound to play after sound.
     * nextSound should always be the integer to the path of a string
     * Chain logic needs to be manually set
     */
    abstract protected void addSoundIds();

    abstract protected void onCreate(Bundle savedInstanceState);

    protected void onCreate(Bundle savedInstanceState, int layoutId, int exitId) {
        super.onCreate(savedInstanceState);
        audioAttribute = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();
        soundPlayer = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(audioAttribute)
                .build();
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        setContentView(layoutId);
        addButtonIds = new SoundMap();
        soundChains = new HashMap<>();
        loadedSoundChains = new HashMap<>();
        addSoundIds();
        setExitButton(exitId);
        setSounds();
    }

    protected void setExitButton(int RId) {
        final Intent exitIntent = new Intent(this, MainActivity.class);
        Button palette = (Button) this.findViewById(RId);
        palette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //player.reset();
                startActivity(exitIntent);
            }
        });
    }

    protected void loadSoundChain(int id, int firstSound){
        int lastReference = firstSound;
        while(soundChains.containsKey(id))
        {
            int nextSoundToLoad = soundChains.get(id);
            String soundPath = getString(nextSoundToLoad);
            final int sound = soundPlayer.load(soundPath, 1);
            loadedSoundChains.put(lastReference, sound);
            id = nextSoundToLoad;
            lastReference = sound;
        }
    }

    protected void setSounds() {
        Iterator<Integer> ids = addButtonIds.keySet().iterator();
        while (ids.hasNext()) {
            final int id = ids.next();
            boolean loaded = false;
            final SoundButton soundButton = (SoundButton) this.findViewById(id);
            final int releaseSound, loopSound, soundId = soundPlayer.load(soundButton.getSoundID().getPath(), 1);
            final SoundTimer timer;
            switch(addButtonIds.get(id))
            {
                case DEF:
                    soundButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            playSound(soundId, v, 0);
                        }
                    });
                    break;
                case LOOP:
                    soundButton.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    playSound(soundId, v, -1);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    stopSound();
                                    break;
                                case MotionEvent.ACTION_CANCEL:
                                    stopSound();
                                    break;
                            }
                            return false;
                        }
                    });
                    break;
                case CHAIN:
                    loadSoundChain(soundButton.getId(),soundId);
                    releaseSound = loadedSoundChains.get(soundId);
                    timer = new SoundTimer(getStartSound(soundButton));
                    soundButton.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            boolean released = false;
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    playSound(soundId, v, 0);
                                    timer.start();
                                    while (timer.isAlive()) {
                                    }
                                    if (!timer.isInterrupted())
                                        released = true;
                                    playSound(releaseSound, v, 0);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    timer.interrupt();
                                    if (!released)
                                        playSound(releaseSound, v, 0);
                                    break;
                                case MotionEvent.ACTION_CANCEL:
                                    timer.interrupt();
                                    if (!released)
                                        playSound(releaseSound, v, 0);
                                    break;
                            }
                            return false;
                        }
                    });
                    break;
                case CHAIN_LOOP:
                    loadSoundChain(soundButton.getId(),soundId);
                    loopSound = loadedSoundChains.get(soundId);
                    releaseSound = loadedSoundChains.get(loopSound);
                    timer = new SoundTimer(getStartSound(soundButton));
                    soundButton.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    playSound(soundId, v, 0);
                                    timer.start();
                                    while (timer.isAlive()) {
                                    }
                                    if (!timer.isInterrupted())
                                        playSound(loopSound, v, -1);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    timer.interrupt();
                                    playSound(releaseSound, v, 0);
                                    break;
                                case MotionEvent.ACTION_CANCEL:
                                    timer.interrupt();
                                    playSound(releaseSound, v, 0);
                                    break;
                            }
                            return false;
                        }
                    });
                    break;
            }
        }
    }

    protected int getStartSound(SoundButton button)
    {
        return 0;
    }

    protected void stopSound()
    {
        if(isPlaying)
            soundPlayer.stop(lastAudio);
        isPlaying = false;
    }

    protected float getVolume()
    {
        return ((float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)) /
                audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }

    /**
     *
     * @param soundId
     * @param view
     * @param loop 0 = No Looping, -1 = Loops until stopped, Any other value x = Loops x times
     */
    protected void playSound(int soundId, View view, int loop) {
        float volume = getVolume();
        stopSound();
        lastAudio = soundPlayer.play(soundId, volume, volume, 1, loop, 1f);
    }

    public void onDestroy()
    {
        super.onDestroy();
        stopSound();
        soundPlayer.release();
    }
}
