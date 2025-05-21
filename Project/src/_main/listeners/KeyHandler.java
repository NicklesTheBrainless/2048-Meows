package _main.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public int keyJustPressed = 0;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        keyJustPressed = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    // resets variables every update
    public void update() {

        keyJustPressed = 0;
    }

}
