package memes.smashsoundboard;


import android.os.Bundle;

public class SoundActivityPeach extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_fox, R.id.fox_banner_button);
    }

    @Override
    protected void addSoundIds() {

//        Peach variables

        addingButtonIds.add(R.id.peach_cheer_button);
        addingButtonIds.add(R.id.peach_victory1_button);
        addingButtonIds.add(R.id.peach_victory2_button);
        addingButtonIds.add(R.id.peach_taunt_button);
        addingButtonIds.add(R.id.peach_smash1_button);
        addingButtonIds.add(R.id.peach_smash2_button);
        addingButtonIds.add(R.id.peach_smash3_button);
        addingButtonIds.add(R.id.peach_smash4_button);
        addingButtonIds.add(R.id.peach_smash5_button);
        addingButtonIds.add(R.id.peach_pan_button);
        addingButtonIds.add(R.id.peach_golf_club_button);
        addingButtonIds.add(R.id.peach_tennis_racket_button);
        addingButtonIds.add(R.id.peach_jump_button);
        addingButtonIds.add(R.id.peach_double_jump_button);
        addingButtonIds.add(R.id.peach_toad_button);
        addingButtonIds.add(R.id.peach_bomber_button);
        addingButtonIds.add(R.id.peach_pull_button);
        addingButtonIds.add(R.id.peach_parasol_button);
        addingButtonIds.add(R.id.peach_damage_button);
        addingButtonIds.add(R.id.peach_death_button);
        addingButtonIds.add(R.id.peach_star_ko_button);
        addingButtonIds.add(R.id.peach_screen_ko_button);

    }

    protected void setCustomAction(final SoundButton soundButton) {
    }
}