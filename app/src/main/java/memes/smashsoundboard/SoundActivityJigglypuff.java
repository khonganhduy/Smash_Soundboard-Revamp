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

/*public class SoundActivityJigglypuff extends AppCompatActivity {

    private static MediaPlayer player = new MediaPlayer();
    private MediaPlayer rollOutCharge = new MediaPlayer();
    private MediaPlayer rollOutRelease = new MediaPlayer();

    protected void onCreate(Bundle saveInstanceState)   //Creates activity
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_jigglypuff);    //Finds ID of resource layout
        final Intent exitIntent = new Intent(this, MainActivity.class); //Click button > Go there

        ArrayList<Integer> jigglypuffSoundIds = new ArrayList<Integer>();
        jigglypuffSoundIds.add(R.id.jigglypuff_cheer_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_victory_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_taunt_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_smash1_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_smash2_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_smash3_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_smash4_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_smash5_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_rollout_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_pound_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_rest_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_sing_button);
        jigglypuffSoundIds.add(R.id.jigglypuff_death1_button);  //Death percent
        jigglypuffSoundIds.add(R.id.jigglypuff_death2_button);  //Uah
        jigglypuffSoundIds.add(R.id.jigglypuff_star_ko_button);  //jiggly echo
        jigglypuffSoundIds.add(R.id.jigglypuff_screen_ko_button);    //death percent

        Button jigglypuffPalette = (Button) this.findViewById(R.id.jigglypuff_banner);
        jigglypuffPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });

        rollOutCharge = MediaPlayer.create(SoundActivityJigglypuff.this, R.raw.jigglypuff_rollout_charge);
        rollOutRelease = MediaPlayer.create(SoundActivityJigglypuff.this, R.raw.jigglypuff_rollout_release);
        for (int i = 0; i < jigglypuffSoundIds.size(); i++) {
            final SoundButton jigglypuffSoundButton = (SoundButton) this.findViewById(jigglypuffSoundIds.get(i));
            if (i == 8) {
                jigglypuffSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(jigglypuffSoundButton, v);
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

            } else {
                jigglypuffSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(jigglypuffSoundButton, v);
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
    private void playRollOutCharge(){
        try {
            rollOutCharge.stop();
            rollOutCharge.prepare();
            rollOutCharge.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playSoundOnRelease(){
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

}*/