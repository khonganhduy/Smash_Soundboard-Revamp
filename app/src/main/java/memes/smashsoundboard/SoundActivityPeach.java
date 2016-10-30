package memes.smashsoundboard;

public class SoundActivityPeach {

    private static final MediaPlayer player = new MediaPlayer();

    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound_peach);
        final Intent exitIntent = new Intent(this, MainActivity.class);
    }
    ArrayList<Integer> peachSoundIds = new ArrayList<Integer>();
    peachSoundsIds.add(R.id.peach_cheer);
    peachSoundsIds.add(R.id.peach_victory1);
    peachSoundsIds.add(R.id.peach_victory2);
    peachSoundsIds.add(R.id.peach_taunt);
    peachSoundsIds.add(R.id.peach_smash1);
    peachSoundsIds.add(R.id.peach_smash2);
    peachSoundsIds.add(R.id.peach_smash3);
    peachSoundsIds.add(R.id.peach_smash4);
    peachSoundsIds.add(R.id.peach_smash5);
    peachSoundsIds.add(R.id.peach_pan);
    peachSoundsIds.add(R.id.peach_golf_club);
    peachSoundsIds.add(R.id.peach_tennis_racket);
    peachSoundsIds.add(R.id.peach_jump);
    peachSoundsIds.add(R.id.peach_double_jump);
    peachSoundsIds.add(R.id.peach_toad);
    peachSoundsIds.add(R.id.peach_bomber);
    peachSoundsIds.add(R.id.peach_pull);
    peachSoundsIds.add(R.id.peach_parasol);
    peachSoundsIds.add(R.id.peach_damage);
    peachSoundsIds.add(R.id.peach_death);
    peachSoundsIds.add(R.id.peach_star_ko);
    peachSoundsIds.add(R.id.peach_screen_ko);
}
