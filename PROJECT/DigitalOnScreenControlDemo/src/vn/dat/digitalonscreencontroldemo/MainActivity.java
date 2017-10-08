package vn.dat.digitalonscreencontroldemo;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.BoundCamera;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl.IOnScreenControlListener;
import org.anddev.andengine.engine.camera.hud.controls.DigitalOnScreenControl;
import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXLayer;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXTiledMap;
import org.anddev.andengine.entity.modifier.ParallelEntityModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.util.Log;

public class MainActivity extends BaseGameActivity {
	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 1280;

	private BoundCamera camera;
	private Texture mTextureAE;
	private TextureRegion mTextureRegionAE;

	private Texture mTextureGunner;
	private TiledTextureRegion mTextureRegionGunner;

	private Texture mOnScreenControlTexture;
	private TextureRegion mOnScreenControlBaseTextureRegion;
	private TextureRegion mOnScreenControlKnobTextureRegion;

	int statusGunner = 0;

	private TMXTiledMap tmxMap1;
	private TMXLayer layerVatCan;

	@Override
	public Engine onLoadEngine() {
		// TODO Auto-generated method stub
		camera = new BoundCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);

		return new Engine(engineOptions);
	}

	@Override
	public void onLoadResources() {
		// TODO Auto-generated method stub

		mTextureAE = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mTextureRegionAE = TextureRegionFactory.createFromAsset(mTextureAE, this, "gfx/ae.jpg", 0, 0);
		mTextureGunner = new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mTextureRegionGunner = TextureRegionFactory.createTiledFromAsset(mTextureGunner, this, "gfx/hoangtu.png", 0, 0,
				3, 4);
		mOnScreenControlTexture = new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mOnScreenControlBaseTextureRegion = TextureRegionFactory.createFromAsset(mOnScreenControlTexture, this,
				"gfx/onscreen_control_base.png", 0, 0);
		mOnScreenControlKnobTextureRegion = TextureRegionFactory.createFromAsset(mOnScreenControlTexture, this,
				"gfx/onscreen_control_knob.png", 128, 0);

		this.mEngine.getTextureManager().loadTextures(mTextureAE, mTextureGunner, mOnScreenControlTexture);
	}

	@Override
	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		this.mEngine.registerUpdateHandler(new FPSLogger());
		Scene scene = new Scene();
		scene.setBackground(new ColorBackground(0.25f, 0.5f, 0.6f));

		final Sprite mSpriteAE = new Sprite(0, 0, mTextureRegionAE);
		// mSpriteAE.setScale(2f);
		mSpriteAE.setPosition(CAMERA_WIDTH / 2 - mSpriteAE.getWidth() / 2, 0);

		mSpriteAE.registerEntityModifier(new SequenceEntityModifier(
				new ParallelEntityModifier(new RotationModifier(0.25f, 0, 360), new ScaleModifier(0.25f, 0.2f, 1.2f)),
				new ScaleModifier(0.25f, 1.2f, 1f)));

		final AnimatedSprite mSpriteGunner = new AnimatedSprite(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2 + 100,
				mTextureRegionGunner);
		// mSpriteGunner.animate(new long[] { 200, 200, 200, 200, 200, 200, 200,
		// 200, 200, 200, 200,200}, 0, 11, true);
		mSpriteGunner.setScale(2.5f);
		final PhysicsHandler handler = new PhysicsHandler(mSpriteGunner);
		mSpriteGunner.registerUpdateHandler(handler);

		DigitalOnScreenControl digitalOnScreenControl = new DigitalOnScreenControl(30,
				CAMERA_HEIGHT - this.mOnScreenControlBaseTextureRegion.getHeight() - 30, this.camera,
				this.mOnScreenControlBaseTextureRegion, this.mOnScreenControlKnobTextureRegion, 0.1f,
				new IOnScreenControlListener() {

					@Override
					public void onControlChange(BaseOnScreenControl pBaseOnScreenControl, float pValueX,
							float pValueY) {
						// TODO Auto-generated method stub
						if (pValueX != 0 || pValueY != 0) {
//							if(mSpriteGunner.collidesWith(mSpriteAE))
//							{
////								Toast.makeText(MainActivity.this, "Da vao GameEngine!", Toast.LENGTH_SHORT).show();
//								Log.d("Move", "Da vao GameEngine!");
//							}
							if (pValueX > 0) {
								if (statusGunner == 0) {
									mSpriteGunner.animate(new long[] { 200, 200, 200 }, 6, 8, true);
									statusGunner = 1;
								}
							} else if (pValueX < 0) {
								if (statusGunner == 0) {
									mSpriteGunner.animate(new long[] { 200, 200, 200 }, 3, 5, true);
									statusGunner = 2;
								}
							} else if (pValueY > 0) {
								if (statusGunner == 0) {
									mSpriteGunner.animate(new long[] { 200, 200, 200 }, 0, 2, true);
									statusGunner = 3;
								}
							} else if (pValueY < 0) {
								if (statusGunner == 0) {
									mSpriteGunner.animate(new long[] { 200, 200, 200 }, 9, 11, true);
									statusGunner = 4;
								}
							}
							handler.setVelocity(pValueX * 200, pValueY * 200);
							Log.v("X=" + pValueX, "Y=" + pValueY);
						}
						else{
//							mSpriteGunner.animate(new long[]{200}, new int[]{0}, 10000);
//							if(mSpriteGunner.collidesWith(mSpriteAE))
//							{
////								Toast.makeText(MainActivity.this, "Ban dang trong GameEngine!", Toast.LENGTH_LONG).show();
//								Log.d("Move", "Dang trong GameEngine!");
//							}
							if(statusGunner==1)
							{
								mSpriteGunner.animate(new long[] { 200}, new int[] {6}, 1000);
							}
							if(statusGunner==2)
							{
								mSpriteGunner.animate(new long[] { 200}, new int[] {3}, 1000);
							}
							if(statusGunner==3)
							{
								mSpriteGunner.animate(new long[] { 200}, new int[] {0}, 1000);
							}
							if(statusGunner==4)
							{
								mSpriteGunner.animate(new long[] { 200}, new int[] {9}, 1000);
							}
							
	            			statusGunner = 0;
	            			handler.setVelocity(pValueX * 0, pValueY * 0);
	            			}
					
					}
				});

		digitalOnScreenControl.getControlBase().setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		digitalOnScreenControl.getControlBase().setScaleCenter(0, 128);
		digitalOnScreenControl.getControlBase().setScale(2);
		digitalOnScreenControl.getControlKnob().setScale(2);
		digitalOnScreenControl.getControlBase().setAlpha(0.5f);
		digitalOnScreenControl.getControlKnob().setAlpha(0.5f);
		digitalOnScreenControl.refreshControlKnobPosition();
		
		//Khởi tạo map
		tmxMap1=TaiBanDo.getTMXTiledMap(scene, mEngine, this, "map1.tmx", this);
		ArrayList<TMXLayer> mapLayers=tmxMap1.getTMXLayers();
		Log.d("Layer Count",""+ mapLayers.size());
		for(TMXLayer layer:mapLayers)
		{
			if(layer.getName().equalsIgnoreCase("hinder"))
			{
				layerVatCan=layer;
				scene.attachChild(layer);
			}
		}
		final TMXLayer tmxLayer = this.tmxMap1.getTMXLayers().get(0);
        camera.setBounds(0, tmxLayer.getWidth(), 0, tmxLayer.getHeight());
        camera.setBoundsEnabled(true);
        camera.setChaseEntity(mSpriteGunner);

		scene.setChildScene(digitalOnScreenControl);
//		scene.attachChild(mSpriteAE);
		scene.attachChild(mSpriteGunner);
		return scene;

	}

	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub

	}
}
