/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Globals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ben
 */
public abstract class Sounds {
    private static Music music;
    private static HashMap<String,Sound> sounds;
    public static float soundsVol,musicVol,masterVol;
    public static void create(){
        music = Gdx.audio.newMusic(Gdx.files.internal("data/Sounds/Music.wav"));
        sounds = new HashMap();
        sounds.put("blop",Gdx.audio.newSound(Gdx.files.internal("data/Sounds/blop.mp3")));
        sounds.put("fart",Gdx.audio.newSound(Gdx.files.internal("data/Sounds/lose.wav")));
        music.setLooping(true);
        soundsVol = 1f;
        musicVol = 1f;
        masterVol = 1f;
        music.setVolume(musicVol);

    }
    public static void play(){
        music.play();
    }
    public static void play(String sound){
        sounds.get(sound).play(soundsVol);
    }
    public static void setVolume(float vol){
        music.setVolume(vol);
        musicVol = vol;
    }
    public static void setSoundVolume(float vol){
        soundsVol = vol;
    }
    public static void pause(){
        music.pause();
    }
}
