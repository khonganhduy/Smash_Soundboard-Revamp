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

public class SoundActivitySheik extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_sheik);
        final Intent exitIntent = new Intent(this, MainActivity.class);

        ArrayList<Integer> sheikSoundIds = new ArrayList<Integer>();
        sheikSoundIds.add(R.id.sheik_cheer);
        sheikSoundIds.add(R.id.sheik_victory);
        sheikSoundIds.add(R.id.sheik_taunt);
        sheikSoundIds.add(R.id.sheik_smash1);
        sheikSoundIds.add(R.id.sheik_smash2);
        sheikSoundIds.add(R.id.sheik_smash3);
        sheikSoundIds.add(R.id.sheik_smash4);
        sheikSoundIds.add(R.id.sheik_smash5);
        sheikSoundIds.add(R.id.sheik_spot_dodge);
        sheikSoundIds.add(R.id.sheik_neutral_b);
        sheikSoundIds.add(R.id.sheik_side_b);
        sheikSoundIds.add(R.id.sheik_down_b);
        sheikSoundIds.add(R.id.sheik_up_b);
        sheikSoundIds.add(R.id.sheik_damage1);
        sheikSoundIds.add(R.id.sheik_damage2);
        sheikSoundIds.add(R.id.sheik_damage3);
        sheikSoundIds.add(R.id.sheik_death1);
        sheikSoundIds.add(R.id.sheik_death2);
        sheikSoundIds.add(R.id.sheik_death3);
        sheikSoundIds.add(R.id.sheik_off_top);
        sheikSoundIds.add(R.id.sheik_jump);

        Button sheikPalette = (Button) this.findViewById(R.id.sheik_banner);
        sheikPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        for (int i = 0; i < sheikSoundIds.size(); i++) {
            final SoundButton sheikSoundButton = (SoundButton) this.findViewById(sheikSoundIds.get(i));
            if (i == 10) {
                sheikSoundButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                playSound(sheikSoundButton, v);
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
                sheikSoundButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(sheikSoundButton, v);
                    }
                });
            }
        }
    }

       /*
//        Sheik variables
        final SoundButton cheer = (SoundButton)this.findViewById(R.id.sheik_cheer);
        final SoundButton victory = (SoundButton)this.findViewById(R.id.sheik_victory);
        final SoundButton taunt = (SoundButton)this.findViewById(R.id.sheik_taunt);
        final SoundButton smash1 = (SoundButton)this.findViewById(R.id.sheik_smash1);
        final SoundButton smash2 = (SoundButton)this.findViewById(R.id.sheik_smash2);
        final SoundButton smash3 = (SoundButton)this.findViewById(R.id.sheik_smash3);
        final SoundButton smash4 = (SoundButton)this.findViewById(R.id.sheik_smash4);
        final SoundButton smash5 = (SoundButton)this.findViewById(R.id.sheik_smash5);
        final SoundButton spotDodge = (SoundButton)this.findViewById(R.id.sheik_spot_dodge);
        final SoundButton needles = (SoundButton)this.findViewById(R.id.sheik_neutral_b);
        final SoundButton chain = (SoundButton)this.findViewById(R.id.sheik_side_b);
        final SoundButton transform = (SoundButton)this.findViewById(R.id.sheik_down_b);
        final SoundButton explosion = (SoundButton)this.findViewById(R.id.sheik_up_b);
        final SoundButton sheikDamage1 = (SoundButton)this.findViewById(R.id.sheik_damage1);
        final SoundButton sheikDamage2 = (SoundButton)this.findViewById(R.id.sheik_damage2);
        final SoundButton sheikDamage3 = (SoundButton)this.findViewById(R.id.sheik_damage3);
        final SoundButton sheikDeath1 = (SoundButton)this.findViewById(R.id.sheik_death1);
        final SoundButton sheikDeath2 = (SoundButton)this.findViewById(R.id.sheik_death2);
        final SoundButton sheikDeath3 = (SoundButton)this.findViewById(R.id.sheik_death3);
        final SoundButton offTop = (SoundButton)this.findViewById(R.id.sheik_off_top);
        final SoundButton jump = (SoundButton)this.findViewById(R.id.sheik_jump);

//        Sheik sounds
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
        needles.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        playSound(needles,v);
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
        chain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        playSound(chain,v);
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
        explosion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(explosion, v);
            }
        });
        transform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(transform, v);
            }
        });
        sheikDamage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(sheikDamage1, v);
            }
        });
        sheikDamage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(sheikDamage2, v);
            }
        });
        sheikDamage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(sheikDamage3, v);
            }
        });
        sheikDeath1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(sheikDeath1, v);
            }
        });
        sheikDeath2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(sheikDeath2, v);
            }
        });
        sheikDeath3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(sheikDeath3, v);
            }
        });
        offTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(offTop, v);
            }
        });
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(jump, v);
            }
        });

    }
    */
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
