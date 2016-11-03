package memes.smashsoundboard;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
//Test edit #1

public class SoundActivityFox extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_fox);
        final Intent exitIntent = new Intent(this, MainActivity.class);

//        Fox variables
        Resources res = getResources();
        int[] foxIDs = res.getIntArray(R.array.FOX_SOUNDS_ARRAY);
        ArrayList<Integer> foxSoundIds = new ArrayList<Integer>();
        ArrayList<Integer> foxSoundRef = new ArrayList<Integer>();

        foxSoundIds.add(R.id.fox_cheer_button);
        foxSoundIds.add(R.id.fox_mission_complete_button);
        foxSoundIds.add(R.id.fox_taunt_button);
        foxSoundIds.add(R.id.fox_jp_taunt_button);
        foxSoundIds.add(R.id.fox_smash1_button);
        foxSoundIds.add(R.id.fox_smash2_button);
        foxSoundIds.add(R.id.fox_smash3_button);
        foxSoundIds.add(R.id.fox_smash4_button);
        foxSoundIds.add(R.id.fox_smash5_button);
        foxSoundIds.add(R.id.fox_spot_dodge_button);
        foxSoundIds.add(R.id.fox_laser_button);
        foxSoundIds.add(R.id.fox_illusion_button);
        foxSoundIds.add(R.id.fox_shine_button);
        foxSoundIds.add(R.id.fox_firefox_button);
        foxSoundIds.add(R.id.fox_damage1_button);
        foxSoundIds.add(R.id.fox_damage2_button);
        foxSoundIds.add(R.id.fox_damage3_button);
        foxSoundIds.add(R.id.fox_death1_button);
        foxSoundIds.add(R.id.fox_death2_button);
        foxSoundIds.add(R.id.fox_death3_button);
        foxSoundIds.add(R.id.fox_off_top_button);
        foxSoundIds.add(R.id.fox_double_jump_button);
        foxSoundIds.add(R.id.fox_gun_draw_button);
        foxSoundIds.add(R.id.fox_gun_withdrawal_button);
        foxSoundIds.add(R.id.fox_multishine_button);


        for(int i:foxIDs)
        {
            foxSoundRef.add(i);
        }
        for(int i = 0; i < foxSoundIds.size(); i++)
        {
            if(foxSoundIds.get(i) != foxSoundRef.get(i))
                System.out.println("Non matching reference: " + foxSoundIds.get(i));
        }
        Button foxPalette = (Button) this.findViewById(R.id.fox_banner_button);
        foxPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        for (int i = 0; i < foxSoundIds.size(); i++) {
            final SoundButton foxSoundButton = (SoundButton) this.findViewById(foxSoundIds.get(i));
            if (foxSoundButton.getId() == R.id.fox_multishine_button) {
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