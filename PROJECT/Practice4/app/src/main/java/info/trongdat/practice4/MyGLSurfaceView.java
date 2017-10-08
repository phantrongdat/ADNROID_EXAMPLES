package info.trongdat.practice4;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Alone on 11/7/2016.
 */

public class MyGLSurfaceView extends GLSurfaceView {

    public MyGLSurfaceView(Context context) {
        super(context);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
