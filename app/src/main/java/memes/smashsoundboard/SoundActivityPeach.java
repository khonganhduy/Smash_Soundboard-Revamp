package memes.smashsoundboard;


import android.os.Bundle;
import android.view.View;

public class SoundActivityPeach extends SoundActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_sound_fox, R.id.fox_banner_button);
    }

    @Override
    protected void addSoundIds() {

//        Peach variables

        soundIds.add(R.id.peach_cheer_button);
        soundIds.add(R.id.peach_victory1_button);
        soundIds.add(R.id.peach_victory2_button);
        soundIds.add(R.id.peach_taunt_button);
        soundIds.add(R.id.peach_smash1_button);
        soundIds.add(R.id.peach_smash2_button);
        soundIds.add(R.id.peach_smash3_button);
        soundIds.add(R.id.peach_smash4_button);
        soundIds.add(R.id.peach_smash5_button);
        soundIds.add(R.id.peach_pan_button);
        soundIds.add(R.id.peach_golf_club_button);
        soundIds.add(R.id.peach_tennis_racket_button);
        soundIds.add(R.id.peach_jump_button);
        soundIds.add(R.id.peach_double_jump_button);
        soundIds.add(R.id.peach_toad_button);
        soundIds.add(R.id.peach_bomber_button);
        soundIds.add(R.id.peach_pull_button);
        soundIds.add(R.id.peach_parasol_button);
        soundIds.add(R.id.peach_damage_button);
        soundIds.add(R.id.peach_death_button);
        soundIds.add(R.id.peach_star_ko_button);
        soundIds.add(R.id.peach_screen_ko_button);

    }

    protected void setButtonAction(final SoundButton soundButton)
    {

            soundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(soundButton, v);
                }
            });
        }
    }