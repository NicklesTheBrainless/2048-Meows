package _main.listeners;

import java.awt.*;
import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener{

    public boolean leftJustClicked, middleJustClicked, rightJustClicked = false;
    public boolean leftJustPressed, middleJustPressed, rightJustPressed = false;
    public boolean leftJustReleased, middleJustReleased, rightJustReleased = false;

    public boolean leftPressed, middlePressed, rightPressed = false;

    public int x, y = 0;
    public Point pos = new Point();

    public int wheelRotation = 0;

    @Override
    public void mouseClicked(MouseEvent e) {

        switch (e.getButton()) {

            case MouseEvent.BUTTON1:
                leftJustClicked = true;
                break;

            case MouseEvent.BUTTON2:
                middleJustClicked = true;
                break;

            case MouseEvent.BUTTON3:
                rightJustClicked = true;
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        switch (e.getButton()) {

            case MouseEvent.BUTTON1:
                leftPressed = true;
                leftJustPressed = true;
                break;

            case MouseEvent.BUTTON2:
                middlePressed = true;
                middleJustPressed = true;
                break;

            case MouseEvent.BUTTON3:
                rightPressed = true;
                rightJustPressed = true;
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        switch (e.getButton()) {

            case MouseEvent.BUTTON1:
                leftPressed = false;
                leftJustReleased = true;
                break;

            case MouseEvent.BUTTON2:
                middlePressed = false;
                middleJustReleased = true;
                break;

            case MouseEvent.BUTTON3:
                rightPressed = false;
                rightJustReleased = true;
                break;
        }
    }



    @Override
    public void mouseMoved(MouseEvent e) {

        x = e.getX();
        y = e.getY();

        pos = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        x = e.getX();
        y = e.getY();

        pos = e.getPoint();
    }



    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}



    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        wheelRotation += e.getWheelRotation();
    }



    // resets variables every update
    public void update() {

        leftJustClicked = false;
        middleJustClicked = false;
        rightJustClicked = false;

        leftJustPressed = false;
        middleJustPressed = false;
        rightJustPressed = false;

        leftJustReleased = false;
        middleJustReleased = false;
        rightJustReleased = false;
    }

}
