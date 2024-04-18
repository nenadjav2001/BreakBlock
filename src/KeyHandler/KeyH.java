package KeyHandler;

import Objects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class KeyH implements KeyListener {

    private Player player;

public KeyH(Player player){

  this.player = player;


}


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {


        int value = e.getKeyCode();
        switch (value) {
            case KeyEvent.VK_A -> player.setMovingLeft(true);
            case KeyEvent.VK_D -> player.setMovingRight(true);
        }




}

    @Override
    public void keyReleased(KeyEvent e) {

       int value = e.getKeyCode();
        switch (value) {
            case KeyEvent.VK_A -> player.setMovingLeft(false);
            case KeyEvent.VK_D -> player.setMovingRight(false);
        }
    }



}

