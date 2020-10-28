package model;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Logic {

    private PApplet app;
    private int minutes;
    private int seconds;
    private String time;
    private PImage hint,hint2;
    private PFont poppinsRegular;

    public Logic(PApplet app) {
        this.app=app;
        minutes=5;
        seconds=0;

        poppinsRegular = app.createFont("./data/font/Poppins-Regular.ttf",15);
        hint=app.loadImage("./data/bg/hint.png");
        hint2=app.loadImage("./data/bg/hint2.png");
    }

    public void timer(){
        if(app.frameCount%60==0){
            seconds--;
        }
        if(seconds<0){
            minutes--;
            seconds=59;
        }

        time = minutes+":"+app.nf(seconds,2);
    }

    public void  hint(){
        boolean axisX=app.mouseX>1170 && app.mouseX<1170+hint.width;
        boolean axisY=app.mouseY>40 && app.mouseY<40+hint.height;
        if(axisX && axisY){
            app.noStroke();
            app.fill(0,150);
            app.rect(0,0,1280,720);
            app.image(hint2,970,40);

            String hintText = "Deberás hacer clic y arrastrar las fichas con el ratón de tu computadora según la orientación que tengan (vertical u horizontalmente). ";
            app.textAlign(app.CENTER,app.TOP);
            app.fill(87,24,69);
            app.textFont(poppinsRegular);
            app.textLeading(22);
            app.text(hintText,995,96,200,138);
        }else{
            app.image(hint,1170,40);
        }
    }

    public void validateIntersectionH(Brick b1, Brick b2){
        boolean axisX = b1.getPosX()+b1.getImg().width > b2.getPosX() && b1.getPosX()<b2.getPosX()+b2.getImg().width;
        boolean axisY = b1.getPosY()+b1.getImg().height > b2.getPosY() && b1.getPosY()<b2.getPosY()+b2.getImg().height;
        if( axisX && axisY){
            if(b1.getPosX()+b1.getImg().width > b2.getPosX() && b1.getPosX()+b1.getImg().width< b2.getPosX()+b2.getImg().width){
                b1.setPosX(b1.getPosX()-1);
            }else if( b1.getPosX() > b2.getPosX() && b1.getPosX()< b2.getPosX()+b2.getImg().width) {
                b1.setPosX(b1.getPosX() + 1);
            }
            b1.setLocked(false);
        }
    }

    public void validateIntersectionV(Brick b1, Brick b2) {
        boolean axisX = b1.getPosX() + b1.getImg().width > b2.getPosX() && b1.getPosX() < b2.getPosX() + b2.getImg().width;
        boolean axisY = b1.getPosY() + b1.getImg().height > b2.getPosY() && b1.getPosY() < b2.getPosY() + b2.getImg().height;
        if (axisX && axisY) {
            if (b1.getPosY() + b1.getImg().height > b2.getPosY() && b1.getPosY() + b1.getImg().height < b2.getPosY() + b2.getImg().height) {
                b1.setPosY(b1.getPosY() - 1);
            } else if (b1.getPosY() > b2.getPosY() && b1.getPosY() < b2.getPosY() + b2.getImg().height) {
                b1.setPosY(b1.getPosY() + 1);
            }
            b1.setLocked(false);
        }
    }

    public String getTime() {
        return time;
    }
}
