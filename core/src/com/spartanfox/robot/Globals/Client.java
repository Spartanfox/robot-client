/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spartanfox.robot.Globals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.math.Vector2;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.spartanfox.robot.Globals.Values.*;
import java.awt.Rectangle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Ben
 */
public class Client {
    private static Socket socket = null;
    private static InputStream in;
    private static OutputStream out;
    private static DataInputStream dIn;
    private static DataOutputStream dOut;
    public static drawablePixmap screen;
    private static Thread writeThread,readThread;
    public static String IP = "192.168.1.111";
    public static int Port = 25566;
    public static int Action = 0;
    public static boolean Running = false;
    public static Pixmap Pix = new Pixmap(1920,1080,Pixmap.Format.RGBA8888);
    public static boolean Ready = false;
    public static boolean Paused = false;
    public static boolean Driving = false;
    public static Vector2 Pointer = new Vector2(0,0);
    public static boolean Screenshot = false;
    public static String createSocket(String IP,int Port){
        String output;
        try{
            output = close();
            Client.IP = IP;
            Client.Port = Port;
            output = start();
        } catch (Exception e) {
            output = e.toString();
        }
        return output;
    }
    public static void createReadThread(){
        readThread = new Thread(){
            @Override
            public void run(){
                int ix = 0;
                int current = 0;
                try{
                //start loopies
                while(Running || socket != null || socket.isConnected()){
                    
                        if(Action == 1){
                            dOut.writeInt(1);
                            int nbrToRead = dIn.readInt();
                            if(nbrToRead <= -1){}
                            else{
                                byte[] byteArray = new byte[nbrToRead];
                                int nbrRd = 0;
                                int nbrLeftToRead = nbrToRead;
                                while(nbrLeftToRead > 0){
                                    int rd = dIn.read(byteArray, nbrRd, nbrLeftToRead);
                                    if(rd < 0) break;
                                    nbrRd += rd; // accumulate bytes read
                                    nbrLeftToRead -= rd;
                                }
                                String Img = ""+byteArray;

                                Pix = new Pixmap(byteArray,0,byteArray.length);
                                if(Screenshot){
                                    try{
                                    System.out.println("Saving image");
                                    DateFormat df = new SimpleDateFormat("dd-MM_HH-mm-ss");
                                    Calendar calobj = Calendar.getInstance();
                                    String file = "/Pictures/RobotCaptures/"+df.format(calobj.getTime())+".png";
                                    System.out.println(file);
                                    FileHandle gallery = Gdx.files.external(file);
                                    PixmapIO.writePNG(gallery,Pix);
                                    Screenshot = false;
                                    }catch(Exception e){
                                        Screenshot = false;
                                        System.out.println(e);
                                    }
                                }
                            }
                        }
                        else if(Action == CAMERA){
                            Screenshot = true;
                            Action = 1;
                        }
                        else{
                            dOut.writeInt(Action);
                            Action = 1;
                            
                    }
                    }
                }catch(Exception e){
                    
                }
            }
        };
        readThread.setPriority(Thread.MAX_PRIORITY);
        readThread.start();
    }
    public static void createWriteThread(){
        writeThread = new Thread(){
            @Override
            public void run(){
                try{
                    while(Running ||socket != null || socket.isConnected()){

                    }
                }catch(Exception e){
                
                }
            }
        };
        writeThread.setPriority(Thread.MAX_PRIORITY);
        writeThread.start();
    }
    public static String start() throws Exception{
        close();
        Running = true;
        socket = new Socket(IP,Port);
        
        socket.setTcpNoDelay(true);
        in = socket.getInputStream();
        out = socket.getOutputStream();
        dOut = new DataOutputStream(socket.getOutputStream());
        dIn = new DataInputStream(socket.getInputStream());
        createReadThread();
        //createWriteThread();
        return "Connected to "+IP+":"+Port;
    }
    
    

    
    
    
    
    
    
    
    
    public static String close(){
        if(socket != null){
            try {
                Running = false;
                if(socket.isConnected())socket.close();
                socket = null;
                in.close();
                out.close();
                dIn.close();
                dOut.close();

                in = null;
                out = null;
                dIn = null;
                dOut = null;
                writeThread = null;
                readThread = null;
                return "\nStopped";
            } catch (IOException ex) {
                return ex.toString();
            }
            }
        return "\nNothing to stop";
    }
}
