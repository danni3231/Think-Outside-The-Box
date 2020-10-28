package model;

import processing.core.PApplet;

public class PurpleBrick extends Brick{
    public PurpleBrick(int posX, int posY, int size, String axis, PApplet app) {
        super(posX, posY,size, axis, app);
        this.img = app.loadImage("data/bricks/PurpleBrick-"+axis+"-"+size+".png");
    }
}
