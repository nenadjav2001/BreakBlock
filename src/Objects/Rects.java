package Objects;

import java.awt.*;

public class Rects extends Rectangle {


int x , y , witdh , height;
Color rectColor;


public Rects(int x , int y , int witdh , int height){
    this.x = x;
    this.y = y;
    this.witdh = witdh;
    this.height = height;

}

    @Override
    public double getX() {
     return (double) x;
    }

    @Override
    public double getY() {
    return (double) y;
    }

    public double getWitdh(){
    return (double) witdh;
    }

    public double getHeight(){
    return (double) height;
    }

    public int getRectX(){
    return x;
    }
    public int getRectY(){
    return y;
    }
    public int getRectWitdh(){
    return witdh;
    }
    public int getRectHeight(){
    return height;
    }

}
