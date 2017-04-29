package com.codinginsights.libgdxexamples.Scene2D;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codinginsights.libgdxexamples.assetManager.AssetDescriptors;

/**
 * Created by elefher on 4/22/17.
 */

public class ActorExample implements Screen {

  private final Game game;
  private Stage stage;
  private Viewport viewport;
  private final AssetManager manager;

  public ActorExample(Game game) {
	this.game = game;
	manager = new AssetManager();
  }

  @Override
  public void show() {
	viewport = new FitViewport(1080, 720);
	stage = new Stage(viewport);

	Gdx.input.setInputProcessor(stage);

	loadAssets();

	MyActor myActor1 = new MyActor(manager.get(AssetDescriptors.skeleton) , AssetDescriptors.skeleton.fileName);
	myActor1.spritePos(200, 200);
	MyActor myActor2 = new MyActor(manager.get(AssetDescriptors.character) , AssetDescriptors.character.fileName);
	myActor2.spritePos(700, 600);
	MyActor myActor3 = new MyActor(manager.get(AssetDescriptors.nullImg) , AssetDescriptors.nullImg.fileName);
	myActor3.spritePos(390, 480);

	stage.addActor(myActor1);
	stage.addActor(myActor2);
	stage.addActor(myActor3);
  }

  @Override
  public void render(float delta) {
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	stage.act(delta);
	stage.draw();
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
	dispose();
  }

  @Override
  public void dispose() {
	stage.dispose();
  }

  private void loadAssets() {
	manager.load(AssetDescriptors.brokenRocket);
	manager.load(AssetDescriptors.character);
	manager.load(AssetDescriptors.characterRun);
	manager.load(AssetDescriptors.nullImg);
	manager.load(AssetDescriptors.rocket);
	manager.load(AssetDescriptors.skeleton);

	manager.finishLoading();
  }
}
