package com.codinginsights.libgdxexamples.assetManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codinginsights.libgdxexamples.configs.Config;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Created by elefher on 3/23/17.
 */

public class AssetManagerAnnotationExample implements Screen {

  private final Game game;
  private final AnnotationAssetManager manager;

  private OrthographicCamera camera;
  private Viewport viewport;

  private SpriteBatch batch;
  private Texture brokenRocket;
  private Texture skeleton;
  private Texture rocket;
  private Texture nullImg;
  private Texture characterRun;
  private Texture character;

  public AssetManagerAnnotationExample(Game game){
	this.game = game;
    manager = new AnnotationAssetManager();
  }

  @Override
  public void show() {
    camera = new OrthographicCamera();
    viewport = new FitViewport(Config.WORLD_WIDTH, Config.WORLD_HEIGHT, camera);
    batch = new SpriteBatch();

    loadAssets();

    brokenRocket = manager.get(AssetsAnnotation.BROKENROCKET);
    rocket = manager.get(AssetsAnnotation.ROCKET);
    skeleton = manager.get(AssetsAnnotation.SKELETON);
    nullImg = manager.get(AssetsAnnotation.NULLIMG);
    character = manager.get(AssetsAnnotation.CHARACTER);
    characterRun = manager.get(AssetsAnnotation.CHARACTERRUN);
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(1, 1, 1, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    camera.update();

    viewport.apply();
    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    batch.draw(brokenRocket, 9, 15, 2, 2);
    batch.draw(rocket, 9, 8, 2, 2);
    batch.draw(skeleton, 10, 5, 2, 2);
    batch.draw(nullImg, 3, 8, 2, 2);
    batch.draw(character, 6, 7, 2, 2);
    batch.draw(characterRun, 8, 4, 2, 2);

    batch.end();
  }

  @Override
  public void resize(int width, int height) {
    viewport.update(width, height, true);
  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void hide() {

  }

  @Override
  public void dispose() {
    batch.dispose();
    manager.dispose();
  }

  private void loadAssets(){
    manager.load(AssetsAnnotation.class);
    manager.finishLoading();
  }

}
