package info.trongdat.practice4.shape;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Alone on 11/7/2016.
 */

public class Square {
    private FloatBuffer vertexBuffer;
    private ByteBuffer indexBuffer;
    private FloatBuffer colorBuffer;
    private float[] vertices = {
            -1f,  1.0f, 0.0f, // 0. top left
            -1.0f, -1.0f, 0.0f, // 1. left-bottom
            1.0f, -1.0f, 0.0f,  // 2. right-bottom
            1f,1f,0f //3. top right
    };
    private float[] colors = {  // Colors of the 5 vertices in RGBA
            0.0f, 0.0f, 1.0f, 1.0f,  // 0. blue
            0.5f, 1.0f, 0.5f, 1.0f,  // 1. green
            0.0f, 0.0f, 1.0f, 1.0f,  // 2. blue
            0.5f, 1.0f, 0.0f, 1.0f,  // 3. green
            1.0f, 0.0f, 0.0f, 1.0f   // 4. red
    };
    private byte[] indices = { 0, 1, 2, 1, 2, 3 };


    public Square() {

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        colorBuffer = cbb.asFloatBuffer();
        colorBuffer.put(colors);
        colorBuffer.position(0);


        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }


    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
