package Objects;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Player extends Rectangle {

    //Player-Variablen

    //Variablen für die Kordinanten des Players
    int x;
    int y;
    int witdh;
    int height;

    //boolische Variablen
   public boolean isMovingLeft;
   public boolean isMovingRight;

    //Geschwindkeit und Beschleunigung des Players
    private double playerSpeed = 5;

    private Rectangle hitbox;


//Konstruktur der Klasse Player
   public Player(int x , int y , int witdh , int height , double playerSpeed){
       super(x , y , witdh , height);
       this.x = x;
       this.y = y;
       this.witdh = witdh;
       this.height = height;
       this.playerSpeed = playerSpeed;

   }

   public int getPlayerX(){
       return x;
   }
    public int getPlayerY(){
        return y;
    }
    public int getPlayerWitdh(){
        return witdh;
    }
    public int getPlayerHeight(){
        return height;
    }
    public double getPlayerSpeed(){
       return playerSpeed;
    }

    public void movePlayerLeft(){
       if (isMovingLeft){
           x -= playerSpeed;
       }
    }
    public void movePlayerRight(){

       if (isMovingRight){
           x += playerSpeed;
       }
   }



   public void setMovingLeft(boolean movingLeft){
       this.isMovingLeft = movingLeft;
   }
   public void setMovingRight(boolean movingRight){
       this.isMovingRight = movingRight;
   }



}
