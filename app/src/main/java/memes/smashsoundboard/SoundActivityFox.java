package memes.smashsoundboard;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SoundActivityFox extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_fox, R.id.fox_banner_button);
    }

    @Override
    protected void addSoundIds() {
        addingButtonIds.add(R.id.fox_cheer_button);
        addingButtonIds.add(R.id.fox_mission_complete_button);
        addingButtonIds.add(R.id.fox_taunt_button);
        addingButtonIds.add(R.id.fox_jp_taunt_button);
        addingButtonIds.add(R.id.fox_smash1_button);
        addingButtonIds.add(R.id.fox_smash2_button);
        addingButtonIds.add(R.id.fox_smash3_button);
        addingButtonIds.add(R.id.fox_smash4_button);
        addingButtonIds.add(R.id.fox_smash5_button);
        addingButtonIds.add(R.id.fox_spot_dodge_button);
        addingButtonIds.add(R.id.fox_laser_button);
        addingButtonIds.add(R.id.fox_illusion_button);
        addingButtonIds.add(R.id.fox_shine_button);
        addingButtonIds.add(R.id.fox_firefox_button);
        addingButtonIds.add(R.id.fox_damage1_button);
        addingButtonIds.add(R.id.fox_damage2_button);
        addingButtonIds.add(R.id.fox_damage3_button);
        addingButtonIds.add(R.id.fox_death1_button);
        addingButtonIds.add(R.id.fox_death2_button);
        addingButtonIds.add(R.id.fox_death3_button);
        addingButtonIds.add(R.id.fox_off_top_button);
        addingButtonIds.add(R.id.fox_double_jump_button);
        addingButtonIds.add(R.id.fox_gun_draw_button);
        addingButtonIds.add(R.id.fox_gun_withdrawal_button);

        addingButtonIds.put(R.id.fox_multishine_button, Act.CUSTOM);
    }

    protected void setCustomAction(final SoundButton soundButton) {
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
        }
    }
}