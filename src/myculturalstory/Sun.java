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
    public int Hp;
    
    public Sun(PApplet p, int x, int y,int Hp ,String img) {
        super(p, x, y, img);
        this.Hp = Hp;
        
    }
}
