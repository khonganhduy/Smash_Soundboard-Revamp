package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Akabe on 10/29/2016.
 */

/*public class SoundActivityPika extends AppCompatActivity {
    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pika);
        final Intent exitIntent = new Intent(this, MainActivity.class);

//        Fox variables
        ArrayList<Integer> pikaSoundIds = new ArrayList<Integer>();
        pikaSoundIds.add(R.id.pika_cheer);
        pikaSoundIds.add(R.id.pika_mission_complete);
        pikaSoundIds.add(R.id.pika_taunt);
        pikaSoundIds.add(R.id.pika_smash1);
        pikaSoundIds.add(R.id.pika_smash2);
        pikaSoundIds.add(R.id.pika_smash3);
        pikaSoundIds.add(R.id.pika_smash4);
        pikaSoundIds.add(R.id.pika_smash5);
        pikaSoundIds.add(R.id.pika_spot_dodge);
        pikaSoundIds.add(R.id.pika_laser);
        pikaSoundIds.add(R.id.pika_illusion);
        pikaSoundIds.add(R.id.pika_shine);
        pikaSoundIds.add(R.id.pika_firefox);
        pikaSoundIds.add(R.id.pika_damage1);
        pikaSoundIds.add(R.id.pika_damage2);
        pikaSoundIds.add(R.id.pika_damage3);
        pikaSoundIds.add(R.id.pika_death1);
        pikaSoundIds.add(R.id.pika_death2);
        pikaSoundIds.add(R.id.pika_death3);
        pikaSoundIds.add(R.id.pika_off_top);
        pikaSoundIds.add(R.id.pika_double_jump);
        pikaSoundIds.add(R.id.pika_gun_draw);
        pikaSoundIds.add(R.id.pika_gun_withdrawal);
        pikaSoundIds.add(R.id.pika_multishine);

        Button pikaPalette = (Button) this.findViewById(R.id.pika_banner);
        pikaPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        for (int i = 0; i < pikaSoundIds.size(); i++) {
            final SoundButton pikaSoundButton = (SoundButton) this.findViewById(pikaSoundIds.get(i));
            if (pikaSoundIds.size() - 1 == i) {
                pikaSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(pikaSoundButton, v);
                                player.setLooping(true);
                                break;
                            case MotionEvent.ACTION_UP:
                                player.reset();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                player.reset();
                                break;
                        }
                        return false;
                    }
                });
            } else {
                pikaSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(foxSoundButton, v);
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
}*/
