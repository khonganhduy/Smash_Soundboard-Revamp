package memes.smashsoundboard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

public class SoundActivity extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        final SoundButton cheer = (SoundButton)this.findViewById(R.id.fox_cheer);
        final SoundButton victory = (SoundButton)this.findViewById(R.id.fox_mission_complete);
        final SoundButton taunt = (SoundButton)this.findViewById(R.id.fox_taunt);
        final SoundButton jpTaunt = (SoundButton)this.findViewById(R.id.fox_jp_taunt);
        final SoundButton smash1 = (SoundButton)this.findViewById(R.id.fox_smash1);
        final SoundButton smash2 = (SoundButton)this.findViewById(R.id.fox_smash2);
        final SoundButton smash3 = (SoundButton)this.findViewById(R.id.fox_smash3);
        final SoundButton smash4 = (SoundButton)this.findViewById(R.id.fox_smash4);
        final SoundButton smash5 = (SoundButton)this.findViewById(R.id.fox_smash5);
        final SoundButton blip = (SoundButton)this.findViewById(R.id.fox_shine);
        final SoundButton firefox = (SoundButton)this.findViewById(R.id.fox_firefox);
        cheer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(cheer, v);
            }
        });
        victory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(victory, v);
            }
        });
        taunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(taunt, v);
            }
        });
        jpTaunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(jpTaunt, v);
            }
        });
        smash1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(smash1, v);
            }
        });
        smash2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(smash2, v);
            }
        });
        smash3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(smash3, v);
            }
        });
        smash4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(smash4, v);
            }
        });
        smash5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(smash5, v);
            }
        });
        blip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(blip, v);
            }
        });
        firefox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(firefox, v);
            }
        });

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
