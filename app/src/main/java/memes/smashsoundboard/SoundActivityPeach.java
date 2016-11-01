package memes.smashsoundboard;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class SoundActivityPeach extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();
    private MediaPlayer turnipThrow = new MediaPlayer();
    private int turnipCounter = 0;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_peach);
        final Intent exitIntent = new Intent(this, MainActivity.class);

        ArrayList<Integer> peachSoundIds = new ArrayList<Integer>();
        peachSoundIds.add(R.id.peach_cheer_button);
        peachSoundIds.add(R.id.peach_victory1_button);
        peachSoundIds.add(R.id.peach_victory2_button);
        peachSoundIds.add(R.id.peach_taunt_button);
        peachSoundIds.add(R.id.peach_smash1_button);
        peachSoundIds.add(R.id.peach_smash2_button);
        peachSoundIds.add(R.id.peach_smash3_button);
        peachSoundIds.add(R.id.peach_smash4_button);
        peachSoundIds.add(R.id.peach_smash5_button);
        peachSoundIds.add(R.id.peach_pan_button);
        peachSoundIds.add(R.id.peach_golf_club_button);
        peachSoundIds.add(R.id.peach_tennis_racket_button);
        peachSoundIds.add(R.id.peach_jump_button);
        peachSoundIds.add(R.id.peach_double_jump_button);
        peachSoundIds.add(R.id.peach_toad_button);
        peachSoundIds.add(R.id.peach_bomber_button);
        peachSoundIds.add(R.id.peach_pull_button);
        peachSoundIds.add(R.id.peach_parasol_button);
        peachSoundIds.add(R.id.peach_damage_button);
        peachSoundIds.add(R.id.peach_death_button);
        peachSoundIds.add(R.id.peach_star_ko_button);
        peachSoundIds.add(R.id.peach_screen_ko_button);

        Button peachPalette = (Button) this.findViewById(R.id.peach_banner);
        peachPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });

        turnipThrow = MediaPlayer.create(SoundActivityPeach.this, R.raw.peach_throw);
        for (int i = 0; i < peachSoundIds.size(); i++) {
            final SoundButton peachSoundButton = (SoundButton) this.findViewById(peachSoundIds.get(i));
            /*if (i == 16) {
                if (turnipCounter % 2 == 0) {
                    peachSoundButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            playSound(peachSoundButton, v);
                        }
                    });
                }
                else{
                    playTurnipThrow();
                }
            }
            else */{
                peachSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(peachSoundButton, v);
                    }
                });
            }
            }
        }

    private void playSound(SoundButton button, View view)
    {
        try {
            player.reset();
            player.setDataSource(view.getContext(), button.getSoundID());
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playTurnipThrow(){
        try {
            turnipThrow.stop();
            turnipThrow.prepare();
            turnipThrow.start();
            player.reset();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}