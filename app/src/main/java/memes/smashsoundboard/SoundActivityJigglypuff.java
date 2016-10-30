package memes.smashsoundboard;

public class SoundActivityJigglypuff {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle saveInstanceState)   //Creates activity
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_jigglypuff);    //Finds ID of resource layout
        final Intent exitIntent = new Intent(this, MainActivity.class); //Click button > Go there
    }
    ArrayList<Integer> jigglypuffSoundIds = new ArrayList<Integer>();
    jigglypuffSoundsIds.add(R.id.jigglypuff_cheer);
    jigglypuffSoundsIds.add(R.id.jigglypuff_victory);
    jigglypuffSoundsIds.add(R.id.jigglypuff_taunt);
    jigglypuffSoundsIds.add(R.id.jigglypuff_smash1);
    jigglypuffSoundsIds.add(R.id.jigglypuff_smash2);
    jigglypuffSoundsIds.add(R.id.jigglypuff_smash3);
    jigglypuffSoundsIds.add(R.id.jigglypuff_smash5);
    jigglypuffSoundsIds.add(R.id.jigglypuff_smash5);
    jigglypuffSoundsIds.add(R.id.jigglypuff_initial_rollout);
    jigglypuffSoundsIds.add(R.id.jigglypuff_rollout_charge);
    jigglypuffSoundsIds.add(R.id.jigglypuff_rollout_release);
    jigglypuffSoundsIds.add(R.id.jigglypuff_pound);
    jigglypuffSoundsIds.add(R.id.jigglypuff_rest);
    jigglypuffSoundsIds.add(R.id.jigglypuff_rest_bubbles);
    jigglypuffSoundsIds.add(R.id.jigglypuff_sing);
    jigglypuffSoundsIds.add(R.id.jigglypuff_death1);  //Death percent
    jigglypuffSoundsIds.add(R.id.jigglypuff_death2);  //Uah
    jigglypuffSoundsIds.add(R.id.jigglypuff_star_ko);  //jiggly echo
    jigglypuffSoundsIds.add(R.id.jigglypuff_screen_ko);    //death percent

    Button jigglypuffPalette = (Button)this.findViewById(R.id.jigglypuff_banner);
    jigglypuffPalette.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            player.reset();
            startActivity(exitIntent);
        }
    });
    final MediaPlayer release = MediaPlayer.create(SoundActivityJigglypuff.this, R.raw.jigglypuff_neutral_b_release);
    for (int i = 0; i < jigglypuffSoundIds.size(); i++){
        final SoundButton jigglypuffSoundButton = (SoundButton)this.findViewById(jigglypuffSoundIds.get(i));
        if (jigglypuffSoundIds.size()-1 == i){
            jigglypuffSoundButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            playSound(jigglypuffSoundButton,v);
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
        }
        else {
            jigglypuffSoundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(jigglypuffSoundButton, v);
                }
            });
        }
    }

}