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

public class SoundActivityFox extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_fox);
        final Intent exitIntent = new Intent(this, MainActivity.class);

//        Fox variables
        ArrayList<Integer> foxSoundIds = new ArrayList<Integer>();
        foxSoundIds.add(R.id.fox_cheer);
        foxSoundIds.add(R.id.fox_mission_complete);
        foxSoundIds.add(R.id.fox_taunt);
        foxSoundIds.add(R.id.fox_jp_taunt);
        foxSoundIds.add(R.id.fox_smash1);
        foxSoundIds.add(R.id.fox_smash2);
        foxSoundIds.add(R.id.fox_smash3);
        foxSoundIds.add(R.id.fox_smash4);
        foxSoundIds.add(R.id.fox_smash5);
        foxSoundIds.add(R.id.fox_spot_dodge);
        foxSoundIds.add(R.id.fox_laser);
        foxSoundIds.add(R.id.fox_illusion);
        foxSoundIds.add(R.id.fox_shine);
        foxSoundIds.add(R.id.fox_firefox);
        foxSoundIds.add(R.id.fox_damage1);
        foxSoundIds.add(R.id.fox_damage2);
        foxSoundIds.add(R.id.fox_damage3);
        foxSoundIds.add(R.id.fox_death1);
        foxSoundIds.add(R.id.fox_death2);
        foxSoundIds.add(R.id.fox_death3);
        foxSoundIds.add(R.id.fox_off_top);
        foxSoundIds.add(R.id.fox_double_jump);
        foxSoundIds.add(R.id.fox_gun_draw);
        foxSoundIds.add(R.id.fox_gun_withdrawal);
        foxSoundIds.add(R.id.fox_multishine);

        Button foxPalette = (Button) this.findViewById(R.id.fox_banner);
        foxPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        for (int i = 0; i < foxSoundIds.size(); i++) {
            final SoundButton foxSoundButton = (SoundButton) this.findViewById(foxSoundIds.get(i));
            if (foxSoundIds.size() - 1 == i) {
                foxSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(foxSoundButton, v);
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
                foxSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(foxSoundButton, v);
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
}
