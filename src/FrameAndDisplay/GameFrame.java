package FrameAndDisplay;

import javax.swing.*;

public class GameFrame extends JFrame {

//Frame Höhe und Breite
 private final int screenWitdh = 800 , screenHeight = 600;

 //Panel Objekt
private GamePanel gamePanel;




 //Konstruktur aufruf der Klasse Game Frame und der Superklasse JFrame um den Titel Zu setzen
public GameFrame(){
 super("Block-Breaker");

 //Klassen-Objekte werden erstellt
    gamePanel = new GamePanel();


    //Objekte werden dem Panel hinzugefügt
    add(gamePanel);

}

//Die Methode ruft die GUI auf und erstellt sie
public void initGui(){
  setSize(screenWitdh , screenHeight);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setResizable(false);
    setLayout(null);
  setLocationRelativeTo(null);
  setVisible(true);
}


}