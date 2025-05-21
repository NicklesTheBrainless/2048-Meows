package _main.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    boolean wJustPressed, aJustPressed, sJustPressed, dJustPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W -> wJustPressed = true;
            case KeyEvent.VK_A -> aJustPressed = true;
            case KeyEvent.VK_S -> sJustPressed = true;
            case KeyEvent.VK_D -> dJustPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    // resets variables every update
    public void update() {

        wJustPressed = false;
        aJustPressed = false;
        sJustPressed = false;
        dJustPressed = false;
    }

}
