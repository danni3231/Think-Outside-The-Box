package model;

import processing.core.PApplet;
import processing.core.PImage;


public class Matrix {

    private int posX, posY;
    private int[][] matrix;
    private PApplet app;
    private PImage title1,title2;

    public Matrix(int[][] matrix,int posX, int posY, PApplet app) {
        this.posX = posX;
        this.posY = posY;
        this.app = app;

        this.title1 = app.loadImage("./data/bg/title1.png");
        this.title2 = app.loadImage("./data/bg/title2.png");

        this.matrix=matrix;

    }
    public void draw(){
        for (int row=0; row<6; row++) {
            for (int col=0; col<6; col++) {
                switch (matrix[row][col]){
                    case 0:
                        app.image(title1,posX+(100*col),posY+(100*row));
                        break;
                    case 1:
                        app.image(title2,posX+(100*col),posY+(100*row));
                        break;

                }
            }
        }
    }


}
