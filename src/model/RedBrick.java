package model;

import processing.core.PApplet;

public class RedBrick extends Brick{
    public RedBrick(int posX, int posY, int size, String axis, PApplet app) {
        super(posX, posY,size, axis, app);
        this.img = app.loadImage("data/bricks/RedBrick-"+axis+"-"+size+".png");
    }
}
