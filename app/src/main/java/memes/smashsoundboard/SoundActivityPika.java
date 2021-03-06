package memes.smashsoundboard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;

/**
 * Created by Akabe on 10/29/2016.
 */

public class SoundActivityPika extends SoundActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sound_pika, R.id.pika_banner);
    }

    private static final MediaPlayer player = new MediaPlayer();
    MediaPlayer sBashRelese = new MediaPlayer();

    protected void addSoundIds() {

//        Fox variables
        addButtonIds.add(R.id.pika_cheer_button);
        addButtonIds.add(R.id.pika_victory_button);
        addButtonIds.add(R.id.pika_taunt_button);
        addButtonIds.add(R.id.pika_smash1_button);
        addButtonIds.add(R.id.pika_smash2_button);
        addButtonIds.add(R.id.pika_smash3_button);
        addButtonIds.add(R.id.pika_smash4_button);
        addButtonIds.add(R.id.pika_smash5_button);
        addButtonIds.add(R.id.pika_tjolt_button);

        addButtonIds.put(R.id.pika_skullbash_button, Act.CHAIN);

        addButtonIds.add(R.id.pika_thunder_button);
        addButtonIds.add(R.id.pika_qatk_button);
        addButtonIds.add(R.id.pika_damage1_button);
        addButtonIds.add(R.id.pika_death1_button);
        addButtonIds.add(R.id.pika_death2_button);
        addButtonIds.add(R.id.pika_star_ko_button);

        soundChains.put(R.id.pika_skullbash_button, R.string.PIKA_SKULLBASH_RELEASE);

    }
    @Override
    protected int getStartSound(SoundButton button)
    {
        return R.string.PIKA_SKULLBASH_INITIAL;
    }
}
