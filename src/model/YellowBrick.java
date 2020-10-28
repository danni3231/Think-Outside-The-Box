package model;

import processing.core.PApplet;

public class YellowBrick extends Brick{

    public YellowBrick(int posX, int posY, String axis, PApplet app) {
        super(posX, posY, axis, app);
        this.img = app.loadImage("data/bricks/YellowBrick.png");
    }

}
