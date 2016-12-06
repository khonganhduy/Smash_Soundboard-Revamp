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
/*
public class SoundActivityPika extends AppCompatActivity {
    private static final MediaPlayer player = new MediaPlayer();
    MediaPlayer sBashRelese = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pika);
        final Intent exitIntent = new Intent(this, MainActivity.class);

//        Fox variables
        ArrayList<Integer> pikaSoundIds = new ArrayList<Integer>();
        pikaSoundIds.add(R.id.pika_cheer_button);
        pikaSoundIds.add(R.id.pika_victory_button);
        pikaSoundIds.add(R.id.pika_taunt_button);
        pikaSoundIds.add(R.id.pika_smash1_button);
        pikaSoundIds.add(R.id.pika_smash2_button);
        pikaSoundIds.add(R.id.pika_smash3_button);
        pikaSoundIds.add(R.id.pika_smash4_button);
        pikaSoundIds.add(R.id.pika_smash5_button);
        pikaSoundIds.add(R.id.pika_tjolt_button);
        pikaSoundIds.add(R.id.pika_sbash_button);
        pikaSoundIds.add(R.id.pika_thunder_button);
        pikaSoundIds.add(R.id.pika_qatk_button);
        pikaSoundIds.add(R.id.pika_damage1_button);
        pikaSoundIds.add(R.id.pika_death1_button);
        pikaSoundIds.add(R.id.pika_death2_button);
        pikaSoundIds.add(R.id.pika_star_ko_button);

        Button pikaPalette = (Button) this.findViewById(R.id.pika_banner);
        pikaPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });

        sBashRelese = MediaPlayer.create(SoundActivityPika.this, R.raw.pika_skullbash_release);
        for (int i = 0; i < pikaSoundIds.size(); i++) {
            final SoundButton pikaSoundButton = (SoundButton) this.findViewById(pikaSoundIds.get(i));
            if (pikaSoundIds.get(i) == R.id.pika_sbash_button) {
                pikaSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(pikaSoundButton, v);
                                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        playPikaSBashRelease();
                                    }
                                });
                                break;
                            case MotionEvent.ACTION_UP:
                                playSoundOnRelease();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                playSoundOnRelease();
                                break;
                        }
                        return false;
                    }
                });
            } else {
                pikaSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(pikaSoundButton, v);
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

    private void playPikaSBashRelease(){
        try {
            sBashRelese.stop();
            sBashRelese.prepare();
            sBashRelese.start();
            player.reset();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playSoundOnRelease() {
        sBashRelese.start();
        player.reset();
        player.setOnCompletionListener(null);
    }
}
*/