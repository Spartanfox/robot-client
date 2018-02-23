/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.spartanfox.robot.Globals.Sounds;
import com.spartanfox.robot.Globals.Styles;
import com.spartanfox.robot.Globals.Textures;
import com.spartanfox.robot.Globals.Values;
import com.spartanfox.robot.Main;

/**
 *
 * @author Ben
 */
public class MainMenu implements Screen{
    Stage stage;
    Main main;
    Table table;
    public MainMenu(Main main){
        this.main = main;
        Textures.load();
        Styles.create();
        Sounds.create();
    }    

    @Override
    public void show() {
        loadUI();
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
       
    }
   public void loadUI(){
        if(stage!=null)stage.dispose();
        stage = new Stage(main.view);
        stage.getCamera().viewportWidth = Values.WIDTH;
        stage.getCamera().viewportHeight = Values.HEIGHT;
      
        table = new Table();
        table.setFillParent(true);
        table.setBackground(Textures.getDrawable("Background"));
        table.row().fill();
        table.add(Styles.newButton("Start robot",
                new ClickListener(){
                    @Override
                    public void clicked(InputEvent event,float x, float y){
                        Sounds.play("blop");
                       main.setScreen(main.share);
                    }
                }
                )).pad(20).fill();
        table.row().fill();
        table.add(Styles.newButton("Settings",
                new ClickListener(){
                    @Override
                    public void clicked(InputEvent event,float x, float y){
                        Sounds.play("blop");
                        main.setScreen(main.settings);
                    }
                }
                )).pad(20).fill();
        table.row().fill();
        table.add(Styles.newButton("Quit",
                new ClickListener(){
                    @Override
                    public void clicked(InputEvent event,float x, float y){
                        //Gdx.app.exit();
                        Sounds.play("fart");
                        System.exit(0);
                    }
                }
                )).pad(20).fill();
        //table.setDebug(true);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
   }
    @Override
    public void resize(int width, int height) {
        loadUI();
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        stage.dispose();
        stage = null;
        
    }

    @Override
    public void dispose() {
        //stage.dispose();
        //stage = null;
    }
    
}

