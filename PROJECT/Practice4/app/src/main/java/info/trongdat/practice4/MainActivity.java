package info.trongdat.practice4;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import info.trongdat.practice4.renderer.MyGLRenderer;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glView;
    MyGLRenderer myGLRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView = new GLSurfaceView(getApplicationContext());
        myGLRenderer = new MyGLRenderer(this);
        glView.setRenderer(myGLRenderer);
        this.setContentView(glView);

    }

    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
    }
}
