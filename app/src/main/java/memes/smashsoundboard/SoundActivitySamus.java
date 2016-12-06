package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class SoundActivitySamus extends AppCompatActivity {

    private static MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle saveInstanceState)   //Creates activity
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_samus);    //Finds ID of resource layout
        final Intent exitIntent = new Intent(this, MainActivity.class); //Click button > Go there

        ArrayList<Integer> samusSoundIds = new ArrayList<Integer>();
        samusSoundIds.add(R.id.samus_cheer_button);
        samusSoundIds.add(R.id.samus_victory_button);
        samusSoundIds.add(R.id.samus_taunt_button);
        samusSoundIds.add(R.id.samus_smash1_button);
        samusSoundIds.add(R.id.samus_smash2_button);
        samusSoundIds.add(R.id.samus_smash3_button);
        samusSoundIds.add(R.id.samus_smash4_button);
        samusSoundIds.add(R.id.samus_smash5_button);
        samusSoundIds.add(R.id.samus_chargeshot_button);
        samusSoundIds.add(R.id.samus_missile_button);
        samusSoundIds.add(R.id.samus_bomb_button);
        samusSoundIds.add(R.id.samus_screwattack_button);
        samusSoundIds.add(R.id.samus_death1_button);  //Death percent
        samusSoundIds.add(R.id.samus_death2_button);  //Uah
        samusSoundIds.add(R.id.samus_star_ko_button);  //jiggly echo
        samusSoundIds.add(R.id.samus_screen_ko_button);    //death percent

        Button samusPalette = (Button) this.findViewById(R.id.samus_banner);
        samusPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });

        for (int i = 0; i < samusSoundIds.size(); i++) {
            final SoundButton samusSoundButton = (SoundButton) this.findViewById(samusSoundIds.get(i));
            samusSoundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(samusSoundButton, v);
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

}