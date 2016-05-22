package memes.smashsoundboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent soundIntentFox = new Intent(this, SoundActivityFox.class);
        final Intent soundIntentFalco = new Intent(this, SoundActivityFalco.class);
        final Intent soundIntentSheik = new Intent(this, SoundActivitySheik.class);
        final Intent soundIntentMarth = new Intent(this, SoundActivityMarth.class);
        Button foxButton = (Button)this.findViewById(R.id.fox_section);
        Button falcoButton = (Button)this.findViewById(R.id.falco_section);
        Button sheikButton = (Button)this.findViewById(R.id.sheik_section);
        Button marthButton = (Button)this.findViewById(R.id.marth_section);
        foxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(soundIntentFox);
            }
        });
        falcoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(soundIntentFalco);
            }
        });
        sheikButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(soundIntentSheik);
            }
        });
        marthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(soundIntentMarth);
            }
        });
    }
}
