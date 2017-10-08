package vn.dat.gameengine;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.controls.AnalogOnScreenControl;
import org.anddev.andengine.engine.camera.hud.controls.AnalogOnScreenControl.IAnalogOnScreenControlListener;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.modifier.AlphaModifier;
import org.anddev.andengine.entity.modifier.ParallelEntityModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.Log;

public class MainActivity extends BaseGameActivity {

	public static final int CAMERA_WIDTH = 480;
	public static final int CAMERA_HEIGHT = 853;
	Camera camera;

	final int statusGunner = 0;
	Texture textureHello;
	Font fontHello;

	Texture textureAE;
	TextureRegion textureRegionAE;

	Texture ttGunner;
	TiledTextureRegion ttrGunner;

	Texture ttOnScreen;
	TextureRegion ttrOnScreenBase;
	TextureRegion ttrOnScreenKnob;

	@Override
	public Engine onLoadEngine() {
		// TODO Auto-generated method stub
		camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
		return new Engine(engineOptions);
	}

	@Override
	public void onLoadResources() {
		// TODO Auto-generated method stub
		textureHello = new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		// this.mEngine.getTextureManager().loadTexture(textureHello);
		fontHello = FontFactory.createFromAsset(textureHello, this, "font/SHOWG.TTF", 32, true, Color.YELLOW);
		this.mEngine.getFontManager().loadFont(fontHello);

		textureAE = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		// this.mEngine.getTextureManager().loadTexture(textureAE);
		textureRegionAE = TextureRegionFactory.createFromAsset(textureAE, this, "gfx/ae.jpg", 0, 0);

		ttGunner = new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		// this.mEngine.getTextureManager().loadTexture(ttGunner);
		TextureRegionFactory.setAssetBasePath("gfx/");
		ttrGunner = TextureRegionFactory.createTiledFromAsset(ttGunner, this, "hoangtu.png", 0, 0, 3, 4);

		ttOnScreen = new Texture(256, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		ttrOnScreenBase = TextureRegionFactory.createFromAsset(this.ttOnScreen, this, "onscreen_control_base.png", 0,
				0);
		ttrOnScreenKnob = TextureRegionFactory.createFromAsset(this.ttOnScreen, this, "onscreen_control_knob.png", 128,
				0);

		this.mEngine.getTextureManager().loadTextures(textureHello, textureAE, ttGunner, ttOnScreen);
	}

	@Override
	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		this.mEngine.registerUpdateHandler(new FPSLogger());
		Scene scene = new Scene();
		scene.setBackground(new ColorBackground(0.2f, 0.5f, 0.6f));
		// Text textHello = new Text(120, 500, fontHello, "Hello World !");
		final Text textHello = new Text(110, 500, fontHello, "Hello AndEngine !");
		scene.attachChild(textHello);
		// textHello.registerEntityModifier(
		// new SequenceEntityModifier(
		// new ParallelEntityModifier(new AlphaModifier(3, 0.5f, 1),
		// new ScaleModifier(3, 0.5f, 1f), new RotationModifier(3, 0, 360)),
		// new RotationModifier(3, 360, 0)));

		final Sprite spriteAE = new Sprite(0, 0, textureRegionAE);
		scene.attachChild(spriteAE);

		spriteAE.registerEntityModifier(new SequenceEntityModifier(
				new ParallelEntityModifier(new AlphaModifier(3, 0.6f, 1f), new ScaleModifier(3, 0.5f, 1.3f)),
				new ParallelEntityModifier(new ScaleModifier(2, 1.3f, 1f), new RotationModifier(2, 0, 360))));

		CountDownTimer countDownTimer = new CountDownTimer(8000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				textHello.setPosition(textHello.getX(), textHello.getY() + 5);
				Log.d("hello", "Đang di chuyển");
			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub

			}
		};
		countDownTimer.start();

