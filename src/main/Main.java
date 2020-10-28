package main;

import model.*;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet {

    int screen;
    ArrayList<Brick> bricksLevel1V, bricksLevel1H;
    ArrayList<Brick> bricksLevel2V, bricksLevel2H;
    ArrayList<Brick> bricksLevel3V, bricksLevel3H;
    Brick demoV,demoH;
    Logic logic;
    Brick character;
    PImage bg1, bg2, axisX, axisY;
    PFont poppinsBlack, poppinsRegular;
    Button btnScreen1,btnScreen2,btnScreen3;
    int[][] matrix1,matrix2,matrix3;
    Matrix map1,map2,map3;
    String instructions, controls;
    
    //variable del puntaje
    int score;

    public static void main(String[] args) {
	Main.main("main.Main");
    }

    public void settings() {
        size(1280,720);
    }

    public void setup() {

        //initialize
        screen = 0;
        bricksLevel1V = new ArrayList<Brick>();
        bricksLevel1H = new ArrayList<Brick>();

        bricksLevel2V = new ArrayList<Brick>();
        bricksLevel2H = new ArrayList<Brick>();

        bricksLevel3V = new ArrayList<Brick>();
        bricksLevel3H = new ArrayList<Brick>();
        

        matrix1 = new int[][]{
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };

        matrix2 = new int[][]{
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };

        matrix3 = new int[][]{
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };

        map1 = new Matrix(matrix1,313,60,this);
        map2 = new Matrix(matrix2,313,60,this);
        map3 = new Matrix(matrix3,313,60,this);


        instructions = "Mueve las fichas de colores para liberar el camino de la ficha amarilla antes de que el tiempo acabe. Las fichas solo se moverán dependiendo de su orientación; si una ficha está orientada verticalmente, solo se moverá de arriba a abajo. Si una ficha está orientada horizontalmente, solo se moverá de izquierda a derecha. Igualmente, la ficha amarilla solo se mueve de izquierda a derecha.";
        controls = "Deberás hacer clic y arrastrar las fichas con el ratón de tu computadora según la orientación que tengan (vertical u horizontalmente).";

        btnScreen1 = new Button(680,470,245,80,"Continuar",this);
        btnScreen2 = new Button(540,600,200,66,"Continuar",this);
        btnScreen3 = new Button(1000,330,200,66,"Jugar",this);

        character = new YellowBrick(313,360,"X",this);
        demoV= new RedBrick(713,360,3,"Y",this);
        demoH= new OrangeBrick(513,260,3,"X",this);
        logic = new Logic(this);

        //add bricks of level 1
        bricksLevel1H.add(new OrangeBrick(513,160,3,"X",this));
        bricksLevel1H.add(new OrangeBrick(713,560,2,"X",this));
        
        bricksLevel1V.add(new RedBrick(513,260,3,"Y",this));
        bricksLevel1V.add(new PurpleBrick(713,360,2,"Y",this));

        //add bricks of level 2
        bricksLevel2V.add(new PurpleBrick(413,60,2,"Y",this));
        bricksLevel2V.add(new OrangeBrick(513,460,2,"Y",this));
        bricksLevel2V.add(new OrangeBrick(713,160,3,"Y",this));
        
        bricksLevel2H.add(new PurpleBrick(713,460,2,"X",this));
        bricksLevel2H.add(new RedBrick(313,360,3,"X",this));
        bricksLevel2H.add(new RedBrick(613,60,3,"X",this));

        //add bricks of level 3
        bricksLevel3V.add(new PurpleBrick(413,160,2,"Y",this));
        bricksLevel3V.add(new PurpleBrick(613,160,2,"Y",this));
        bricksLevel3V.add(new RedBrick(313,460,2,"Y",this));
        bricksLevel3V.add(new RedBrick(513,360,2,"Y",this));
        bricksLevel3V.add(new RedBrick(713,160,3,"Y",this));
        bricksLevel3V.add(new OrangeBrick(513,160,2,"Y",this));
        bricksLevel3V.add(new OrangeBrick(313,60,2,"Y",this));
        bricksLevel3V.add(new OrangeBrick(613,360,3,"Y",this));
        
        bricksLevel3H.add(new OrangeBrick(613,60,2,"X",this));
        bricksLevel3H.add(new RedBrick(413,60,2,"X",this));
        bricksLevel3H.add(new PurpleBrick(413,560,2,"X",this));

        //Load Images
        bg1 = loadImage("./data/bg/Bg1.png");
        bg2 = loadImage("./data/bg/Bg2.png");
        axisX = loadImage("./data/bg/axisX.png");
        axisY = loadImage("./data/bg/axisY.png");

        //Load Fonts
        poppinsBlack = createFont("./data/font/Poppins-Black.ttf",72);
        poppinsRegular = createFont("./data/font/Poppins-Regular.ttf",22);

    }
    
    int loop=0;

    public void draw() {
        background(87,24,69);

        switch (screen){
            case 0:
                image(bg1,0,0);
                fill(255);
                textFont(poppinsBlack);
                textLeading(75);
                textAlign(LEFT,TOP);
                text("Think\nOutside\nThe Box",680,185);
                btnScreen1.draw();
                break;

            case 1:
                image(bg2,0,220);
                fill(255);
                textAlign(LEFT,TOP);
                textFont(poppinsBlack,48);
                text("Instrucciones",150,84);
                text("Controles",830,84);

                textFont(poppinsRegular);
                textAlign(CENTER,TOP);
                textLeading(30);
                text(instructions,108,206,425,350);
                text(controls,704,206,512,160);

                image(axisX,766,396);
                image(axisY,1030,384);

                btnScreen2.draw();
                break;
                
            case 2:
            	
            	map1.draw();
            	demoV.draw();
            	demoH.draw();
            	character.draw();
            	btnScreen3.draw();
            	
                fill(255);
                textAlign(LEFT,TOP);
                textFont(poppinsBlack,48);
                text("Tutorial",1000,200);
            	
            	if(frameCount%30==0) {
            		switch(loop) {
            			case 1:
            				demoH.setPosX(demoH.getPosX()-100);
            				break;
            			case 2:
            				demoV.setPosY(demoV.getPosY()-100);
            				break;
            			case 3:
            				demoV.setPosY(demoV.getPosY()-100);
            				break;
            			case 4:
            				demoV.setPosY(demoV.getPosY()-100);
            				break;
            			case 5:
            				character.setPosX(character.getPosX()+100);
            				break;
            			case 6:
            				character.setPosX(character.getPosX()+100);
            				break;
            			case 7:
            				character.setPosX(character.getPosX()+100);
            				break;
            			case 8:
            				character.setPosX(character.getPosX()+100);
            				break;
            			case 9:
            				character.setPosX(character.getPosX()+100);
            				break;
            			case 10:
            				demoV.setPosY(360);
            				demoH.setPosX(513);
            				character.setPosX(313);
 
            				break;
            		}
            		if(loop==10) {
            			loop=0;
            		}else {
            			loop++;
            		}
            		
            	}

            	break;

            case 3:
                map1.draw();
                character.draw();

                for (Brick b : bricksLevel1V) {
                    b.draw();
                }

                for (Brick b : bricksLevel1H) {
                    b.draw();
                }

                for (Brick b1: bricksLevel1V) {
                    for (Brick b2: bricksLevel1H) {
                        logic.validateIntersectionV(b1,b2);
                        logic.validateIntersectionH(b2,b1);
                        logic.validateIntersectionH(character,b1);
                        logic.validateIntersectionV(b1,character);
                    }
                }

                if(character.getPosX()>=813){
                    score+=50;
                    character.setPosX(313);
                    character.setPosY(260);
                    character.setLocked(false);
                    screen=4;
                }

                logic.timer();
                fill(255);
                textAlign(LEFT,TOP);
                textFont(poppinsBlack,36);
                text(logic.getTime(),30,25);

                logic.hint();

                break;

            case 4:
                map2.draw();
                character.draw();

                for (Brick b : bricksLevel2V) {
                    b.draw();
                }

                for (Brick b : bricksLevel2H) {
                    b.draw();
                }

                for (Brick b1: bricksLevel2V) {
                    for (Brick b2: bricksLevel2H) {
                        logic.validateIntersectionV(b1,b2);
                        logic.validateIntersectionH(b2,b1);
                        logic.validateIntersectionH(character,b1);
                        logic.validateIntersectionV(b1,character);
                    }
                }

                if(character.getPosX()>=813){
                    score+=65;
                    character.setPosX(313);
                    character.setPosY(260);
                    character.setLocked(false);
                    screen=5;
                }

                logic.timer();
                fill(255);
                textAlign(LEFT,TOP);
                textFont(poppinsBlack,36);
                text(logic.getTime(),30,25);

                logic.hint();

                break;
            case 5:
                map3.draw();
                character.draw();

                for (Brick b : bricksLevel3V) {
                    b.draw();
                }

                for (Brick b : bricksLevel3H) {
                    b.draw();
                }

                for (Brick b1: bricksLevel3V) {
                    for (Brick b2: bricksLevel3H) {
                        logic.validateIntersectionV(b1,b2);
                        logic.validateIntersectionH(b2,b1);
                        logic.validateIntersectionH(character,b1);
                        logic.validateIntersectionH(character,b2);
                        logic.validateIntersectionV(b1,character);
                    }
                }

                for (Brick b1: bricksLevel3V) {
                    for (Brick b2: bricksLevel3V) {
                        if(b1 != b2){
                            logic.validateIntersectionV(b1,b2);
                        }
                    }
                }

                for (Brick b1: bricksLevel3H) {
                    for (Brick b2: bricksLevel3H) {
                        if(b1 != b2){
                            logic.validateIntersectionH(b1,b2);
                        }
                    }
                }

                if(character.getPosX()>=813){
                    score+=85;
                    character.setPosX(313);
                    character.setPosY(260);
                    character.setLocked(false);
                    screen=6;
                }

                logic.timer();
                fill(255);
                textAlign(LEFT,TOP);
                textFont(poppinsBlack,36);
                text(logic.getTime(),30,25);

                logic.hint();
                break;

            case 6:
            	image(bg1,0,0);
                fill(255);
                textFont(poppinsBlack,50);
                textLeading(65);
                textAlign(CENTER,TOP);
                text("felicidades\nterminastes\nel  minijuego",890,220);

                break;

        }
    }

    public void mousePressed(){
        switch (screen){
            case 0:
                if(btnScreen1.isFocus()){
                    screen=1;
                }
                break;

            case 1:
                if(btnScreen2.isFocus()){
                    screen=2;
                }
                break;
                
            case 2:
                if(btnScreen3.isFocus()){
                    screen=3;
                }
                break;

            case 3:
                if(character.isOver()){
                    character.setOffset();
                }
                for (Brick b : bricksLevel1V) {
                    if(b.isOver()){
                        b.setOffset();
                    }
                }
                for (Brick b : bricksLevel1H) {
                    if(b.isOver()){
                        b.setOffset();
                    }
                }
                break;

            case 4:
                if(character.isOver()){
                    character.setOffset();
                }
                for (Brick b : bricksLevel2V) {
                    if(b.isOver()){
                        b.setOffset();
                    }
                }
                for (Brick b : bricksLevel2H) {
                    if(b.isOver()){
                        b.setOffset();
                    }
                }
                break;
            case 5 :
                if(character.isOver()){
                    character.setOffset();
                }
                for (Brick b : bricksLevel3V) {
                    if(b.isOver()){
                        b.setOffset();
                    }
                }
                for (Brick b : bricksLevel3H) {
                    if(b.isOver()){
                        b.setOffset();
                    }
                }
                break;
        }
    }

    public void mouseDragged(){
        switch (screen){
            case 3:
                if(character.isLocked()){
                    character.move();
                }
                for (Brick b1: bricksLevel1V) {
                    if(b1.isLocked()){
                        b1.move();
                    }
                }
                for (Brick b1: bricksLevel1H) {
                    if(b1.isLocked()){
                        b1.move();
                    }
                }
                break;

            case 4:
                if(character.isLocked()){
                    character.move();
                }
                for (Brick b1: bricksLevel2V) {
                    if(b1.isLocked()){
                        b1.move();
                    }
                }
                for (Brick b1: bricksLevel2H) {
                    if(b1.isLocked()){
                        b1.move();
                    }
                }
                break;

            case 5:
                if(character.isLocked()){
                    character.move();
                }
                for (Brick b1: bricksLevel3V) {
                    if(b1.isLocked()){
                        b1.move();
                    }
                }
                for (Brick b1: bricksLevel3H) {
                    if(b1.isLocked()){
                        b1.move();
                    }
                }
                break;
        }
    }

    public void mouseReleased(){
        switch (screen){
            case 3:
                character.setLocked(false);
                for (Brick b: bricksLevel1V) {
                    b.setLocked(false);
                }
                for (Brick b: bricksLevel1H) {
                    b.setLocked(false);
                }
                break;

            case 4:
                character.setLocked(false);
                for (Brick b: bricksLevel2V) {
                    b.setLocked(false);
                }
                for (Brick b: bricksLevel2H) {
                    b.setLocked(false);
                }
                break;

            case 5:
                character.setLocked(false);
                for (Brick b: bricksLevel3V) {
                    b.setLocked(false);
                }
                for (Brick b: bricksLevel3H) {
                    b.setLocked(false);
                }
                break;
        }
    }

}

