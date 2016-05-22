package memes.smashsoundboard;

import android.content.res.XmlResourceParser;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final MediaPlayer player = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SoundButton fax = (SoundButton)this.findViewById(R.id.fax_cheer);
        try {
            player.setDataSource(this.getApplicationContext(),fax.getSoundID());
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.start();
            }
        });
    }
}
