package _main.panel;

import _main.listeners.KeyHandler;
import _main.listeners.MouseHandler;
import game.TileManager;

import java.awt.*;

import static _main.setting._Settings.*;

public class GamePanel extends BasePanel {

    // input listeners
    public KeyHandler   keyH   = new KeyHandler();
    public MouseHandler mouseH = new MouseHandler();

    // game objects
    TileManager tileM = new TileManager(this);

    public GamePanel() {

        super(SETTING_MAX_FPS);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(new Color(40, 50, 60));

        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.addKeyListener(keyH);

        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
        this.addMouseWheelListener(mouseH);
    }



    @Override
    protected void update(double delta) {

        tileM.update(delta);

        // update listeners
        keyH.update();
        mouseH.update();
    }

    @Override
    protected void draw(Graphics2D g2) {

        tileM.draw(g2);
    }

    @Override
    protected void onSecond(int currentFPS) {

        // System.out.println(currentFPS);
    }
}