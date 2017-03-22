package com.codinginsights.libgdxexamples.assetManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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

public class AssetManagerExample implements Screen {

  private static final Logger log = new Logger(AssetManagerExample.class.getName(), Logger.DEBUG);
  private final Game game;

  private OrthographicCamera camera;
  private Viewport viewport;

  SpriteBatch batch;
  Texture background;
  Texture red;
  Texture green;

  public AssetManagerExample(Game game){
	this.game = game;
	log.debug("Constructor");
  }

  @Override
  public void show() {
	log.debug("show");
	camera = new OrthographicCamera();
	viewport = new FitViewport(Config.WORLD_WIDTH, Config.WORLD_HEIGHT, camera);
	batch = new SpriteBatch();
	background = new Texture(Gdx.files.internal("images/background-blue.png"));
	red = new Texture(Gdx.files.internal("images/circle-red.png"));
	green = new Texture(Gdx.files.internal("images/circle-green.png"));
  }

  @Override
  public void render(float delta) {
	Gdx.gl.glClearColor(0, 0, 0, 0);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	viewport.apply();
	batch.setProjectionMatrix(camera.combined);
	batch.begin();

	batch.draw(background, 0, 0);
	batch.draw(red, 9, 6, 1, 1);
	batch.draw(green, 10, 3, 1, 1);

	batch.end();

	log.debug("render");
  }

  @Override
  public void resize(int width, int height) {
	viewport.update(width, height, true);
	log.debug("resize");
  }

  @Override
  public void pause() {
	log.debug("pause");
  }

  @Override
  public void resume() {
	log.debug("resume");
  }

  @Override
  public void hide() {
	log.debug("hide");
  }

  @Override
  public void dispose() {
	log.debug("dispose");
  }
}
