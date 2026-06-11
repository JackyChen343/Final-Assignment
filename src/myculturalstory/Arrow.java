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
public class Arrow {
    public int x, y;
    private int speed;
    private int height, width;
    private PApplet app;
    private PImage image;
    
    public Arrow(PApplet p, int x, int y, int speed, String img){
        this.app = p;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = app.loadImage(img);
        this.width = image.width;
        this.height = image.height;
    }
    
    public void arrowMovement(){
        x += speed;
    }
    
    public void arrowMovement(int dy){
        y += dy;
    }
    
    public boolean isCollidingWith(Sun other) {
        // Check if the bounding boxes of the two persons intersect
        boolean isLeftOfOtherRight = x < other.x + other.width;
        boolean isRightOfOtherLeft = x + width > other.x;
        boolean isAboveOtherBottom = y < other.y + other.height;
        boolean isBelowOtherTop = y + height > other.y;

        return isLeftOfOtherRight && isRightOfOtherLeft 
        && isAboveOtherBottom && isBelowOtherTop;
  }
    
    public void draw(){
        app.image(image, x, y);
  }


}
