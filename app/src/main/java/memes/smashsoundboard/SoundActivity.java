package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
//Inheritence test

public abstract class SoundActivity extends AppCompatActivity {
    protected MediaPlayer player = new MediaPlayer();

    protected class SoundMap extends TreeMap<Integer, Act> {
        public void add(int id) {
            put(id, Act.DEF);
        }
    }

    protected SoundMap soundIds;

    abstract protected void addSoundIds();

    abstract protected void onCreate(Bundle savedInstanceState);

    protected void onCreate(Bundle savedInstanceState, int layoutId, int exitId) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        soundIds = new SoundMap();
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
                player.reset();
                startActivity(exitIntent);
            }
        });
    }

    abstract protected void setCustomAction(SoundButton soundButton);

    protected void setSounds() {
        Iterator<Integer> ids = soundIds.keySet().iterator();
        while (ids.hasNext()) {
            int id = ids.next();

            final SoundButton soundButton = (SoundButton) this.findViewById(id);
            if (soundIds.get(id) == Act.DEF) {
                defaultAction(soundButton);
            } else {
                setCustomAction(soundButton);
            }
        }
    }

    protected void defaultAction(final SoundButton soundButton) {
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(soundButton, v);
            }
        });
    }

    protected void playSound(SoundButton button, View view) {
        try {
            player.reset();
            player.setDataSource(view.getContext(), button.getSoundID());
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
