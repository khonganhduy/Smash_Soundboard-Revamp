/*package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class SoundActivityIceClimbers extends AppCompatActivity {

    private static MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle saveInstanceState)   //Creates activity
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_iceclimbers);    //Finds ID of resource layout
        final Intent exitIntent = new Intent(this, MainActivity.class); //Click button > Go there

        ArrayList<Integer> iceClimbersSoundIds = new ArrayList<Integer>();
        iceClimbersSoundIds.add(R.id.iceClimbers_cheer);
        iceClimbersSoundIds.add(R.id.iceClimbers_victory);
        iceClimbersSoundIds.add(R.id.iceClimbers_taunt);
        iceClimbersSoundIds.add(R.id.iceClimbers_smash1);
        iceClimbersSoundIds.add(R.id.iceClimbers_smash2);
        iceClimbersSoundIds.add(R.id.iceClimbers_smash3);
        iceClimbersSoundIds.add(R.id.iceClimbers_smash4);
        iceClimbersSoundIds.add(R.id.iceClimbers_smash5);
        iceClimbersSoundIds.add(R.id.iceClimbers_rollout);
        iceClimbersSoundIds.add(R.id.iceClimbers_pound);
        iceClimbersSoundIds.add(R.id.iceClimbers_rest);
        iceClimbersSoundIds.add(R.id.iceClimbers_sing);
        iceClimbersSoundIds.add(R.id.iceClimbers_death1);  //Death percent
        iceClimbersSoundIds.add(R.id.iceClimbers_death2);  //Uah
        iceClimbersSoundIds.add(R.id.iceClimbers_star_ko);  //jiggly echo
        iceClimbersSoundIds.add(R.id.iceClimbers_screen_ko);    //death percent

        Button iceClimbersPalette = (Button) this.findViewById(R.id.iceClimbers_banner);
        iceClimbersPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });

        for (int i = 0; i < iceClimbersSoundIds.size(); i++) {
            final SoundButton iceClimbersSoundButton = (SoundButton) this.findViewById(iceClimbersSoundIds.get(i));
            iceClimbersSoundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(iceClimbersSoundButton, v);
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