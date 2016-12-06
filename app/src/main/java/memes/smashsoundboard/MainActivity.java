package memes.smashsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static MediaPlayer player = new MediaPlayer();
    private MediaPlayer music = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(MainActivity.this, R.raw.menu_1);
        music.start();
        music.setLooping(true);

        ArrayList<Integer> sectionId = new ArrayList<Integer>();
        sectionId.add(R.id.fox_section);
        sectionId.add(R.id.falco_section);
        sectionId.add(R.id.sheik_section);
        sectionId.add(R.id.marth_section);
        sectionId.add(R.id.peach_section);
        sectionId.add(R.id.jigglypuff_section);
        sectionId.add(R.id.pika_section);
        sectionId.add(R.id.captainfalcon_section);

        ArrayList<Class> intentName = new ArrayList<Class>();
        intentName.add(SoundActivityFox.class);
        intentName.add(SoundActivityFalco.class);
        intentName.add(SoundActivitySheik.class);
        intentName.add(SoundActivityMarth.class);
        intentName.add(SoundActivityPeach.class);
        intentName.add(SoundActivityJigglypuff.class);
        intentName.add(SoundActivityPika.class);
        intentName.add(SoundActivityCaptainFalcon.class);

        for (int i = 0; i < sectionId.size(); i++) {
            final SoundButton aButton = (SoundButton) this.findViewById(sectionId.get(i));
            final Intent intent = new Intent(this,intentName.get(i));
            aButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(aButton, v);
                    startActivity(intent);
                }
            });

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
    public void onPause() {
        super.onPause();
        music.pause();
    }
    public void onResume() {
        super.onResume();
        music.start();
    }
    public void onDestroy(){
        super.onDestroy();
        music.release();
        music = null;
        player.release();
        player = null;
    }
}
