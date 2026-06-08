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
public class Character {
    public int x, y;
    public int height, width;
    private PApplet app;
    private PImage image;
    
    public Character(PApplet p, int x, int y, String img){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(img);
        this.width = image.width;
        this.height = image.height;
    }
    
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    public boolean isCollidingWith(Character other) {
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
