package info.trongdat.openglexample;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Alone on 9/30/2016.
 */

public class MainSurface extends GLSurfaceView {
    private SurfaceRender surfaceRender;

    public MainSurface(Context context) {
        super(context);
        setEGLContextClientVersion(2);

        surfaceRender=new SurfaceRender();
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
