package com.trongdat.subject2review;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SubAnimation extends AppCompatActivity {
    ImageView imageView;
    Button btnClick, btnFadeIn, btnFadeOut, btnBlink, btnRotate, btnZoomIn, btnZoomOut, btnMove, btnSlideUp, btnSlideDown, btnSequential, btnTogether;
    Animation click, fadeIn, fadeOut, blink, rotate, zoomIn, zoomOut, slideUp, slideDown, move, sequential, together;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_animation);
        define();
        buttonHandler();
    }

    public void define() {
        imageView = (ImageView) findViewById(R.id.imageView);
        btnFadeIn = (Button) findViewById(R.id.btnFadeIn);
        btnFadeOut = (Button) findViewById(R.id.btnFadeOut);
        btnBlink = (Button) findViewById(R.id.btnBlink);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnZoomIn = (Button) findViewById(R.id.btnZoomIn);
        btnZoomOut = (Button) findViewById(R.id.btnZoomOut);
        btnSlideUp = (Button) findViewById(R.id.btnSlideUp);
        btnSlideDown = (Button) findViewById(R.id.btnSlideDown);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnSequential = (Button) findViewById(R.id.btnSequential);
        btnTogether = (Button) findViewById(R.id.btnTogether);

        btnClick = (Button) findViewById(R.id.btnClick);
        click = AnimationUtils.loadAnimation(this, R.anim.button_click);


        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        blink = AnimationUtils.loadAnimation(this, R.anim.blink);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        move = AnimationUtils.loadAnimation(this, R.anim.move);
        slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        sequential = AnimationUtils.loadAnimation(this, R.anim.sequential);
        together = AnimationUtils.loadAnimation(this, R.anim.together);
    }

    public void buttonHandler() {
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick.startAnimation(click);

            }
        });

        btnFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(fadeIn);

            }
        });

        btnFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(fadeOut);
            }
        });
        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(blink);
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(rotate);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(move);
            }
        });

        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(zoomIn);
            }
        });

        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(zoomOut);
            }
        });

        btnSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(slideUp);
            }
        });

        btnSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(slideDown);
            }
        });

        btnSequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(sequential);
            }
        });

        btnTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(together);
            }
        });
    }
}
 