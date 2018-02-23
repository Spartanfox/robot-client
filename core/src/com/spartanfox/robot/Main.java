package com.spartanfox.robot;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.*;
import com.spartanfox.robot.Globals.*;
import com.spartanfox.robot.Screens.*;

public class Main extends Game{
	SpriteBatch batch;
	Texture img;
        public MainMenu main;
        public Settings settings;
        public ShareScreen share;
	public Camera defaultCam;
        public Viewport view = new FitViewport(Values.WIDTH,Values.HEIGHT);
	@Override
	public void create () {
            defaultCam = new OrthographicCamera(Values.WIDTH,Values.HEIGHT);
            defaultCam.update();
            
            batch = new SpriteBatch();
            main = new MainMenu(this);
            settings = new Settings(this);
            share = new ShareScreen(this);
            
            Textures.load();
            Styles.create();
            Sounds.create();

            this.setScreen(main);
	}

	@Override
	public void render () {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		    
            super.render();
            /*batch.begin();
            batch.draw(img, 0, 0);
            batch.end();*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
