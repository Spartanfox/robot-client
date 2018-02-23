/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.spartanfox.robot.Globals.*;
import com.spartanfox.robot.Main;

/**
 *
 * @author Ben
 */

public class Settings  implements Screen{
    Stage stage;
    Main main;
    Table table;
    TextArea IP;
    TextArea Port;
    TextArea Console;
    public Settings(Main main){
        this.main = main;
    }    

    @Override
    public void show() {
        IP      = Styles.newTextBox("192.168.1.112");
        Port    = Styles.newTextBox("25565");
        Console = Styles.newTextBox("");
        loadUI();
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
       
    }
   public void loadUI(){
        stage = new Stage(main.view);
        stage.getCamera().viewportWidth = Values.WIDTH;
        stage.getCamera().viewportHeight = Values.HEIGHT;
        table = new Table();
        table.setFillParent(true);
        table.setBackground(Textures.getDrawable("Background"));
        table.row();
        
        table.add(new Label("IP Number",Styles.getSkin(),"big")).center();
        table.row();
        table.add(IP).height(Values.HEIGHT/15).width(Values.WIDTH/5);
        table.row();
        table.add(new Label("Port Number",Styles.getSkin(),"big")).center();
        table.row();
        table.add(Port).height(Values.HEIGHT/15).width(Values.WIDTH/5);
         table.row();
                table.add(Styles.newSmallButton("Connect",
                new ClickListener(){
                    @Override
                    public void clicked(InputEvent event,float x, float y){
                        Sounds.play("blop");
                        
                        Console.appendText("Connecting..\n");
                        Console.appendText(Client.createSocket(IP.getText(),Integer.parseInt(Port.getText()))+"\n");
                        Console.appendText(Client.close()+"\n");
                    }
                }
                )).pad(5).center();
                        table.row();

        table.add(Console).height(Values.HEIGHT/5).width(Values.WIDTH/2.5f);
        

        table.row();
        table.add(Styles.newButton("Back",
                new ClickListener(){
                    @Override
                    public void clicked(InputEvent event,float x, float y){
                        Sounds.play("fart");
                        main.setScreen(main.main);
                    }
                }
                )).pad(20).center();
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