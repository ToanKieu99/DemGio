package com.toanvq.fpoly.demgio;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvSplash;
    private TextView tvSublash;
    private Button btnget;
    private ImageView imgSplash;
    Animation atg, btgone,btgtwo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = (TextView) findViewById(R.id.tvSplash);
        tvSublash = (TextView) findViewById(R.id.tvSublash);
        btnget = (Button) findViewById(R.id.btnget);
        imgSplash = (ImageView) findViewById(R.id.imgSplash);

        // load animations
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);

        //passing animation
        imgSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSublash.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StopWatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });


        Typeface MLight = Typeface.createFromAsset(getAssets(),"MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"MRegular.ttf");

        tvSplash.setTypeface(MRegular);
        tvSublash.setTypeface(MLight);
        btnget.setTypeface(MMedium);

    }
}
