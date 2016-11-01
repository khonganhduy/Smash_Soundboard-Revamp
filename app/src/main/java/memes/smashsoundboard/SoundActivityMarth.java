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

public class SoundActivityMarth extends AppCompatActivity {

    private static MediaPlayer player = new MediaPlayer();
    private MediaPlayer release = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_marth);
        final Intent exitIntent = new Intent(this, MainActivity.class);

        ArrayList<Integer> marthSoundIds = new ArrayList<Integer>();
        marthSoundIds.add(R.id.marth_cheer_button);
        marthSoundIds.add(R.id.marth_victory_button);
        marthSoundIds.add(R.id.marth_taunt_button);
        marthSoundIds.add(R.id.marth_smash1_button);
        marthSoundIds.add(R.id.marth_smash2_button);
        marthSoundIds.add(R.id.marth_smash3_button);
        marthSoundIds.add(R.id.marth_smash4_button);
        marthSoundIds.add(R.id.marth_smash5_button);
        marthSoundIds.add(R.id.marth_spot_dodge_button);
        marthSoundIds.add(R.id.marth_neutral_b_button);
        marthSoundIds.add(R.id.marth_side_b_button);
        marthSoundIds.add(R.id.marth_down_b_button);
        marthSoundIds.add(R.id.marth_counter1_button);
        marthSoundIds.add(R.id.marth_counter2_button);
        marthSoundIds.add(R.id.marth_up_b_button);
        marthSoundIds.add(R.id.marth_damage1_button);
        marthSoundIds.add(R.id.marth_damage2_button);
        marthSoundIds.add(R.id.marth_damage3_button);
        marthSoundIds.add(R.id.marth_death1_button);
        marthSoundIds.add(R.id.marth_death2_button);
        marthSoundIds.add(R.id.marth_off_top_button);
        marthSoundIds.add(R.id.marth_quote_button);

        Button marthPalette = (Button) this.findViewById(R.id.marth_banner);
        marthPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        release = MediaPlayer.create(SoundActivityMarth.this, R.raw.marth_neutral_b_release);
        for (int i = 0; i < marthSoundIds.size(); i++) {
            final SoundButton marthSoundButton = (SoundButton) this.findViewById(marthSoundIds.get(i));
            if (i == 9) {
                marthSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(marthSoundButton, v);
                                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            playMarthNeutralBRelease();
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
                marthSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(marthSoundButton, v);
                    }
                });
            }
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

    private void playMarthNeutralBRelease(){
        try {
            release.stop();
            release.prepare();
            release.start();
            player.reset();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playSoundOnRelease() {
            release.start();
            player.reset();
            player.setOnCompletionListener(null);
    }
    public void onDestroy() {
        super.onDestroy();
        player.release();
        player = null;
    }
}
