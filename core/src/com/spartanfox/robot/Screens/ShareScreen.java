/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.spartanfox.robot.Globals.*;
import com.spartanfox.robot.*;
import static com.spartanfox.robot.Globals.Values.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class ShareScreen implements Screen,GestureListener{
    SpriteBatch batch;
    Texture Capture;
    Main main;
    Stage stage;
    Table table;
    int WIDTH = Values.WIDTH/3;
    int HEIGHT = Values.HEIGHT/3;
    public boolean Screenshot = false;

    public ShareScreen(Main main){
        this.main = main;
        
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        //batch.setProjectionMatrix(main.defaultCam.projection);
	batch = new SpriteBatch();
        loadUI();
                
        try {
            Client.start();
        } catch (Exception ex) {
            //Logger.getLogger(ShareScreen.class.getName()).log(Level.SEVERE, null, ex);
            //System.exit(0);
        }
        Gdx.input.setInputProcessor(new GestureDetector(this));
    }

    @Override
    public void render(float delta) {
        if(Client.Pix != null&& !Client.Screenshot ){
            if(Capture!=null)Capture.dispose();
            Capture = new Texture(Client.Pix);
            Client.Pix.dispose();
            Client.Pix = null;
        }
        main.defaultCam.update();
        batch.setProjectionMatrix(main.defaultCam.projection);
       
        batch.begin();
        batch.draw(Capture,-(Values.WIDTH/2),-(Values.HEIGHT/2),Values.WIDTH,Values.HEIGHT);    
        batch.end();
        stage.act();
       stage.draw();
        
        /*
        if(Gdx.input.isTouched()){
            Client.PenDown(Gdx.input.getX(),Gdx.input.getY());
        }else{
            Client.PenUp(Gdx.input.getX(),Gdx.input.getY());
        }*/
        
        
    }
    public void loadUI(){
        stage = new Stage(main.view);
        stage.getCamera().viewportWidth = Values.WIDTH;
        stage.getCamera().viewportHeight = Values.HEIGHT;
        table = new Table(Styles.getSkin());
        table.setFillParent(true);
        //table.setBackground(Textures.getDrawable("Background"));
        int gridX = 14;
        int gridY = 7;
        for (int y = 0; y < gridY; y++) {
            for (int x = 0; x < gridX; x++) {
                if(x==9&&y==0){
                    table.add(Styles.newImageButton("LIGHT",
                        new ClickListener(){
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = LIGHT;
                                
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else                 if(x==10&&y==0){
                    table.add(Styles.newDownButton("SILENT",
                        new ClickListener(){
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = SILENT;
                                
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else if(x==13&&y==0){
                    table.add(Styles.newImageButton("EXIT",
                        new ClickListener(){
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = EXIT;
                                main.setScreen(main.main);
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else if(x==11&&y==0){
                    table.add(Styles.newImageButton("CAMERA",
                        new ClickListener(){
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = CAMERA;
                                
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else if(x==12&&y==0){
                    table.add(Styles.newImageButton("DISPLAY",
                            new ClickListener(){
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = DISPLAY;
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else if(x==0&&y==4){
                    table.add(Styles.newImageButton("UP",
                        new ClickListener(){
                            @Override
                            public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = 0;                                
                            }             
                            
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = FORWARDS;
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else if(x==0&&y==5){
                    table.add(Styles.newImageButton("DOWN",
                        new ClickListener(){
                            @Override
                            public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = 0;                                
                            }             
                            
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = BACKWARDS;
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else if(x==13&&y==4){
                    table.add(Styles.newImageButton("LEFT",
                        new ClickListener(){
                            @Override
                            public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = 0;
                            }             
                            
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = LEFT;
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else if(x==13&&y==5){
                    table.add(Styles.newImageButton("RIGHT",
                        new ClickListener(){
                            @Override
                            public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = 0;
                            }             
                            
                            @Override
                            public boolean touchDown(InputEvent event,float x, float y, int pointer, int button){
                                Sounds.play("blop");
                                Client.Action = RIGHT;
                                return true;
                            }
                        }
                )).maxSize(100,100).minSize(100,100);
                }
                else{
                    table.add(" ").expand();
                }
            }
            table.row();//.fill();
        }
        //table.setDebug(true);
        table.setFillParent(true);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }
    public static double Distance(Vector2 obj, Vector2 obj2){
            
        double range;
        double absx,absy;
        absx = Math.abs(obj2.x-obj.x);
        absy = Math.abs(obj2.y-obj.y);
        
        absx  = absx*absx;
        absy  = absy*absy;
        range = Math.sqrt(absx+absy);
        return range;
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
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        System.out.println("X="+x+" y="+y);
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
return false;    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
return false;    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
return false;    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
return false;    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
return false;    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
return false;    }

    @Override
    public void pinchStop() {
    }
    
}
