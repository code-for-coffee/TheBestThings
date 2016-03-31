package org.androidlayoutplayground.codeforcoffee.thebestthings;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.os.Handler;
import android.widget.RelativeLayout;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Integer inc = 5;
    private Handler handler;
    private ImageView img;
    private RelativeLayout rl;
    //TypedArray images;
    MediaPlayer mediaPlayer;
    ArrayList<Integer> images = new ArrayList<Integer>();


    protected void onCreate(Bundle savedInstanceState) {

        //images = getResources().obtainTypedArray(R.array.random_imgs);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.main_relativelayout);

        images.add(R.id.imgViewTrogdor);
        images.add(R.id.imgViewPeench);
        images.add(R.id.imgViewMagda);
        images.add(R.id.imgViewPoutine);
        images.add(R.id.imgViewTuna);
        images.add(R.id.imgViewUs);

        handler = new Handler();
        mediaPlayer = MediaPlayer.create(this, R.raw.madgar);
        mediaPlayer.start();

        Runnable task = new Runnable() {
            public void run() {
                Log.i("loop image", inc.toString());
                img = (ImageView) findViewById(images.get(inc));
                rl.removeView(img);
                inc--;
                if (inc < 0) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
                handler.postDelayed(this, 2700);
            }
        };
        handler.postDelayed(task, 2700);

    }

}
