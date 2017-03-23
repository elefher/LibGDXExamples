package com.codinginsights.libgdxexamples.assetManager;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Created by elefher on 3/24/17.
 */

public class AssetsAnnotation {

  @AnnotationAssetManager.Asset(Texture.class)
  public static final String SKELETON = "images/skeleton.png", ROCKET = "images/rocket.png", NULLIMG = "images/null.png",
		  CHARACTERRUN = "images/characterrun.png", CHARACTER = "images/character.png", BROKENROCKET = "images/brokenrocket.png";

  private AssetsAnnotation(){}

}
