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

public class SoundActivityJigglypuff extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_jigglypuff, R.id.jigglypuff_banner);
    }

    private MediaPlayer rollOutCharge = new MediaPlayer();
    private MediaPlayer rollOutRelease = new MediaPlayer();

    @Override
    protected void addSoundIds() {
        soundIds.add(R.id.jigglypuff_cheer_button);
        soundIds.add(R.id.jigglypuff_victory_button);
        soundIds.add(R.id.jigglypuff_taunt_button);
        soundIds.add(R.id.jigglypuff_smash1_button);
        soundIds.add(R.id.jigglypuff_smash2_button);
        soundIds.add(R.id.jigglypuff_smash3_button);
        soundIds.add(R.id.jigglypuff_smash4_button);
        soundIds.add(R.id.jigglypuff_smash5_button);
        soundIds.add(R.id.jigglypuff_rollout_button);
        soundIds.add(R.id.jigglypuff_pound_button);
        soundIds.add(R.id.jigglypuff_rest_button);
        soundIds.add(R.id.jigglypuff_sing_button);
        soundIds.add(R.id.jigglypuff_death1_button);  //Death percent
        soundIds.add(R.id.jigglypuff_death2_button);  //Uah
        soundIds.add(R.id.jigglypuff_star_ko_button);  //jiggly echo
        soundIds.add(R.id.jigglypuff_screen_ko_button);    //death percent

        rollOutCharge = MediaPlayer.create(SoundActivityJigglypuff.this, R.raw.jigglypuff_rollout_charge);
        rollOutRelease = MediaPlayer.create(SoundActivityJigglypuff.this, R.raw.jigglypuff_rollout_release);

    }

    protected void setCustomAction(final SoundButton soundButton) {
        if (soundButton.getId() == R.id.jigglypuff_rollout_button) {
            soundButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            playSound(soundButton, v);
                            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    playRollOutCharge();
                                    rollOutCharge.setLooping(true);
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
        }
    }

    private void playRollOutCharge() {
        try {
            rollOutCharge.stop();
            rollOutCharge.prepare();
            rollOutCharge.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playSoundOnRelease() {
        player.setOnCompletionListener(null);
        rollOutCharge.stop();
        rollOutRelease.start();
        player.reset();
    }

    public void onDestroy() {
        super.onDestroy();
        rollOutCharge.stop();
        rollOutCharge.release();
        rollOutCharge = null;
        rollOutRelease.stop();
        rollOutRelease.release();
        rollOutRelease = null;
        player.stop();
        player.release();
        player = null;
    }

}