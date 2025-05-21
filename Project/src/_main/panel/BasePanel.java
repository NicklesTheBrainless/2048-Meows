package _main.panel;

import javax.swing.*;
import java.awt.*;

public abstract class BasePanel extends JPanel implements Runnable {

    // FPS
    protected final int MAX_FPS;

    // Constants
    private final static int NANOSECONDS_PER_SECOND = 1_000_000_000;

    Thread gameThread;

    protected BasePanel(int maxFps) {
        MAX_FPS = maxFps;
    }

    public void startProgramThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }



    protected abstract void update(double delta);

    protected abstract void draw(Graphics2D g2);

    protected abstract void onSecond(int currentFPS);



    @Override
    public void run() {

        double frameInterval = (double) NANOSECONDS_PER_SECOND / MAX_FPS;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;

        int timer = 0;
        int currentFPS = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / frameInterval;
            timer += (int) (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {

                update(delta);
                repaint();

                delta--;
                currentFPS++;
            }

            if (timer >= NANOSECONDS_PER_SECOND) {

                onSecond(currentFPS);

                currentFPS = 0;
                timer = 0;
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // draws everything
        this.draw(g2);

        g2.dispose();
    }

}
