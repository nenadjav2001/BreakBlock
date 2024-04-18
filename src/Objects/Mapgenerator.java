package Objects;

import java.awt.*;

public class Mapgenerator {

   public int map [][];
   public int brickWitdh;
   public int brickHeight;

   public Mapgenerator(int rows , int columns){
      map = new int[rows][columns];
      for (int i = 0; i <map.length; i++) {
         for (int j = 0; j <map[0].length; j++) {
             map[i][j] = 1;
         }
      }

   brickWitdh = 550/columns;
   brickHeight = 150/rows;
   }

   //Karte Methode zum zeichen der Karte
   public void draw(Graphics2D g){
      for (int i = 0; i < map.length; i++) {
         for (int j = 0; j < map[0].length; j++) {

            if (map[i][j] > 0) {
               g.setColor(Color.cyan);
               g.fillRect(j * brickWitdh + 80, i * brickHeight + 50, brickWitdh, brickHeight);
               g.setStroke(new BasicStroke(3));
               g.setColor(Color.black);
               g.drawRect(j * brickWitdh + 80 , i * brickHeight + 50 , brickWitdh , brickHeight);

            }

         }
      }
   }

   //Value wird zu dem array also 1
   public void setBrickValue(int value , int row , int col){
      map[row][col] = value;
   }


}
