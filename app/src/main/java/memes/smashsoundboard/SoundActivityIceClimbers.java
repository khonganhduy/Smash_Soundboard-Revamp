package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
/*
public class SoundActivityIceClimbers extends AppCompatActivity {

    private static MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle saveInstanceState)   //Creates activity
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_iceclimbers);    //Finds ID of resource layout
        final Intent exitIntent = new Intent(this, MainActivity.class); //Click button > Go there

        ArrayList<Integer> iceclimbersSoundIds = new ArrayList<Integer>();
        iceclimbersSoundIds.add(R.id.iceclimbers_cheer_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_victory_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_taunt_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_smash1_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_smash2_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_smash3_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_smash4_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_smash5_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_iceshot_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_squallhammer_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_blizzard_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_belay_button);
        iceclimbersSoundIds.add(R.id.iceclimbers_death1_button);  //Death percent
        iceclimbersSoundIds.add(R.id.iceclimbers_death2_button);  //Uah
        iceclimbersSoundIds.add(R.id.iceclimbers_star_ko_button);  //jiggly echo
        iceclimbersSoundIds.add(R.id.iceclimbers_screen_ko_button);    //death percent

        Button iceclimbersPalette = (Button) this.findViewById(R.id.iceclimbers_banner);
        iceclimbersPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });

        for (int i = 0; i < iceclimbersSoundIds.size(); i++) {
            final SoundButton iceclimbersSoundButton = (SoundButton) this.findViewById(iceclimbersSoundIds.get(i));
            iceclimbersSoundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(iceclimbersSoundButton, v);
                }
            });
        }
    }

    private void playSound(SoundButton button, View view) {
        try {
            player.reset();
            player.setDataSource(view.getContext(), button.getSoundID());
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
        player = null;
    }

}*/