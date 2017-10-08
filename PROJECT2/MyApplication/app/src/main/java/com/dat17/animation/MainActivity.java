package com.dat17.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    int [] imgs;
    int [] anims;
    Animation animation;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgs=new int[]{R.drawable.java,R.drawable.djava,R.drawable.panda};
        anims=new int[]{R.anim.blink,R.anim.rotate,R.anim.fadein,R.anim.fadeout,R.anim.move,R.anim.zoomin,R.anim.slideup};

        imageView=(ImageView)findViewById(R.id.imageView);
        slideShow();
    }

    public  void slideShow()
    {
        if (position==imgs.length) position=0;
        animation=AnimationUtils.loadAnimation(this,anims[position%anims.length]);
        imageView.setImageResource(imgs[position%imgs.length]);
        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                slideShow();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        position++;
    }
}
