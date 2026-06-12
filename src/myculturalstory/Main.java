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
    private Character NPC1;
    private Character Button;
    private Sun sun;
    private Arrow arrow;
    private Arrow arrowUp;
    private PImage next;
    private PImage dialog1;
    private PImage death;
    private PImage bg;
    private PImage bg2;
    private PImage bg3;
    private int stage = 0;
    private int Action = 0;
    private int count = 1;
    private int arrowType = 0;
    private int walk = 0;
    private int Num = 0;
    private int DN = 0;
    String [] PersonName = new String[1000];
    String [] Text = new String[1000];
    
    public void settings(){
	   //sets the size of the window
        size (900,900);
    }
    
    public void setup(){
	//sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(255,255,255);
        textSize(20);
        death = loadImage("images/death.jpg");
        bg =  loadImage("images/flatlands.jpg");
        bg2 = loadImage("images/bg2.jpg");
        bg3 = loadImage("images/VillageFire.jpg");
        sun = new Sun(this, 450, 20, 5, -25, "images/sun.png");
        Archer = new Character(this, 50, 750, 5, "images/BowGuy.png");
        NPC1 = new Character(this, 750, 450, "images/homeless.png");
        arrow = new Arrow(this, 9999, 9999, 10, "images/Arrow.png");
        arrowUp = new Arrow(this, 9999, 9999, 10, "images/UpArrow.png");
        dialog1 = loadImage("images/dialog.png");
        Button = new Character(this, 745, 825, "images/f1.png");
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
            NPC1.draw();
            Archer.draw(); 
            if(Archer.isCollidingWith(NPC1)){
                image(dialog1, 0, 500);
                Button.draw();
                text(PersonName[DN], 100, 645);
                text(Text[DN], 125, 680);
                if(DN == 5){
                    Action = 1;
                }
            }
        } else if (stage == 2){
            image(bg2, 0, 0, width, height);
            NPC1.draw();
            NPC1.y = 9999;
            Archer.draw();
            sun.draw();
            sun.move(sun.getSpeed(), 0);
            if(sun.x < 0){
                sun.x = 900;
                sun.y = Archer.y-10;
            }
            if(sun.Hp == 0){
                NPC1.x = 750;
                NPC1.y = 450;
            }
            if(Archer.isCollidingWith(NPC1)){
                image(dialog1, 0, 500);
                Button.draw();
                text(PersonName[DN], 100, 645);
                text(Text[DN], 125, 680);
                if (DN == 9){
                    Action = 3;
                }
            }
        } else if(stage == 3){
            image(bg3, 0, 0, width, height);
            Archer.draw();
        } else if (stage == -9999){
            image(death, 0, 0, width, height);
        }
        arrow.draw();
        arrowUp.draw();
        arrowUp.arrowMovement(-10);
        arrow.arrowMovement();
        if (walk==1){
                if(keyPressed){
                    if (keyCode == LEFT){
                        Archer.move(-20, 0);
                    } else if (keyCode == RIGHT){
                        Archer.move(20, 0);
                    } else if (keyCode == UP){
                        Archer.move(0, -20);
                    } else if (keyCode == DOWN){
                        Archer.move(0, 20);
                    } else if (key == ' '){
                        if(count == 1){
                            if(arrowType == 0){
                                arrow.x = Archer.x+5;
                                arrow.y = Archer.y;
                                count = 0;
                            }else if (arrowType == 1){
                                arrowUp.x = Archer.x;
                                arrowUp.y = Archer.y;
                                count = 0;
                            }
                        }
                    } else if (key == 'q'){
                        if(arrowType == 0){
                            arrowType = 1; 
                        } else if(arrowType == 1){
                            arrowType = 0;
                }
            }
                }
            }
        if(arrow.y==-9999 || arrow.x > 900){
            count = 1;
        }
        if (Archer.x >= 900 && Action == 1){
            stage = 2;
            DN = 6;
            Archer.x = 50;
            Action = 2;
        }
        if (Archer.y <= 0 && Action == 3){
            stage = 3;
            DN = 9;
            Archer.y = 850;
            Action = 4;
        }
        if (arrow.isCollidingWith(sun)){
            sun.Hp -= 1;
            arrow.x = -9999;
            arrow.y = -9999;
        }
        if(arrowUp.isCollidingWith(sun)){
            sun.Hp -= 1;
            arrowUp.x = -9999;
            arrowUp.y = -9999;
        }
        if (sun.isCollidingWith(Archer)){
            Archer.Hp -=1;
            sun.x = 900;
            sun.y = 450;
        }
        
        if (sun.Hp == 0){
            sun.x = 9999;
            sun.y = 9999;
            Action = 3;
        }
        if(Archer.Hp == 0){
            stage = -9999;
        }
        if(stage > 0){
            if(arrowType == 0){
                fill(0, 0, 255);
                rect(0, 0, 25, 25);
            } else if(arrowType == 1){
                fill(255, 0, 0);
                rect(0, 0, 25, 25);
            }
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
    public void mousePressed(){
        if(Button.isClicked(mouseX, mouseY)){
            if(stage == 1 && DN < 5){
                DN += 1;
            }else if(stage == 2 && DN < 8){
                DN +=1;
            } else{
                DN += 0;
            }
            
        }
    }
}

