package info.trongdat.practice4.renderer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import info.trongdat.practice4.TextureCube;
import info.trongdat.practice4.shape.Triangle;

/**
 * Created by Alone on 11/7/2016.
 */

public class MyGLRenderer implements GLSurfaceView.Renderer {
    TextureCube cube;
    Triangle triangle;
    Context con;
    int dem=0;
    private static float angleCube = 0f;  // rotate
    private static float speedCube = -0.6f; // rotate speed

    public MyGLRenderer(Context context) {
        cube = new TextureCube ();
        con=context;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);

        cube.loadTexture(gl, con);
        gl.glEnable(GL10.GL_TEXTURE_2D);
        triangle=new Triangle();
    }


    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        if (height == 0) height = 1;
        float aspect = (float)width / height;

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

    }


    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);


        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -6.0f);
        gl.glRotatef(angleCube, 0.0f, 1.0f, 0.0f);

        cube.draw(gl);
    }
}
