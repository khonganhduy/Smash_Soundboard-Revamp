package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class SoundActivitySheik extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_sheik);
        final Intent exitIntent = new Intent(this, MainActivity.class);

        ArrayList<Integer> sheikSoundIds = new ArrayList<Integer>();
        sheikSoundIds.add(R.id.sheik_cheer);
        sheikSoundIds.add(R.id.sheik_victory);
        sheikSoundIds.add(R.id.sheik_taunt);
        sheikSoundIds.add(R.id.sheik_smash1);
        sheikSoundIds.add(R.id.sheik_smash2);
        sheikSoundIds.add(R.id.sheik_smash3);
        sheikSoundIds.add(R.id.sheik_smash4);
        sheikSoundIds.add(R.id.sheik_smash5);
        sheikSoundIds.add(R.id.sheik_spot_dodge);
        sheikSoundIds.add(R.id.sheik_neutral_b);
        sheikSoundIds.add(R.id.sheik_side_b);
        sheikSoundIds.add(R.id.sheik_down_b);
        sheikSoundIds.add(R.id.sheik_up_b);
        sheikSoundIds.add(R.id.sheik_damage1);
        sheikSoundIds.add(R.id.sheik_damage2);
        sheikSoundIds.add(R.id.sheik_damage3);
        sheikSoundIds.add(R.id.sheik_death1);
        sheikSoundIds.add(R.id.sheik_death2);
        sheikSoundIds.add(R.id.sheik_death3);
        sheikSoundIds.add(R.id.sheik_off_top);
        sheikSoundIds.add(R.id.sheik_jump);

        Button sheikPalette = (Button) this.findViewById(R.id.sheik_banner);
        sheikPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        for (int i = 0; i < sheikSoundIds.size(); i++) {
            final SoundButton sheikSoundButton = (SoundButton) this.findViewById(sheikSoundIds.get(i));
            if (i == 9) {
                sheikSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(sheikSoundButton, v);
                                player.setLooping(true);
                                break;
                            case MotionEvent.ACTION_UP:
                                player.reset();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                player.reset();
                                break;
                        }
                        return false;
                    }
                });
            } else {
                sheikSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(sheikSoundButton, v);
                    }
                });
            }
        }
    }

    private void playSound(SoundButton button, View view)
    {
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
