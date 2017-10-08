package com.dat17.canvasexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class DrawGeometry extends AppCompatActivity {
    ToggleButton btnCircle, btnRectangle, btnTriangle;
    View circle, rectangle, triangle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_geometry);
        btnCircle=(ToggleButton) findViewById(R.id.btnCircle);
        circle=(View)findViewById(R.id.viewCircle);
        circle.setVisibility(View.INVISIBLE);
        btnCircle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) circle.setVisibility(View.VISIBLE);
                else circle.setVisibility(View.INVISIBLE);
            }
        });

        btnRectangle=(ToggleButton) findViewById(R.id.btnRectangle);
        rectangle=(View)findViewById(R.id.viewRectangle);
        rectangle.setVisibility(View.INVISIBLE);
        btnRectangle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) rectangle.setVisibility(View.VISIBLE);
                else rectangle.setVisibility(View.INVISIBLE);
            }
        });

        btnTriangle=(ToggleButton) findViewById(R.id.btnTriangle);
        triangle=(View)findViewById(R.id.viewTriangle);
        triangle.setVisibility(View.INVISIBLE);
        btnTriangle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) triangle.setVisibility(View.VISIBLE);
                else triangle.setVisibility(View.INVISIBLE);
            }
        });
    }
}
