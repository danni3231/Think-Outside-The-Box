package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Brick {

    protected  int  posX, posY, xOffset, yOffset, size;
    protected String axis;
    protected boolean over, locked;
    protected  PApplet app;
    protected PImage img;

    public Brick (int posX, int posY, int size, String axis, PApplet app){
        this.posX=posX;
        this.posY=posY;
        this.size=size;
        this.axis=axis;
        this.xOffset = 0;
        this.yOffset= 0;
        this.over=false;
        this.locked=false;
        this.app=app;
    }

    public Brick(int posX, int posY, String axis, PApplet app) {
        this.posX=posX;
        this.posY=posY;
        this.axis=axis;
        this.xOffset = 0;
        this.yOffset= 0;
        this.locked=false;
        this.over=false;
        this.app=app;
    }

    public void draw(){
        over= app.mouseX > posX && app.mouseX < posX + img.width && app.mouseY > posY && app.mouseY < posY + img.height;
        app.image(img,posX,posY);
        if(over || locked){
            app.noFill();
            app.stroke(0);
            app.strokeWeight(2);
            app.rect(posX,posY,img.width,img.height);
        }
    }

    public void move(){
        switch (axis){
            case "Y":
                if(posY>=60 && posY+img.height<=660 ){
                    posY=app.mouseY-yOffset;
                }

                break;

            case "X":
                if(posX>=313 && posX+img.width<=913){
                    posX=app.mouseX-xOffset;
                }
                break;

        }
    }

    public void setOffset(){
        xOffset = app.mouseX-posX;
        yOffset = app.mouseY-posY;

        locked=true;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;

        if(posX<313){
            posX=313;
        } else if(posX+img.width>913){
            int gap = posX+img.width-913;
            posX-=gap;
        }

        if(posY<60){
            posY=60;
        }else if(posY+img.height>660){
            int gap = posY+img.height-660;
            posY-=gap;
        }

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public PImage getImg() {
        return img;
    }

    public void setImg(PImage img) {
        this.img = img;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public boolean isLocked() {
        return locked;
    }

}
