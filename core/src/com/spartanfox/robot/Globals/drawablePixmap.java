/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Globals;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

/**
 *
 * @author Ben
 */
public class drawablePixmap implements Disposable{
    Texture img;
    Pixmap draw;
    
    @Override
    public void dispose() {
        img.dispose();
        draw.dispose();
    }
    
}
