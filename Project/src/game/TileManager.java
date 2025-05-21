package game;

import _main.listeners.KeyHandler;
import _main.panel.GamePanel;
import utils.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

import static _main.setting._Settings.*;
import static utils.Utils.random;

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

        switch (kh.keyJustPressed) {

            case KeyEvent.VK_W -> move(-1,  0);
            case KeyEvent.VK_A -> move( 0, -1);
            case KeyEvent.VK_S -> move( 1,  0);
            case KeyEvent.VK_D -> move( 0,  1);
        }
    }

    @Override
    public void draw(Graphics2D g2) {

    }



    private void move(int moveX, int moveY) {

        placeRandomTile();

        compress(moveX, moveY);
        merge   (moveX, moveY);
        compress(moveX, moveY);
    }



    private void placeRandomTile() {

        boolean tilePlaced = false;
        while (!tilePlaced) {

            int rx = random.nextInt(GAME_WIDTH );
            int ry = random.nextInt(GAME_HEIGHT);

            int currentTile = grid[rx][ry];
            if (currentTile != 0)
                continue;

            grid[rx][ry] = random.nextInt(1, 3);
            tilePlaced = true;
        }
    }

    private void compress(int moveX, int moveY) {

    }

    private void merge(int moveX, int moveY) {

    }
}
