package Objects;

import KeyHandler.KeyH;

import javax.swing.*;
import java.awt.*;

public class Ball extends Rectangle {

     int x;
     int y;
     int witdh;
    int height;
    int ballXStep;
    int ballYStep;


    public Ball(int x, int y, int witdh, int height, int ballXStep, int ballYStep) {
        super(x , y , witdh , height);
        this.x = x;
        this.y = y;
        this.witdh = witdh;
        this.height = height;
        this.ballXStep = ballXStep;
        this.ballYStep = ballYStep;
    }


    public int getBallXStep() {
        return ballXStep;
    }

    public int getBallX(){
        return x;
    }
    public int getBallY(){
        return y;
    }
    public int getBallWitdh(){
        return witdh;
    }
    public int getBallHeight(){
        return height;
    }

    public int getBallYStep() {
        return ballYStep;
    }

    public void randomDirection(boolean randomizerX, boolean randomizerY) {

        if (randomizerX) {
            x -= ballXStep;
        } else {
            x += ballXStep;
        }

        if (randomizerY) {
            y -= ballYStep;
        } else {
            y += ballYStep;
        }

    }

    public void collisionX(Ball ball) {

        if (ball.x > 780) {
            ball.ballXStep = -ball.ballXStep;
        } else if (ball.x < 15) {
            ball.ballXStep = -ball.ballXStep;
        }

    }

    public void collisionY(Ball ball ,Player player) {
        if (ball.y < 5) {
            ball.ballYStep = -ball.ballYStep;
        }
    }


    public void changeDirectionForBallX() {
        ballXStep = - ballXStep;
    }
    public void changeDirectionForBallY() {
        ballYStep = - ballYStep;
    }


    public void gameOverLose(Ball ball) {
        if (ball.y > 600) {
            JOptionPane.showMessageDialog(null, "Game-Over", "Over", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void draw (Graphics g2) {

     g2.setColor(Color.red);
     g2.fillOval( x ,  y ,  witdh ,  height);
    }





}