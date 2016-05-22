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
        setContentView(R.layout.activity_sound_fox);

//        Fox variables
        final SoundButton cheer = (SoundButton)this.findViewById(R.id.fox_cheer);
        final SoundButton victory = (SoundButton)this.findViewById(R.id.fox_mission_complete);
        final SoundButton taunt = (SoundButton)this.findViewById(R.id.fox_taunt);
        final SoundButton jpTaunt = (SoundButton)this.findViewById(R.id.fox_jp_taunt);
        final SoundButton smash1 = (SoundButton)this.findViewById(R.id.fox_smash1);
        final SoundButton smash2 = (SoundButton)this.findViewById(R.id.fox_smash2);
        final SoundButton smash3 = (SoundButton)this.findViewById(R.id.fox_smash3);
        final SoundButton smash4 = (SoundButton)this.findViewById(R.id.fox_smash4);
        final SoundButton smash5 = (SoundButton)this.findViewById(R.id.fox_smash5);
        final SoundButton spotDodge = (SoundButton)this.findViewById(R.id.fox_spot_dodge);
        final SoundButton foxLaser = (SoundButton)this.findViewById(R.id.fox_laser);
        final SoundButton illusion = (SoundButton)this.findViewById(R.id.fox_illusion);
        final SoundButton blip = (SoundButton)this.findViewById(R.id.fox_shine);
        final SoundButton firefox = (SoundButton)this.findViewById(R.id.fox_firefox);
        final SoundButton foxDamage1 = (SoundButton)this.findViewById(R.id.fox_damage1);
        final SoundButton foxDamage2 = (SoundButton)this.findViewById(R.id.fox_damage2);
        final SoundButton foxDamage3 = (SoundButton)this.findViewById(R.id.fox_damage3);
        final SoundButton foxDeath1 = (SoundButton)this.findViewById(R.id.fox_death1);
        final SoundButton foxDeath2 = (SoundButton)this.findViewById(R.id.fox_death2);
        final SoundButton foxDeath3 = (SoundButton)this.findViewById(R.id.fox_death3);
        final SoundButton foxOffTop = (SoundButton)this.findViewById(R.id.fox_off_top);
        final SoundButton foxDoubleJump = (SoundButton)this.findViewById(R.id.fox_double_jump);
        final SoundButton foxGunDraw = (SoundButton)this.findViewById(R.id.fox_gun_draw);
        final SoundButton foxGunWithdrawal = (SoundButton)this.findViewById(R.id.fox_gun_withdrawal);

//        Falco
        setContentView(R.layout.activity_sound_falco);

//        Fox sounds
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
        spotDodge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(spotDodge, v);
            }
        });
        foxLaser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxLaser, v);
            }
        });
        illusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(illusion, v);
            }
        });
        firefox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(firefox, v);
            }
        });
        blip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(blip, v);
            }
        });
        foxDamage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxDamage1, v);
            }
        });
        foxDamage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxDamage2, v);
            }
        });
        foxDamage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxDamage3, v);
            }
        });
        foxDeath1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxDeath1, v);
            }
        });
        foxDeath2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxDeath2, v);
            }
        });
        foxDeath3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxDeath3, v);
            }
        });
        foxOffTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxOffTop, v);
            }
        });
        foxDoubleJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxDoubleJump, v);
            }
        });
        foxGunDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxGunDraw, v);
            }
        });
        foxGunWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(foxGunWithdrawal, v);
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
