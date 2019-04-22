package com.toanvq.fpoly.demgio;

import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {
    private ImageView icanchor;
    private Button btnstart;
    Animation roundingalone, stop;
    private Button btnstop;
    Chronometer timeHere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        icanchor = (ImageView) findViewById(R.id.icanchor);
        btnstart = (Button) findViewById(R.id.btnstart);
        btnstop = (Button) findViewById(R.id.btnstop);
        timeHere = (Chronometer) findViewById(R.id.timeHere);

        //create optional animation
        btnstop.setAlpha(0);
        //load animations
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);
        stop = AnimationUtils.loadAnimation(this,R.anim.stop);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"MMedium.ttf");

        //customize font
        btnstop.setTypeface(MMedium);
        btnstart.setTypeface(MMedium);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                //start time
                timeHere.setBase(SystemClock.elapsedRealtime());
                timeHere.start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation(stop);
                btnstart.animate().alpha(1).setDuration(300).start();
                btnstop.animate().alpha(0).translationY(-80).setDuration(300).start();
                //start time
              //  timeHere.setBase(SystemClock.elapsedRealtime());
                timeHere.stop();
            }
        });
    }
}
