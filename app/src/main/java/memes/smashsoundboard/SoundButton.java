package memes.smashsoundboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.Button;

public class SoundButton extends Button {

    private Uri soundID;
    private String soundPath;

    public SoundButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs,R.styleable.SoundButton);
        soundID = Uri.parse(attributes.getString(R.styleable.SoundButton_soundID));
        soundPath = attributes.getString(R.styleable.SoundButton_soundID);
        attributes.recycle();
    }

    public String getSoundPath()
    {
        return soundPath;
    }

    public Uri getSoundID() { return soundID; }
}
