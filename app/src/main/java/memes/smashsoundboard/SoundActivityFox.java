package memes.smashsoundboard;

import android.os.Bundle;

public class SoundActivityFox extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_fox, R.id.fox_banner_button);
    }

    @Override
    protected void addSoundIds() {
        addButtonIds.add(R.id.fox_cheer_button);
        addButtonIds.add(R.id.fox_mission_complete_button);
        addButtonIds.add(R.id.fox_taunt_button);
        addButtonIds.add(R.id.fox_jp_taunt_button);
        addButtonIds.add(R.id.fox_smash1_button);
        addButtonIds.add(R.id.fox_smash2_button);
        addButtonIds.add(R.id.fox_smash3_button);
        addButtonIds.add(R.id.fox_smash4_button);
        addButtonIds.add(R.id.fox_smash5_button);
        addButtonIds.add(R.id.fox_spot_dodge_button);
        addButtonIds.add(R.id.fox_laser_button);
        addButtonIds.add(R.id.fox_illusion_button);
        addButtonIds.add(R.id.fox_shine_button);
        addButtonIds.add(R.id.fox_firefox_button);
        addButtonIds.add(R.id.fox_damage1_button);
        addButtonIds.add(R.id.fox_damage2_button);
        addButtonIds.add(R.id.fox_damage3_button);
        addButtonIds.add(R.id.fox_death1_button);
        addButtonIds.add(R.id.fox_death2_button);
        addButtonIds.add(R.id.fox_death3_button);
        addButtonIds.add(R.id.fox_off_top_button);
        addButtonIds.add(R.id.fox_double_jump_button);
        addButtonIds.add(R.id.fox_gun_draw_button);
        addButtonIds.add(R.id.fox_gun_withdrawal_button);

        addButtonIds.put(R.id.fox_multishine_button, Act.LOOP);
    }
}