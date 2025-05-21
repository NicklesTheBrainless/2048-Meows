package game;

import _main.listeners.KeyHandler;
import _main.panel.GamePanel;
import utils.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

import static _main.resource._Resources.TILE_TEXTURES;
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

            case KeyEvent.VK_W -> makeMove(-1,  0);
            case KeyEvent.VK_A -> makeMove( 0, -1);
            case KeyEvent.VK_S -> makeMove( 1,  0);
            case KeyEvent.VK_D -> makeMove( 0,  1);
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        for (int y = 0; y < GAME_HEIGHT; y++) {
            for (int x = 0; x < GAME_WIDTH; x++) {

                int tileID = grid[x][y];
                g2.drawImage(TILE_TEXTURES[tileID], x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
            }
        }
    }



    private void makeMove(int moveX, int moveY) {

        placeRandomTile();

        compressAll(moveX, moveY);
        mergeAll(moveX, moveY);
        compressAll(moveX, moveY);
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

    private void compressAll(int moveX, int moveY) {

        for (int y = 0; y < GAME_HEIGHT; y++) {
            for (int x = 0; x < GAME_WIDTH; x++) {

                int tileID = grid[x][y];
                if (tileID == 0)
                    continue;

                compressTile(tileID, x, y, moveX, moveY);
            }
        }
    }

    private void mergeAll(int moveX, int moveY) {

    }



    private void compressTile(int tileID, int tileX, int tileY, int moveX, int moveY) {

        grid[tileX][tileY] = 0;

        while (true) {

            int checkX = tileX + moveX;
            int checkY = tileY + moveY;

            if (checkX < 0 || checkX >= GAME_WIDTH || checkY < 0 || checkY >= GAME_HEIGHT)
                break;

            int checkID = grid[checkX][checkY];
            if (checkID != 0)
                break;

            tileX = checkX;
            tileY = checkY;
        }

        grid[tileX][tileY] = tileID;
    }
}
