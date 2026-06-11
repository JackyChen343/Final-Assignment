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
public class Sun extends Character{
    public int speed;
    
    public Sun(PApplet p, int x, int y,int hp,int speed ,String img) {
        super(p, x, y,hp, img);
        this.speed = speed;
        
    }
    
    public int getSpeed(){
        return speed;
    }
    
    
    
    
}
