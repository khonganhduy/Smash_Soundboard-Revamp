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

public class SoundActivityFalco extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_falco);
        final Intent exitIntent = new Intent(this, MainActivity.class);

//        Falco variables
        ArrayList<Integer> falcoSoundIds = new ArrayList<Integer>();
        falcoSoundIds.add(R.id.falco_cheer);
        falcoSoundIds.add(R.id.falco_mission_complete);
        falcoSoundIds.add(R.id.falco_taunt);
        falcoSoundIds.add(R.id.falco_smash1);
        falcoSoundIds.add(R.id.falco_smash2);
        falcoSoundIds.add(R.id.falco_smash3);
        falcoSoundIds.add(R.id.falco_smash4);
        falcoSoundIds.add(R.id.falco_smash5);
        falcoSoundIds.add(R.id.falco_spot_dodge);
        falcoSoundIds.add(R.id.falco_laser);
        falcoSoundIds.add(R.id.falco_phantasm);
        falcoSoundIds.add(R.id.falco_shine);
        falcoSoundIds.add(R.id.falco_firebird);
        falcoSoundIds.add(R.id.falco_damage1);
        falcoSoundIds.add(R.id.falco_damage2);
        falcoSoundIds.add(R.id.falco_damage3);
        falcoSoundIds.add(R.id.falco_death1);
        falcoSoundIds.add(R.id.falco_death2);
        falcoSoundIds.add(R.id.falco_death3);
        falcoSoundIds.add(R.id.falco_off_top);
        falcoSoundIds.add(R.id.falco_double_jump);
        falcoSoundIds.add(R.id.falco_gun_draw);
        falcoSoundIds.add(R.id.falco_gun_withdrawal);
        falcoSoundIds.add(R.id.falco_multishine);

        Button falcoPalette = (Button)this.findViewById(R.id.falco_banner);
        falcoPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });

        for (int i = 0; i < falcoSoundIds.size(); i++) {
            final SoundButton falcoSoundButton = (SoundButton) this.findViewById(falcoSoundIds.get(i));
            if (falcoSoundIds.size() - 1 == i) {
                falcoSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(falcoSoundButton, v);
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
                falcoSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(falcoSoundButton, v);
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
}
