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

public class SoundActivityFalco extends SoundActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_falco, R.id.falco_banner);
    }

    protected void addSoundIds() {

//        Falco variables
        soundIds.add(R.id.falco_cheer_button);
        soundIds.add(R.id.falco_mission_complete_button);
        soundIds.add(R.id.falco_taunt_button);
        soundIds.add(R.id.falco_smash1_button);
        soundIds.add(R.id.falco_smash2_button);
        soundIds.add(R.id.falco_smash3_button);
        soundIds.add(R.id.falco_smash4_button);
        soundIds.add(R.id.falco_smash5_button);
        soundIds.add(R.id.falco_spot_dodge_button);
        soundIds.add(R.id.falco_laser_button);
        soundIds.add(R.id.falco_phantasm_button);
        soundIds.add(R.id.falco_shine_button);
        soundIds.add(R.id.falco_firebird_button);
        soundIds.add(R.id.falco_damage1_button);
        soundIds.add(R.id.falco_damage2_button);
        soundIds.add(R.id.falco_damage3_button);
        soundIds.add(R.id.falco_death1_button);
        soundIds.add(R.id.falco_death2_button);
        soundIds.add(R.id.falco_death3_button);
        soundIds.add(R.id.falco_off_top_button);
        soundIds.add(R.id.falco_double_jump_button);
        soundIds.add(R.id.falco_gun_draw_button);
        soundIds.add(R.id.falco_gun_withdrawal_button);

        soundIds.put(R.id.falco_multishine_button, Act.CUSTOM);
    }

    protected void setCustomAction(final SoundButton soundButton) {
        if (soundButton.getId() == R.id.falco_multishine_button) {
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
