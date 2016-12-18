package memes.smashsoundboard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;

public class SoundActivityJigglypuff extends SoundActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_jigglypuff, R.id.jigglypuff_banner);
    }

    private MediaPlayer rollOutCharge = new MediaPlayer();
    private MediaPlayer rollOutRelease = new MediaPlayer();

    @Override
    protected void addSoundIds() {
        addButtonIds.add(R.id.jigglypuff_cheer_button);
        addButtonIds.add(R.id.jigglypuff_victory_button);
        addButtonIds.add(R.id.jigglypuff_taunt_button);
        addButtonIds.add(R.id.jigglypuff_smash1_button);
        addButtonIds.add(R.id.jigglypuff_smash2_button);
        addButtonIds.add(R.id.jigglypuff_smash3_button);
        addButtonIds.add(R.id.jigglypuff_smash4_button);
        addButtonIds.add(R.id.jigglypuff_smash5_button);

        addButtonIds.put(R.id.jigglypuff_rollout_button, Act.CHAIN);

        addButtonIds.add(R.id.jigglypuff_pound_button);
        addButtonIds.add(R.id.jigglypuff_rest_button);
        addButtonIds.add(R.id.jigglypuff_sing_button);
        addButtonIds.add(R.id.jigglypuff_death1_button);  //Death percent
        addButtonIds.add(R.id.jigglypuff_death2_button);  //Uah
        addButtonIds.add(R.id.jigglypuff_star_ko_button);  //jiggly echo
        addButtonIds.add(R.id.jigglypuff_screen_ko_button);    //death percent

        soundChains.put(R.id.jigglypuff_rollout_button, R.string.JIGGLYPUFF_ROLLOUT_HOLD);
        soundChains.put(R.string.JIGGLYPUFF_ROLLOUT_HOLD, R.string.JIGGLYPUFF_ROLLOUT_RELEASE);
    }

    @Override
    protected void setChainLogic(SoundButton soundButton, final int firstSoundId) {
        final int loopSound = loadedSoundChains.get(firstSoundId);
        final int releaseSound = loadedSoundChains.get(loopSound);
        final SoundTimer timer = new SoundTimer(R.string.JIGGLYPUFF_ROLLOUT_STARTUP);
        soundButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        playSound(firstSoundId, v, 0);
                        timer.start();
                        while (timer.isAlive()) {
                        }
                        if (!timer.isInterrupted())
                            playSound(loopSound, v, -1);
                        break;
                    case MotionEvent.ACTION_UP:
                        timer.interrupt();
                        playSound(releaseSound, v, 0);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        timer.interrupt();
                        playSound(releaseSound, v, 0);
                        break;
                }
                return false;
            }
        });
    }

}