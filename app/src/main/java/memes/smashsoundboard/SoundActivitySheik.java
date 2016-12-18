package memes.smashsoundboard;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SoundActivitySheik extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_sheik, R.id.sheik_banner);
    }

    protected void addSoundIds() {
        addButtonIds.add(R.id.sheik_cheer_button);
        addButtonIds.add(R.id.sheik_victory_button);
        addButtonIds.add(R.id.sheik_taunt_button);
        addButtonIds.add(R.id.sheik_smash1_button);
        addButtonIds.add(R.id.sheik_smash2_button);
        addButtonIds.add(R.id.sheik_smash3_button);
        addButtonIds.add(R.id.sheik_smash4_button);
        addButtonIds.add(R.id.sheik_smash5_button);
        addButtonIds.add(R.id.sheik_spot_dodge_button);

        addButtonIds.put(R.id.sheik_neutral_b_button, Act.LOOP);

        addButtonIds.add(R.id.sheik_side_b_button);
        addButtonIds.add(R.id.sheik_down_b_button);
        addButtonIds.add(R.id.sheik_up_b_button);
        addButtonIds.add(R.id.sheik_damage1_button);
        addButtonIds.add(R.id.sheik_damage2_button);
        addButtonIds.add(R.id.sheik_damage3_button);
        addButtonIds.add(R.id.sheik_death1_button);
        addButtonIds.add(R.id.sheik_death2_button);
        addButtonIds.add(R.id.sheik_death3_button);
        addButtonIds.add(R.id.sheik_off_top_button);
        addButtonIds.add(R.id.sheik_jump_button);


    }
    /*
    protected void setChainLogic(SoundButton soundButton, final int firstSoundId) {
        soundButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        playSound(firstSoundId, v, -1);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return false;
            }
        });

    }
    */
}
