package info.trongdat.practice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Alone on 11/7/2016.
 */

public class TextureCube {
    private FloatBuffer vertexBuffer;
    private FloatBuffer texBuffer;
    Bitmap bitmap;
    public int ind = 0;

    private float[] vertices = {
            -1.0f, -1.0f, 0.0f,  // left-bottom-front
            1.0f, -1.0f, 0.0f,  //  right-bottom-front
            -1.0f, 1.0f, 0.0f,  //  left-top-front
            1.0f, 1.0f, 0.0f   //  right-top-front
    };

    float[] texCoords = {
            0.0f, 1.0f,  // left-bottom
            1.0f, 1.0f,  // right-bottom
            0.0f, 0.0f,  // left-top
            1.0f, 0.0f   // right-top
    };
    int[] textureIDs = new int[10];

    public TextureCube() {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        ByteBuffer tbb = ByteBuffer.allocateDirect(texCoords.length * 4);
        tbb.order(ByteOrder.nativeOrder());
        texBuffer = tbb.asFloatBuffer();
        texBuffer.put(texCoords);
        texBuffer.position(0);
    }


    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texBuffer);

        // front
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, 1.0f);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[ind % textureIDs.length]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glPopMatrix();


        // left
        gl.glPushMatrix();
        gl.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(0.0f, 0.0f, 1.0f);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[(ind + 1) % textureIDs.length]);

        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glPopMatrix();

        // back
        gl.glPushMatrix();
        gl.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(0.0f, 0.0f, 1.0f);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[(ind + 2) % textureIDs.length]);

        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glPopMatrix();

        // right
        gl.glPushMatrix();
        gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(0.0f, 0.0f, 1.0f);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[(ind + 3) % textureIDs.length]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glPopMatrix();

        // top
        gl.glPushMatrix();
        gl.glRotatef(270.0f, 1.0f, 0.0f, 0.0f);
        gl.glTranslatef(0.0f, 0.0f, 1.0f);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[(ind + 1) % textureIDs.length]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glPopMatrix();

        // bottom
        gl.glPushMatrix();
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        gl.glTranslatef(0.0f, 0.0f, 1.0f);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[(ind + 2) % textureIDs.length]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }

    // Load image
    public void loadTexture(GL10 gl, Context context) {
        final Bitmap[] bitmap = new Bitmap[10];
        int[] index = {R.drawable.android, R.drawable.android2, R.drawable.android3, R.drawable.android2, R.drawable.android4, R.drawable.android5, R.drawable.android3, R.drawable.android5, R.drawable.android4, R.drawable.android2};
        gl.glGenTextures(4, textureIDs, 0);
        for (int i = 0; i < index.length; i++) {
            gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[i]);
            // Set up texture filters
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);


            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;

            bitmap[i] = BitmapFactory.decodeResource(context.getResources(), index[i], options);

            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap[i], 0);
            bitmap[i].recycle();
        }

    }
}

