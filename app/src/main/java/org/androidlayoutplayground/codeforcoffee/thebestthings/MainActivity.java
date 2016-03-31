package org.androidlayoutplayground.codeforcoffee.thebestthings;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView img = (ImageView) findViewById(R.id.imageView);
    private TypedArray images = getResources().obtainTypedArray(R.array.imgs);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.playMagdarTheme();
    }

    private void loopThroughImages() {

    }

    private void playMagdarTheme() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.drawable.madgar);
        mediaPlayer.start();
    }
}
