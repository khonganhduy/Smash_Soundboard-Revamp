package memes.smashsoundboard;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SoundActivityFalco extends SoundActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_falco, R.id.falco_banner);
    }

    protected void addSoundIds() {

//        Falco variables
        addButtonIds.add(R.id.falco_cheer_button);
        addButtonIds.add(R.id.falco_mission_complete_button);
        addButtonIds.add(R.id.falco_taunt_button);
        addButtonIds.add(R.id.falco_smash1_button);
        addButtonIds.add(R.id.falco_smash2_button);
        addButtonIds.add(R.id.falco_smash3_button);
        addButtonIds.add(R.id.falco_smash4_button);
        addButtonIds.add(R.id.falco_smash5_button);
        addButtonIds.add(R.id.falco_spot_dodge_button);
        addButtonIds.add(R.id.falco_laser_button);
        addButtonIds.add(R.id.falco_phantasm_button);
        addButtonIds.add(R.id.falco_shine_button);
        addButtonIds.add(R.id.falco_firebird_button);
        addButtonIds.add(R.id.falco_damage1_button);
        addButtonIds.add(R.id.falco_damage2_button);
        addButtonIds.add(R.id.falco_damage3_button);
        addButtonIds.add(R.id.falco_death1_button);
        addButtonIds.add(R.id.falco_death2_button);
        addButtonIds.add(R.id.falco_death3_button);
        addButtonIds.add(R.id.falco_off_top_button);
        addButtonIds.add(R.id.falco_double_jump_button);
        addButtonIds.add(R.id.falco_gun_draw_button);
        addButtonIds.add(R.id.falco_gun_withdrawal_button);

        addButtonIds.put(R.id.falco_multishine_button, Act.LOOP);
    }
}
