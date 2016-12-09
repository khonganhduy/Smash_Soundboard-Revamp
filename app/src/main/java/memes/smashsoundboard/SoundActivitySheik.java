package memes.smashsoundboard;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SoundActivitySheik extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_sheik, R.id.sheik_banner);
    }

    protected void addSoundIds() {
        addingButtonIds.add(R.id.sheik_cheer_button);
        addingButtonIds.add(R.id.sheik_victory_button);
        addingButtonIds.add(R.id.sheik_taunt_button);
        addingButtonIds.add(R.id.sheik_smash1_button);
        addingButtonIds.add(R.id.sheik_smash2_button);
        addingButtonIds.add(R.id.sheik_smash3_button);
        addingButtonIds.add(R.id.sheik_smash4_button);
        addingButtonIds.add(R.id.sheik_smash5_button);
        addingButtonIds.add(R.id.sheik_spot_dodge_button);
        addingButtonIds.add(R.id.sheik_neutral_b_button);
        addingButtonIds.add(R.id.sheik_side_b_button);
        addingButtonIds.add(R.id.sheik_down_b_button);
        addingButtonIds.add(R.id.sheik_up_b_button);
        addingButtonIds.add(R.id.sheik_damage1_button);
        addingButtonIds.add(R.id.sheik_damage2_button);
        addingButtonIds.add(R.id.sheik_damage3_button);
        addingButtonIds.add(R.id.sheik_death1_button);
        addingButtonIds.add(R.id.sheik_death2_button);
        addingButtonIds.add(R.id.sheik_death3_button);
        addingButtonIds.add(R.id.sheik_off_top_button);
        addingButtonIds.add(R.id.sheik_jump_button);
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
