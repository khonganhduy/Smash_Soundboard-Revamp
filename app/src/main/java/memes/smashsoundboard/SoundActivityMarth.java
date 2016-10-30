package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class SoundActivityMarth extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_marth);
        final Intent exitIntent = new Intent(this, MainActivity.class);

        ArrayList<Integer> marthSoundIds = new ArrayList<Integer>();
        marthSoundIds.add(R.id.marth_cheer);
        marthSoundIds.add(R.id.marth_victory);
        marthSoundIds.add(R.id.marth_taunt);
        marthSoundIds.add(R.id.marth_smash1);
        marthSoundIds.add(R.id.marth_smash2);
        marthSoundIds.add(R.id.marth_smash3);
        marthSoundIds.add(R.id.marth_smash4);
        marthSoundIds.add(R.id.marth_smash5);
        marthSoundIds.add(R.id.marth_spot_dodge);
        marthSoundIds.add(R.id.marth_neutral_b);
        marthSoundIds.add(R.id.marth_side_b);
        marthSoundIds.add(R.id.marth_down_b);
        marthSoundIds.add(R.id.marth_counter1);
        marthSoundIds.add(R.id.marth_counter2);
        marthSoundIds.add(R.id.marth_up_b);
        marthSoundIds.add(R.id.marth_damage1);
        marthSoundIds.add(R.id.marth_damage2);
        marthSoundIds.add(R.id.marth_damage3);
        marthSoundIds.add(R.id.marth_death1);
        marthSoundIds.add(R.id.marth_death2);
        marthSoundIds.add(R.id.marth_off_top);
        marthSoundIds.add(R.id.marth_quote);

        Button marthPalette = (Button) this.findViewById(R.id.marth_banner);
        marthPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                startActivity(exitIntent);
            }
        });
        final MediaPlayer release = MediaPlayer.create(SoundActivityMarth.this, R.raw.marth_neutral_b_release);
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
                                        release.start();
                                    }
                                });
                                break;
                            case MotionEvent.ACTION_UP:
                                    release.start();
                                player.reset();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                    release.start();
                                player.reset();
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


//        Marth variables
        /*final SoundButton cheer = (SoundButton)this.findViewById(R.id.marth_cheer);
        final SoundButton victory = (SoundButton)this.findViewById(R.id.marth_victory);
        final SoundButton taunt = (SoundButton)this.findViewById(R.id.marth_taunt);
        final SoundButton smash1 = (SoundButton)this.findViewById(R.id.marth_smash1);
        final SoundButton smash2 = (SoundButton)this.findViewById(R.id.marth_smash2);
        final SoundButton smash3 = (SoundButton)this.findViewById(R.id.marth_smash3);
        final SoundButton smash4 = (SoundButton)this.findViewById(R.id.marth_smash4);
        final SoundButton smash5 = (SoundButton)this.findViewById(R.id.marth_smash5);
        final SoundButton spotDodge = (SoundButton)this.findViewById(R.id.marth_spot_dodge);
        final SoundButton shieldBreaker = (SoundButton)this.findViewById(R.id.marth_neutral_b);
        final SoundButton dancingBlade = (SoundButton)this.findViewById(R.id.marth_side_b);
        final SoundButton counter = (SoundButton)this.findViewById(R.id.marth_down_b);
        final SoundButton counter1 = (SoundButton)this.findViewById(R.id.marth_counter1);
        final SoundButton counter2 = (SoundButton)this.findViewById(R.id.marth_counter2);
        final SoundButton dolphinSlash = (SoundButton)this.findViewById(R.id.marth_up_b);
        final SoundButton marthDamage1 = (SoundButton)this.findViewById(R.id.marth_damage1);
        final SoundButton marthDamage2 = (SoundButton)this.findViewById(R.id.marth_damage2);
        final SoundButton marthDamage3 = (SoundButton)this.findViewById(R.id.marth_damage3);
        final SoundButton marthDeath1 = (SoundButton)this.findViewById(R.id.marth_death1);
        final SoundButton marthDeath2 = (SoundButton)this.findViewById(R.id.marth_death2);
        final SoundButton offTop = (SoundButton)this.findViewById(R.id.marth_off_top);
        final SoundButton quote = (SoundButton)this.findViewById(R.id.marth_quote);

//        Marth sounds
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
        shieldBreaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(shieldBreaker, v);
            }
        });
        dancingBlade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(dancingBlade, v);
            }
        });
        dolphinSlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(dolphinSlash, v);
            }
        });
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(counter, v);
            }
        });
        counter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(counter1, v);
            }
        });
        counter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(counter2, v);
            }
        });
        marthDamage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(marthDamage1, v);
            }
        });
        marthDamage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(marthDamage2, v);
            }
        });
        marthDamage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(marthDamage3, v);
            }
        });
        marthDeath1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(marthDeath1, v);
            }
        });
        marthDeath2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(marthDeath2, v);
            }
        });
        offTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(offTop, v);
            }
        });
        quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(quote, v);
            }
        });

    }*/

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
