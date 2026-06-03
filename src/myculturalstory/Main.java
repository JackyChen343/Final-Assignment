/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myculturalstory;
import processing.core.PApplet;
/**
 *
 * @author 343089579
 */
public class Main extends PApplet {
    private Character Archer;
    private int stage = 0;
    public void settings(){
	   //sets the size of the window
        size (900,900);
    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(255,255,255);
        textSize(20);
        Archer = new Character(this, 50, 50, "images/BowGuy.png");
    }
    
    public void draw(){
        background(255); //set the colour
        if (stage == 0){
            fill(0);
            text("My Cultural Story", 20, 50);
            text("Press Enter Key to Start", 20, 100);
        } else if (stage == 1){
            Archer.draw();
        }
    }
    
    public void keyPressed(){
        if (stage == 0){
            if (keyCode == ENTER){
                stage = 1;
            }
        }
    }
    
}