		final AnimatedSprite animatedSpriteGunner = new AnimatedSprite(230, 630, ttrGunner);
		animatedSpriteGunner.animate(new long[] { 200, 200, 200 }, 6, 8, true);
		scene.attachChild(animatedSpriteGunner);

		animatedSpriteGunner.setScale(2f);

		final PhysicsHandler handler = new PhysicsHandler(animatedSpriteGunner);
		animatedSpriteGunner.registerUpdateHandler(handler);

		AnalogOnScreenControl analogOnScreenControl = new AnalogOnScreenControl(20,
				CAMERA_HEIGHT - this.ttrOnScreenBase.getHeight() - 20, this.camera, this.ttrOnScreenBase,
				this.ttrOnScreenKnob, 0.1f, 200, new IAnalogOnScreenControlListener() {
					@Override
					public void onControlChange(final BaseOnScreenControl pBaseOnScreenControl, final float pValueX,
							final float pValueY) {
						if (pValueX != 0 || pValueY != 0) {
							if (pValueX < 0) {
								animatedSpriteGunner.animate(new long[] { 120, 120, 120 }, 3, 5, true);
							} else if (pValueX > 0) {
								animatedSpriteGunner.animate(new long[] { 120, 120, 120 }, 6, 8, true);
							} else if (pValueY > 0) {
								animatedSpriteGunner.animate(new long[] { 120, 120, 120 }, 0, 2, true);
							} else if (pValueY < 0) {
								animatedSpriteGunner.animate(new long[] { 120, 120, 120 }, 10, 12, true);
							}
						}
						Log.v("pValueX= " + pValueX, "pValueY= " + pValueY);
						handler.setVelocity(pValueX * 120, pValueY * 120);
					}

					@Override
					public void onControlClick(final AnalogOnScreenControl pAnalogOnScreenControl) {
						animatedSpriteGunner.registerEntityModifier(new SequenceEntityModifier(
								new ScaleModifier(1, 2, 3.5f), new ScaleModifier(1, 3.5f, 2)));
					}
				});

		analogOnScreenControl.getControlBase().setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		analogOnScreenControl.getControlBase().setScaleCenter(0, 128);
		analogOnScreenControl.refreshControlKnobPosition();

		scene.setChildScene(analogOnScreenControl);

		// DigitalOnScreenControl control = new DigitalOnScreenControl(20,
		// CAMERA_HEIGHT - this.ttrOnScreenBase.getHeight() - 20, this.camera,
		// this.ttrOnScreenBase,
		// this.ttrOnScreenKnob, 0.1f, new IOnScreenControlListener() {
		//
		// @Override
		// public void onControlChange(BaseOnScreenControl pBaseOnScreenControl,
		// float pValueX,
		// float pValueY) {
		// // TODO Auto-generated method stub
		// if (pValueX != 0 || pValueY != 0) {
		// if (pValueX < 0) {
		// animatedSpriteGunner.animate(new long[] { 200, 200, 200 }, 3, 5,
		// true);
		// }
		// if (pValueX > 0) {
		// animatedSpriteGunner.animate(new long[] { 200, 200, 200 }, 6, 8,
		// true);
		// }
		// if (pValueY < 0) {
		// animatedSpriteGunner.animate(new long[] { 200, 200, 200 }, 0, 2,
		// true);
		// }
		// if (pValueY > 0) {
		// animatedSpriteGunner.animate(new long[] { 200, 200, 200 }, 10, 12,
		// true);
		// }
		// }
		// handler.setVelocity(pValueX * 100, pValueY * 100);
		// }
		// });
		// control.getControlBase().setScaleCenter(0, 128);
		// control.getControlBase().setBlendFunction(GL10.GL_SRC_ALPHA,GL10.GL_ONE_MINUS_SRC_ALPHA);
		// control.refreshControlKnobPosition();
		// control.getControlBase().setAlpha(0.5f);
		// scene.attachChild(control);

		return scene;
	}

	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub

	}

}
