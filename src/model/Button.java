package model;

import processing.core.PApplet;
import processing.core.PFont;

public class Button {

    private int posX,posY,width,height;
    private boolean focus;
    private String text;
    private PFont font;
    private PApplet app;

    public Button(int posX, int posY, int width, int height, String text, PApplet app) {
        this.posX=posX;
        this.posY=posY;
        this.width=width;
        this.height=height;
        this.text=text;
        this.app=app;
        this.font = app.createFont("./data/font/Poppins-Regular.ttf",24);
        this.focus = false;
    }

    public void draw(){
        app.noStroke();

        focus= app.mouseX > posX && app.mouseX < posX + width && app.mouseY > posY && app.mouseY < posY + height;

        if(focus){
            app.fill(230);
        }else{
            app.fill(255);
        }

        app.rect(posX,posY,width,height);
        app.fill(87,24,69);
        app.textFont(font);
        app.textAlign(app.CENTER, app.CENTER);
        app.text(text,posX+(width/2),posY+(height/2)-5);
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }
}
