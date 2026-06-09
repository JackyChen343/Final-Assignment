/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myculturalstory;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
/**
 *
 * @author 343089579
 */
public class Main extends PApplet {
    private Character Archer;
    private Sun sun;
    private Arrow arrow;
    private PImage dialog1;
    private PImage bg;
    private int stage = 0;
    private int speed = 10;
    private int count = 1;
    private int walk = 0;
    private int Num = 0;
    String[] PersonName = new String[100];
    String[] Text = new String[100];
    
    public void settings(){
	   //sets the size of the window
        size (900,900);
    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(255,255,255);
        textSize(20);
        bg =  loadImage("images/flatlands.jpg");
        sun = new Sun(this, 450, 20, 1, "images/sun.png");
        Archer = new Character(this, 50, 750, "images/BowGuy.png");
        arrow = new Arrow(this, 9999, 9999, 10, "images/Arrow.png");
        dialog1 = loadImage("images/dialog.png");
        try{
            Scanner x = new Scanner( new File("dialog.txt"));
            while(x.hasNext()){
                String output = x.nextLine();
                String[] info = output.split(",");
            
                PersonName[Num] = info[0].trim();
                Text[Num] = info[1].trim();
                Num++;
            }
        x.close();
        }catch( IOException ioException ){
            System.err.println("Java Exception: "+ ioException);
        }
    }
    
    public void draw(){
        background(255); //set the colour
        if (stage == 0){
            fill(0);
            text("My Cultural Story", 20, 50);
            text("Press Enter Key to Start", 20, 100);
        } else if (stage == 1){
            image(bg, 0, 0, width, height);
            sun.draw();
            Archer.draw();
            
            
   
        }
        arrow.draw();
        arrow.arrowMovement();
        if (walk==1){
                if(keyPressed){
                    if (keyCode == LEFT){
                        Archer.move(-10, 0);
                    } else if (keyCode == RIGHT){
                        Archer.move(10, 0);
                    } else if (keyCode == UP){
                        Archer.move(0, -10);
                    } else if (keyCode == DOWN){
                        Archer.move(0, 10);
                    } else if (key == ' '){
                        if(count == 1){
                            arrow.x = Archer.x+5;
                            arrow.y = Archer.y;
                            count = 0;
                        }
                    }
                }
            }
        if(arrow.x>900){
            count = 1;
        }
        if(Archer.isCollidingWith(sun)){
            image(dialog1, 0, 500);
            text(PersonName[0], 100, 645);
            text(Text[0], 125, 680);
        }
        
        if (arrow.isCollidingWith(sun)){
            sun.x = -9999;
            sun.y = -9999;
            arrow.x = 9999;
            arrow.y = 9999;
        }
    }
    
    public void keyPressed(){
        if (stage == 0){
            if (keyCode == ENTER){
                walk = 1;
                stage = 1;
            }
        }
    }
    
}

