package vn.dat.basegame;

import android.graphics.Typeface;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.texture.Texture;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.render.RenderTexture;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;

import java.util.Random;

public class MainActivity extends SimpleBaseGameActivity {

    private static final int CAMERA_WIDTH = 480;
    private static final int CAMERA_HEIGHT = 853;
    private static final long RANDOM_SEED = 1234567890;
    private static final int LINE_COUNT = 100;

    private Texture texture;
    private Font font;

    @Override
    protected void onCreateResources() {
        this.texture = new RenderTexture(new TextureManager(),256,256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.font=new Font(new FontManager(),texture, Typeface.create(Typeface.DEFAULT,Typeface.NORMAL),32,true, Color.RED);
    }

    @Override
    protected Scene onCreateScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());
        final Scene scene = new Scene();
        scene.setBackground(new Background(0.23f, 1, 0));
        final Random random = new Random(RANDOM_SEED);

        final VertexBufferObjectManager vertexBufferObjectManager = this.getVertexBufferObjectManager();
        for(int i = 0; i < LINE_COUNT; i++) {
            final float x1 = random.nextFloat() * CAMERA_WIDTH;
            final float x2 = random.nextFloat() * CAMERA_WIDTH;
            final float y1 = random.nextFloat() * CAMERA_HEIGHT;
            final float y2 = random.nextFloat() * CAMERA_HEIGHT;
            final float lineWidth = random.nextFloat() * 5;

            final Line line = new Line(x1, y1, x2, y2, lineWidth, vertexBufferObjectManager);

            line.setColor(random.nextFloat(), random.nextFloat(), random.nextFloat());

            scene.attachChild(line);
        }


        Text text=new Text(160,800,font,"PHAN TRONG DAT",vertexBufferObjectManager);
        scene.attachChild(text);
        return scene;
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);


        return engineOptions;
    }
}
