package memes.smashsoundboard;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
//Inheritence test

public abstract class SoundActivity extends AppCompatActivity {
    //protected MediaPlayer player = new MediaPlayer();
    AudioAttributes audioAttribute = new AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .build();
    protected SoundPool soundPlayer = new SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttribute)
            .build();

    AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
    protected int lastAudio;
    protected boolean isPlaying;




    protected class SoundMap extends TreeMap<Integer, Act> {
        public void add(int id) {
            put(id, Act.DEF);
        }
    }

    protected SoundMap addingButtonIds, soundToAction;


    //Methods

    abstract protected void addSoundIds();

    abstract protected void onCreate(Bundle savedInstanceState);

    protected void onCreate(Bundle savedInstanceState, int layoutId, int exitId) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        addingButtonIds = new SoundMap();
        soundToAction = new SoundMap();
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

    abstract protected Act getCustomAction(SoundButton soundButton);

    protected void setSounds() {
        Iterator<Integer> ids = addingButtonIds.keySet().iterator();
        while (ids.hasNext()) {
            int id = ids.next();

            final SoundButton soundButton = (SoundButton) this.findViewById(id);
            final int soundId = soundPlayer.load(soundButton.getSoundID().getPath(), 1);
            soundToAction.put(soundId, addingButtonIds.get(id));
            soundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(soundId, v);
                }
            });
        }
    }

    protected void playSound(int soundId, View view) {
        Act action = soundToAction.get(soundId);
        float volume =  ((float)audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)) /
                audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        if(isPlaying)
            soundPlayer.stop(lastAudio);
        if (action == Act.DEF) {
            lastAudio = soundPlayer.play(soundId, volume, volume, 1, 0, 1f);
            isPlaying = true;
        } else {

        }
    /*
        try {
            player.reset();
            player.setDataSource(view.getContext(), button.getSoundID());
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    */

    }

    public void onDestroy()
    {
        super.onDestroy();
        isPlaying = false;
        soundPlayer.release();

    }
}
