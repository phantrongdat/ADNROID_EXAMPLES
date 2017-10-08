package info.trongdat.openglexample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Alone on 9/30/2016.
 */

public class Rectangle {
    private FloatBuffer vertexBuffer;
    private FloatBuffer colorBuffer;
    private ByteBuffer indexBuffer;
    private float vertices[] = {
            1.0f, -1.0f, -1.0f,
            1.0f, -1.0f, -1.0f,
//            1.0f, 1.0f, -1.0f,
//            -1.0f, 1.0f, -1.0f,
            -1.0f, -1.0f, 1.0f,
            1.0f, -1.0f, 1.0f,
//            1.0f, 1.0f, 1.0f,
//            -1.0f, 1.0f, 1.0f
    };
    private float colors[] = {
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            1.0f, 0.5f, 0.0f, 1.0f,
            1.0f, 0.5f, 0.0f, 1.0f,
            1.0f, 0.0f, 0.0f, 1.0f,
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f,
            1.0f, 0.0f, 1.0f, 1.0f
    };

    private byte indices[] = {
//            0, 4, 5, 0, 5, 1,
//            1, 5, 6, 1, 6, 2,
//            2, 6, 7, 2, 7, 3,
//            3, 7, 4, 3, 4, 0,
//            4, 7, 6, 4, 6, 5,
//            3, 0, 1, 3, 1, 2
            0, 2, 3,0,3,1,
//            3,2,1,3,1,0
    };


    public Rectangle() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        byteBuffer = ByteBuffer.allocateDirect(colors.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        colorBuffer = byteBuffer.asFloatBuffer();
        colorBuffer.put(colors);
        colorBuffer.position(0);

        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);

    }

    public void draw(GL10 gl10) {
        gl10.glFrontFace(GL10.GL_CW);
        gl10.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl10.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
        gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl10.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl10.glDrawElements(GL10.GL_TRIANGLES, 6, GL10.GL_UNSIGNED_BYTE,
                indexBuffer);
        gl10.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl10.glDisableClientState(GL10.GL_COLOR_ARRAY);

    }
}
