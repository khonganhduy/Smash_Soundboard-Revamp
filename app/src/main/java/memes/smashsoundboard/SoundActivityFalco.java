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
        /*
        final SoundButton cheer = (SoundButton)this.findViewById(R.id.falco_cheer);
        final SoundButton victory = (SoundButton)this.findViewById(R.id.falco_mission_complete);
        final SoundButton taunt = (SoundButton)this.findViewById(R.id.falco_taunt);
        final SoundButton smash1 = (SoundButton)this.findViewById(R.id.falco_smash1);
        final SoundButton smash2 = (SoundButton)this.findViewById(R.id.falco_smash2);
        final SoundButton smash3 = (SoundButton)this.findViewById(R.id.falco_smash3);
        final SoundButton smash4 = (SoundButton)this.findViewById(R.id.falco_smash4);
        final SoundButton smash5 = (SoundButton)this.findViewById(R.id.falco_smash5);
        final SoundButton spotDodge = (SoundButton)this.findViewById(R.id.falco_spot_dodge);
        final SoundButton falcoLaser = (SoundButton)this.findViewById(R.id.falco_laser);
        final SoundButton phantasm = (SoundButton)this.findViewById(R.id.falco_phantasm);
        final SoundButton blip = (SoundButton)this.findViewById(R.id.falco_shine);
        final SoundButton firebird = (SoundButton)this.findViewById(R.id.falco_firebird);
        final SoundButton falcoDamage1 = (SoundButton)this.findViewById(R.id.falco_damage1);
        final SoundButton falcoDamage2 = (SoundButton)this.findViewById(R.id.falco_damage2);
        final SoundButton falcoDamage3 = (SoundButton)this.findViewById(R.id.falco_damage3);
        final SoundButton falcoDeath1 = (SoundButton)this.findViewById(R.id.falco_death1);
        final SoundButton falcoDeath2 = (SoundButton)this.findViewById(R.id.falco_death2);
        final SoundButton falcoDeath3 = (SoundButton)this.findViewById(R.id.falco_death3);
        final SoundButton falcoOffTop = (SoundButton)this.findViewById(R.id.falco_off_top);
        final SoundButton falcoDoubleJump = (SoundButton)this.findViewById(R.id.falco_double_jump);
        final SoundButton falcoGunDraw = (SoundButton)this.findViewById(R.id.falco_gun_draw);
        final SoundButton falcoGunWithdrawal = (SoundButton)this.findViewById(R.id.falco_gun_withdrawal);
        final SoundButton blips = (SoundButton)this.findViewById(R.id.falco_multishine);

//        Falco sounds
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
        falcoLaser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoLaser, v);
            }
        });
        phantasm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(phantasm, v);
            }
        });
        firebird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(firebird, v);
            }
        });
        blip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(blip, v);
            }
        });
        falcoDamage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoDamage1, v);
            }
        });
        falcoDamage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoDamage2, v);
            }
        });
        falcoDamage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoDamage3, v);
            }
        });
        falcoDeath1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoDeath1, v);
            }
        });
        falcoDeath2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoDeath2, v);
            }
        });
        falcoDeath3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoDeath3, v);
            }
        });
        falcoOffTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoOffTop, v);
            }
        });
        falcoDoubleJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoDoubleJump, v);
            }
        });
        falcoGunDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoGunDraw, v);
            }
        });
        falcoGunWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(falcoGunWithdrawal, v);
            }
        });
        blips.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        playSound(blips,v);
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
        */


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
