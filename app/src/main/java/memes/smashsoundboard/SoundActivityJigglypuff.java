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

        addButtonIds.put(R.id.jigglypuff_rollout_button, Act.CHAIN_LOOP);

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
    protected int getStartSound(SoundButton button)
    {
        return R.string.JIGGLYPUFF_ROLLOUT_STARTUP;
    }

}