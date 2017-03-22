package com.codinginsights.libgdxexamples;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.codinginsights.libgdxexamples.assetManager.AssetManagerExample;

public class GdxExamples extends Game {

  private SpriteBatch batch;

  @Override
  public void create() {
	Gdx.app.setLogLevel(Application.LOG_DEBUG);

	batch = new SpriteBatch();

	setScreen(new AssetManagerExample(this));
  }

  @Override
  public void dispose() {
	batch.dispose();
  }

  public SpriteBatch getBatch() {
	return batch;
  }
}
