package memes.smashsoundboard;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SoundActivityFox extends SoundActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_sound_fox, R.id.fox_banner_button);
    }

    @Override
    protected void addSoundIds() {

//        Fox variables

        soundIds.add(R.id.fox_cheer_button);
        soundIds.add(R.id.fox_mission_complete_button);
        soundIds.add(R.id.fox_taunt_button);
        soundIds.add(R.id.fox_jp_taunt_button);
        soundIds.add(R.id.fox_smash1_button);
        soundIds.add(R.id.fox_smash2_button);
        soundIds.add(R.id.fox_smash3_button);
        soundIds.add(R.id.fox_smash4_button);
        soundIds.add(R.id.fox_smash5_button);
        soundIds.add(R.id.fox_spot_dodge_button);
        soundIds.add(R.id.fox_laser_button);
        soundIds.add(R.id.fox_illusion_button);
        soundIds.add(R.id.fox_shine_button);
        soundIds.add(R.id.fox_firefox_button);
        soundIds.add(R.id.fox_damage1_button);
        soundIds.add(R.id.fox_damage2_button);
        soundIds.add(R.id.fox_damage3_button);
        soundIds.add(R.id.fox_death1_button);
        soundIds.add(R.id.fox_death2_button);
        soundIds.add(R.id.fox_death3_button);
        soundIds.add(R.id.fox_off_top_button);
        soundIds.add(R.id.fox_double_jump_button);
        soundIds.add(R.id.fox_gun_draw_button);
        soundIds.add(R.id.fox_gun_withdrawal_button);
        soundIds.add(R.id.fox_multishine_button);
    }

    protected void setButtonAction(final SoundButton soundButton)
    {
        if (soundButton.getId() == R.id.fox_multishine_button) {
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
        } else {
            soundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(soundButton, v);
                }
            });
        }
    }
}