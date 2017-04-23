package com.codinginsights.libgdxexamples;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.codinginsights.libgdxexamples.Scene2D.ActorExample;

public class GdxExamples extends Game {

  private SpriteBatch batch;

  @Override
  public void create() {
	Gdx.app.setLogLevel(Application.LOG_DEBUG);

	batch = new SpriteBatch();

//	setScreen(new AssetManagerUpdateExample(this));
//	setScreen(new AssetManagerInefficient(this));
//	setScreen(new AssetManagerExample(this));
	setScreen(new ActorExample(this));
  }

  @Override
  public void dispose() {
	batch.dispose();
  }

  public SpriteBatch getBatch() {
	return batch;
  }
}
