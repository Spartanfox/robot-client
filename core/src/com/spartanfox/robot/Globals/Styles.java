/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Globals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ben
 */
public abstract class Styles {
    private static Skin skin;
    private static HashMap<String,BitmapFont> fonts;
    public static void create(){
        skin = new Skin(
            Gdx.files.internal("data/skins/glassy-ui.json")
        );    
    }
    private static void setFont(String name,BitmapFont font){
        fonts.put(name, font);
    }
    public static BitmapFont getFont(String name){

        return new BitmapFont();
    }
    public static Skin getSkin(){
        if(skin !=null){
            return skin;
        }
        return new Skin();
    }
    public static ImageButton newImageButton(String image,EventListener listener){
        ImageButtonStyle style = new ImageButtonStyle();
        style.up = Textures.getDrawable(image);
        style.down = Textures.getDrawable(image);
        ImageButton newButton = new ImageButton(style);
        newButton.addListener(listener);
        
        return newButton;
    }
    public static ImageButton newDownButton(String image,EventListener listener){
        ImageButtonStyle style = new ImageButtonStyle();
        style.up = Textures.getDrawable(image);
        style.down = Textures.getDrawable(image+"CLICKED");
        ImageButton newButton = new ImageButton(style);
        newButton.addListener(listener);
        
        return newButton;
    }
    public static TextButton newButton(String name,EventListener listener){
        TextButton newButton = new TextButton(name, skin);
        //newButton.setScale(2);
        newButton.addListener(listener);
        
        return newButton;
    }
    public static TextButton newSmallButton(String name,EventListener listener){
        TextButton newButton = new TextButton(name, skin,"small");
        //newButton.setScale(2);
        newButton.addListener(listener);
        
        return newButton;
    }
    public static TextButton newButton(String name){
        TextButton newButton = new TextButton(name, skin);        
        return newButton;
    }

    public static CheckBox newCheck(String name,EventListener listener){
        CheckBox newCheck = new CheckBox(name, skin);
        newCheck.addListener(listener);
        newCheck.scaleBy(10);
        newCheck.setHeight(500);
        return newCheck;
    }
    public static Slider newSlider(){
        Slider newSlider = new Slider(0f,100f,1f,false,skin);
        return newSlider;
    }
    public static Slider newSlider(EventListener listener){
        Slider newSlider = new Slider(0f,1f,0.01f,false,skin);
        newSlider.setValue(1f);
        newSlider.addListener(listener);
        return newSlider;
    }
    public static TextArea newTextBox(String input){
        TextArea newText = new TextArea(input,skin);
        return newText;
    }
       public static Label newLabel(String title){
        LabelStyle style = new LabelStyle();
        style.background = Textures.getDrawable("Label");
        style.font = skin.getFont("font-big");
        
        //style.fontColor = new Color();
        Label newLabel = new Label(title,style);
        
        return newLabel;
    }
    
}
