package model;

import processing.core.PApplet;

public class OrangeBrick extends Brick{
    public OrangeBrick(int posX, int posY, int size, String axis, PApplet app) {
        super(posX, posY,size, axis, app);
        this.img = app.loadImage("data/bricks/OrangeBrick-"+axis+"-"+size+".png");
    }
}
