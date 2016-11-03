package memes.smashsoundboard;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class SoundActivityCaptainFalcon extends AppCompatActivity {

    private static MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_captainfalcon);
        final Intent exitIntent = new Intent(this, MainActivity.class);

        ArrayList<Integer> captainfalconSoundIds = new ArrayList<Integer>();
        captainfalconSoundIds.add(R.id.captainfalcon_cheer_button);
        captainfalconSoundIds.add(R.id.captainfalcon_victory1_button);
        captainfalconSoundIds.add(R.id.captainfalcon_victory2_button);
        captainfalconSoundIds.add(R.id.captainfalcon_taunt_button);
        captainfalconSoundIds.add(R.id.captainfalcon_smash1_button);
        captainfalconSoundIds.add(R.id.captainfalcon_smash2_button);
        captainfalconSoundIds.add(R.id.captainfalcon_smash3_button);
        captainfalconSoundIds.add(R.id.captainfalcon_smash4_button);
        captainfalconSoundIds.add(R.id.captainfalcon_smash5_button);
        captainfalconSoundIds.add(R.id.captainfalcon_spot_dodge_button);
        captainfalconSoundIds.add(R.id.captainfalcon_triple_jab_button);
        captainfalconSoundIds.add(R.id.captainfalcon_rapid_punch_button);
        captainfalconSoundIds.add(R.id.captainfalcon_falcon_punch_button);
        captainfalconSoundIds.add(R.id.captainfalcon_raptor_boost_button);
        captainfalconSoundIds.add(R.id.captainfalcon_falcon_kick_button);
        captainfalconSoundIds.add(R.id.captainfalcon_falcon_dive_button);
        captainfalconSoundIds.add(R.id.captainfalcon_yes_button);
        captainfalconSoundIds.add(R.id.captainfalcon_double_jump_button);
        captainfalconSoundIds.add(R.id.captainfalcon_damage_button);
        captainfalconSoundIds.add(R.id.captainfalcon_death_button);
        captainfalconSoundIds.add(R.id.captainfalcon_star_ko_button);
        captainfalconSoundIds.add(R.id.captainfalcon_screen_ko_button);
        captainfalconSoundIds.add(R.id.captainfalcon_quote_button); //Come on

        Button captainfalconPalette = (Button) this.findViewById(R.id.captainfalcon_banner_button);
        captainfalconPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        for (int i = 0; i < captainfalconSoundIds.size(); i++) {
            final SoundButton captainfalconSoundButton = (SoundButton) this.findViewById(captainfalconSoundIds.get(i));
                captainfalconSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(captainfalconSoundButton, v);
                    }
                });
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
}