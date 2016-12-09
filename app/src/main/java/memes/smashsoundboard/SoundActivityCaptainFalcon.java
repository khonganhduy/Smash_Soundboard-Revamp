package memes.smashsoundboard;


import android.os.Bundle;

public class SoundActivityCaptainFalcon extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_captainfalcon, R.id.captainfalcon_banner_button);
    }

    @Override
    protected void addSoundIds() {

        addingButtonIds.add(R.id.captainfalcon_cheer_button);
        addingButtonIds.add(R.id.captainfalcon_victory1_button);
        addingButtonIds.add(R.id.captainfalcon_victory2_button);
        addingButtonIds.add(R.id.captainfalcon_taunt_button);
        addingButtonIds.add(R.id.captainfalcon_smash1_button);
        addingButtonIds.add(R.id.captainfalcon_smash2_button);
        addingButtonIds.add(R.id.captainfalcon_smash3_button);
        addingButtonIds.add(R.id.captainfalcon_smash4_button);
        addingButtonIds.add(R.id.captainfalcon_smash5_button);
        addingButtonIds.add(R.id.captainfalcon_spot_dodge_button);
        addingButtonIds.add(R.id.captainfalcon_triple_jab_button);
        addingButtonIds.add(R.id.captainfalcon_rapid_punch_button);
        addingButtonIds.add(R.id.captainfalcon_falcon_punch_button);
        addingButtonIds.add(R.id.captainfalcon_raptor_boost_button);
        addingButtonIds.add(R.id.captainfalcon_falcon_kick_button);
        addingButtonIds.add(R.id.captainfalcon_falcon_dive_button);
        addingButtonIds.add(R.id.captainfalcon_yes_button);
        addingButtonIds.add(R.id.captainfalcon_double_jump_button);
        addingButtonIds.add(R.id.captainfalcon_damage_button);
        addingButtonIds.add(R.id.captainfalcon_death_button);
        addingButtonIds.add(R.id.captainfalcon_star_ko_button);
        addingButtonIds.add(R.id.captainfalcon_screen_ko_button);
        addingButtonIds.add(R.id.captainfalcon_quote_button); //Come on
    }

    protected void setCustomAction(final SoundButton soundButton) {
    }
}