/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spartanfox.robot.Globals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public abstract class Textures {
    private static ArrayList<texture> textures = new ArrayList();
    
    public static void load(){     
        textures.add(new texture("Background","Background.png"));
        textures.add(new texture("UP","UP.png"));
        textures.add(new texture("DOWN","DOWN.png"));
        textures.add(new texture("LEFT","LEFT.png"));
        textures.add(new texture("RIGHT","RIGHT.png"));
        textures.add(new texture("DISPLAY","DisplayButton.png"));
        textures.add(new texture("CAMERA","Camera.png"));
        textures.add(new texture("EXIT","Exit.png"));
        textures.add(new texture("SILENT","Silent.png"));
        textures.add(new texture("LIGHT","Light.png"));
        textures.add(new texture("SILENTCLICKED","ClickedSilent.png"));
    }
    
    public static Texture get(String name){
        for(texture t : textures){
            if(t.getName().toLowerCase().equals(name.toLowerCase())){
                return t.getTexture();
            }
        }
        return null;
    }
    public static TextureRegionDrawable getDrawable(String name){
        for(texture t : textures){
            if(t.getName().toLowerCase().equals(name.toLowerCase())){
                return new TextureRegionDrawable(new TextureRegion(t.getTexture()));
            }
        }
        System.out.println("Failed to load: "+name);
        return null;
    }
    public static boolean unload(String name){
         for(texture t : textures){
            if(t.getName().toLowerCase().equals(name.toLowerCase())){
                t.texture.dispose();
                t.texture = null;
                return true;
            }
        }
        return false;
    }
    private static class texture{
        private Texture texture;
        private String name;
        private String location;
        boolean loaded;
        texture(String name, String location){
            this.location = location;
            this.name = name;
        }
        public Texture getTexture(){
            if(texture == null){
                        //texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.MipMapLinearLinear);
                        this.texture = new Texture(
                    Gdx.files.internal
                    ("data/"+location)
            );
            if(texture != null){
                System.out.println("loaded "+location);
            }else{System.out.println("failed "+location);
            }
            }
            return texture;
        }
        public String getName(){
            return name;
        }
    }
}
                              