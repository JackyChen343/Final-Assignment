/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myculturalstory;
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 343089579
 */
public class Main extends PApplet {
    private Character Archer;
    private Sun sun;
    private Arrow arrow;
    private PImage bg;
    private int stage = 0;
    private int speed = 10;
    private int count = 1;
    private int walk = 0; 
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
                        Archer.move(-5, 0);
                    } else if (keyCode == RIGHT){
                        Archer.move(5, 0);
                    } else if (keyCode == UP){
                        Archer.move(0, -5);
                    } else if (keyCode == DOWN){
                        Archer.move(0, 5);
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

