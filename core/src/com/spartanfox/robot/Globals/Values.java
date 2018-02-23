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
public abstract class Values {
    public static final int WIDTH = 1920/2;
    public static final int HEIGHT = 1080/2;
    public static final int STOP=0,IMAGE=1,BACKWARDS=2,FORWARDS=3,LEFT=4,RIGHT=5,DISPLAY=6,CAMERA=7,EXIT=8,SILENT=9,LIGHT=10;
    
    //ENUM VERSION  
    public static enum Action {STOP,IMAGE,BACKWARDS,FORWARDS,LEFT,RIGHT,DISPLAY,CAMERA,EXIT,SLIENT,LIGHT};
}
