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

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_peach);
        final Intent exitIntent = new Intent(this, MainActivity.class);

        ArrayList<Integer> peachSoundIds = new ArrayList<Integer>();
        peachSoundIds.add(R.id.peach_cheer);
        peachSoundIds.add(R.id.peach_victory1);
        peachSoundIds.add(R.id.peach_victory2);
        peachSoundIds.add(R.id.peach_taunt);
        peachSoundIds.add(R.id.peach_smash1);
        peachSoundIds.add(R.id.peach_smash2);
        peachSoundIds.add(R.id.peach_smash3);
        peachSoundIds.add(R.id.peach_smash4);
        peachSoundIds.add(R.id.peach_smash5);
        peachSoundIds.add(R.id.peach_pan);
        peachSoundIds.add(R.id.peach_golf_club);
        peachSoundIds.add(R.id.peach_tennis_racket);
        peachSoundIds.add(R.id.peach_jump);
        peachSoundIds.add(R.id.peach_double_jump);
        peachSoundIds.add(R.id.peach_toad);
        peachSoundIds.add(R.id.peach_bomber);
        peachSoundIds.add(R.id.peach_pull);
        peachSoundIds.add(R.id.peach_parasol);
        peachSoundIds.add(R.id.peach_damage);
        peachSoundIds.add(R.id.peach_death);
        peachSoundIds.add(R.id.peach_star_ko);
        peachSoundIds.add(R.id.peach_screen_ko);

        Button peachPalette = (Button) this.findViewById(R.id.peach_banner);
        peachPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        for (int i = 0; i < peachSoundIds.size(); i++) {
            final SoundButton peachSoundButton = (SoundButton) this.findViewById(peachSoundIds.get(i));
                peachSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(peachSoundButton, v);
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