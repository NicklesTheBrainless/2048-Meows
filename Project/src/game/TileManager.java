package game;

import _main.listeners.KeyHandler;
import _main.panel.GamePanel;
import utils.GameObject;

import java.awt.*;

import static _main.setting._Settings.*;

public class TileManager implements GameObject {

    GamePanel gp;
    KeyHandler kh;

    int[][] grid = new int[GAME_WIDTH][GAME_HEIGHT];

    public TileManager(GamePanel gp) {

        this.gp = gp;
        this.kh = gp.keyH;
    }



    @Override
    public void update(double delta) {


    }

    @Override
    public void draw(Graphics2D g2) {

    }



    private void move() {

    }

    private void merge() {

    }
}
