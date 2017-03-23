package com.codinginsights.libgdxexamples.assetManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codinginsights.libgdxexamples.configs.Config;

/**
 * Created by elefher on 3/22/17.
 */

public class AssetManagerInefficient implements Screen {

  private final Game game;

  private OrthographicCamera camera;
  private Viewport viewport;

  private SpriteBatch batch;
  private Texture brokenRocket;
  private Texture skeleton;
  private Texture rocket;
  private Texture nullImg;
  private Texture characterRun;
  private Texture character;

  public AssetManagerInefficient(Game game){
	this.game = game;
  }

  @Override
  public void show() {
	camera = new OrthographicCamera();
	viewport = new FitViewport(Config.WORLD_WIDTH, Config.WORLD_HEIGHT, camera);
	batch = new SpriteBatch();

	brokenRocket = new Texture(Gdx.files.internal(Assets.BROKENROCKET));
	skeleton = new Texture(Gdx.files.internal(Assets.SKELETON));
	rocket = new Texture(Gdx.files.internal(Assets.ROCKET));
	nullImg = new Texture(Gdx.files.internal(Assets.NULLIMG));
	characterRun = new Texture(Gdx.files.internal(Assets.CHARACTERRUN));
	character = new Texture(Gdx.files.internal(Assets.CHARACTER));
  }

  @Override
  public void render(float delta) {
	Gdx.gl.glClearColor(0, 0, 0, 0);
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
	brokenRocket.dispose();
	skeleton.dispose();
	rocket.dispose();
	nullImg.dispose();
	characterRun.dispose();
	character.dispose();
  }
}
