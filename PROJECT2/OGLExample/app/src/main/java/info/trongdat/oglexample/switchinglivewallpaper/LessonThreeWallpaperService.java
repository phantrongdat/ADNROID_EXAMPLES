package info.trongdat.oglexample.switchinglivewallpaper;

import android.opengl.GLSurfaceView.Renderer;

import info.trongdat.oglexample.lesson3.LessonThreeRenderer;

public class LessonThreeWallpaperService extends OpenGLES2WallpaperService {
	@Override
	Renderer getNewRenderer() {
		return new LessonThreeRenderer();
	}
}
