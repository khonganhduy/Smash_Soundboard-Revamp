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

public class SoundActivitySheik extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_sheik, R.id.sheik_banner);
    }

    protected void addSoundIds() {
        soundIds.add(R.id.sheik_cheer_button);
        soundIds.add(R.id.sheik_victory_button);
        soundIds.add(R.id.sheik_taunt_button);
        soundIds.add(R.id.sheik_smash1_button);
        soundIds.add(R.id.sheik_smash2_button);
        soundIds.add(R.id.sheik_smash3_button);
        soundIds.add(R.id.sheik_smash4_button);
        soundIds.add(R.id.sheik_smash5_button);
        soundIds.add(R.id.sheik_spot_dodge_button);
        soundIds.add(R.id.sheik_neutral_b_button);
        soundIds.add(R.id.sheik_side_b_button);
        soundIds.add(R.id.sheik_down_b_button);
        soundIds.add(R.id.sheik_up_b_button);
        soundIds.add(R.id.sheik_damage1_button);
        soundIds.add(R.id.sheik_damage2_button);
        soundIds.add(R.id.sheik_damage3_button);
        soundIds.add(R.id.sheik_death1_button);
        soundIds.add(R.id.sheik_death2_button);
        soundIds.add(R.id.sheik_death3_button);
        soundIds.add(R.id.sheik_off_top_button);
        soundIds.add(R.id.sheik_jump_button);
    }

    protected void setCustomAction(final SoundButton soundButton) {
        if (soundButton.getId() == R.id.sheik_neutral_b_button) {
            soundButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            playSound(soundButton, v);
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
        }
    }
}
