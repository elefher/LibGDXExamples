package com.codinginsights.libgdxexamples.assetManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codinginsights.libgdxexamples.configs.Config;

/**
 * Created by elefher on 3/23/17.
 */

public class AssetManagerUpdateExample implements Screen {

  private final Game game;
  private final AssetManager manager;

  private OrthographicCamera camera;
  private Viewport viewport;

  private SpriteBatch batch;
  private Texture brokenRocket;
  private Texture skeleton;
  private Texture rocket;
  private Texture nullImg;
  private Texture characterRun;
  private Texture character;

  public AssetManagerUpdateExample(Game game) {
	this.game = game;
	manager = new AssetManager();
  }

  @Override
  public void show() {
	camera = new OrthographicCamera();
	viewport = new FitViewport(Config.WORLD_WIDTH, Config.WORLD_HEIGHT, camera);
	batch = new SpriteBatch();

	loadAssets();

	while(!manager.update()) {
	  float progress = manager.getProgress();
	  System.out.println("Loading ... " + progress * 100 + "%");
	}

	brokenRocket = manager.get(AssetDescriptors.brokenRocket);
	rocket = manager.get(AssetDescriptors.rocket);
	skeleton = manager.get(AssetDescriptors.skeleton);
	nullImg = manager.get(AssetDescriptors.nullImg);
	character = manager.get(AssetDescriptors.character);
	characterRun = manager.get(AssetDescriptors.characterRun);
  }

  @Override
  public void render(float delta) {
	Gdx.gl.glClearColor(1, 1, 1, 0);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	viewport.apply();
	batch.setProjectionMatrix(camera.combined);

	drawAssets();
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

  private void drawAssets() {
	batch.begin();
	batch.draw(brokenRocket, 9, 15, 2, 2);
	batch.draw(rocket, 9, 8, 2, 2);
	batch.draw(skeleton, 10, 5, 2, 2);
	batch.draw(nullImg, 3, 8, 2, 2);
	batch.draw(character, 6, 7, 2, 2);
	batch.draw(characterRun, 8, 4, 2, 2);
	batch.end();
  }

  private void loadAssets() {
	manager.load(AssetDescriptors.brokenRocket);
	manager.load(AssetDescriptors.character);
	manager.load(AssetDescriptors.characterRun);
	manager.load(AssetDescriptors.nullImg);
	manager.load(AssetDescriptors.rocket);
	manager.load(AssetDescriptors.skeleton);
  }

}
