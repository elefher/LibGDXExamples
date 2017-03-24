package com.codinginsights.libgdxexamples;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.codinginsights.libgdxexamples.assetManager.AssetManagerAnnotationExample;
import com.codinginsights.libgdxexamples.assetManager.AssetManagerExample;
import com.codinginsights.libgdxexamples.assetManager.AssetManagerInefficient;
import com.codinginsights.libgdxexamples.assetManager.AssetManagerUpdateExample;

public class GdxExamples extends Game {

  private SpriteBatch batch;

  @Override
  public void create() {
	Gdx.app.setLogLevel(Application.LOG_DEBUG);

	batch = new SpriteBatch();

	setScreen(new AssetManagerUpdateExample(this));
  }

  @Override
  public void dispose() {
	batch.dispose();
  }

  public SpriteBatch getBatch() {
	return batch;
  }
}
