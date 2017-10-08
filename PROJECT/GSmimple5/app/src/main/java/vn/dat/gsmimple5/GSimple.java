package vn.dat.gsmimple5;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class GSimple extends BaseGameActivity {

    private static final int CAMERA_WIDTH=480;
    private static final int CAMERA_HEIGHT=854;


    @Override
    public Engine onLoadEngine() {
        Camera  camera=new Camera(0,0,CAMERA_WIDTH,CAMERA_HEIGHT);
        EngineOptions engineOptions=new EngineOptions(true, EngineOptions.ScreenOrientation.PORTRAIT,new RatioResolutionPolicy(CAMERA_WIDTH,CAMERA_HEIGHT),camera);

        return new Engine(engineOptions);
    }

    @Override
    public void onLoadResources() {

    }

    @Override
    public Scene onLoadScene() {
        mEngine.registerUpdateHandler(new FPSLogger());
        Scene scene=new Scene();
        scene.setBackground(new ColorBackground(0.5f,0.5f,0.5f));
        return scene;
    }

    @Override
    public void onLoadComplete() {

    }
}
