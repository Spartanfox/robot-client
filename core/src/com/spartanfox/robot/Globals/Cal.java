/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Globals;

/**
 *
 * @author Ben
 */
public abstract class Cal {
    public static float range(float x, float y){
        return  Math.abs(x-y);
    }
}
