package FrameAndDisplay;

import KeyHandler.KeyH;
import Objects.Ball;
import Objects.Mapgenerator;
import Objects.Player;
import Objects.Rects;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GamePanel extends JPanel implements Runnable {

    //Panel Variablen
    private final int panelX = 0, panelY = 0, panelWitdh = 800, panelHeight = 600;

    //Klassen-Objekte
    private Player player;

    private Ball ball;
    private KeyH keyH;
    private Mapgenerator map;


    //Layout
    SpringLayout springLayout = new SpringLayout();

    //Variablen

    private Random random;
    private boolean randomX;
    private boolean randomY;

    private Thread gameThread;
    private Rects[][] rects;
    private int totalBlocks = 21;


    //Im Konstruktur werden die objekte erstellt und das Panel wird erstellt
    public GamePanel() {


        setBounds(panelX, panelY, panelWitdh, panelHeight);
        setOpaque(true);
        setLayout(springLayout);

        //Klassen-Objekte
        player = new Player(400, 540, 100, 20, 10);
        ball = new Ball(400, 250, 25, 25, 5, 5);
        keyH = new KeyH(player);

        map = new Mapgenerator(3, 7);

        //Objekte werden Hinzugefügt

        random = new Random();

        //Random Booleans
        randomX = random.nextBoolean();
        randomY = random.nextBoolean();

        gameThread = new Thread(this);
        gameThread.start();


        addKeyListener(new KeyH(player));
        setFocusable(true);
        requestFocusInWindow();



    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        //Hintergrund wird gezeichnet
        g2.setColor(Color.BLACK);
        g2.fillRect(panelX, panelY, panelWitdh, panelHeight);

        //Player wird gezeichnet
        g2.setColor(Color.white);
        g2.fillRect(player.getPlayerX(), player.getPlayerY(), player.getPlayerWitdh(), player.getPlayerHeight());

        //Ball wird gezeichnet
        ball.draw(g2);

        //Blöcke werden Zeichnet
        map.draw((Graphics2D) g);


        //Panel wird neu gezeichnet
        repaint();


    }

    //Game Loop für das Spiel
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {

                //Player-Methoden
                player.movePlayerRight();
                player.movePlayerLeft();

                //Ball-Methoden
                ball.randomDirection(randomX, randomY);
                ball.collisionX(ball);
                ball.gameOverLose(ball);
                ball.collisionY(ball, player);


                //Player Ball Kolision
                if (new Rectangle(player.getPlayerX(), player.getPlayerY(), player.getPlayerWitdh(), player.getPlayerHeight()).intersects(new Rectangle(ball.getBallX(), ball.getBallY(), ball.getBallWitdh(), ball.getBallHeight()))) {
                    ball.changeDirectionForBallY();
                }

                A:
                for (int i = 0; i < map.map.length; i++) {
                    for (int j = 0; j < map.map[0].length; j++) {
                        if (map.map[i][j] > 0) {
                            int brickX = j * map.brickWitdh;
                            int brickY = i * map.brickHeight + 50;
                            int brickWitdh = map.brickWitdh;
                            int brickHeight = map.brickHeight;

                            //Rechtecke werden erstellt
                            Rectangle rect = new Rectangle(brickX, brickY, brickWitdh, brickHeight);
                            Rectangle ballRect = new Rectangle(ball.getBallX(), ball.getBallY(), ball.getBallWitdh(), ball.getBallHeight());
                            Rectangle brickRect = rect;

                            // Ball und Blöcke kolision
                            if (ballRect.intersects(brickRect)) {
                                map.setBrickValue(0, i, j);
                                totalBlocks--;
                                if (ball.getBallX() + 19 <= brickRect.x || ball.getBallX() + 1 >= brickRect.x + brickRect.width) {
                                    ball.changeDirectionForBallX();
                                } else {
                                    ball.changeDirectionForBallY();
                                }

                                //Wenn alle blöcke weg sind hat der Spieler gewonnen und die GUI wird geschlossen
                                if (totalBlocks == 0){
                                    JOptionPane.showMessageDialog(null , "Gewonnen");
                                    System.exit(0);
                                }

                                break A;

                            }


                        }
                    }
                }


                //Panel wird neu gezeichnet
                repaint();
                //Delta wird auf null gesetzt
                delta = 0;
            }
        }
    }





}