package game;

import _main.listeners.KeyHandler;
import _main.panel.GamePanel;
import utils.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static _main.resource._Resources.TILE_TEXTURES;
import static _main.setting._Settings.*;
import static utils.Utils.random;

public class TileManager implements GameObject {

    GamePanel gp;
    KeyHandler kh;

    int[][] grid = new int[GAME_WIDTH][GAME_HEIGHT];

    int newTileX, newTileY = -1;

    public TileManager(GamePanel gp) {

        this.gp = gp;
        this.kh = gp.keyH;
    }



    @Override
    public void update(double delta) {

        switch (kh.keyJustPressed) {

            case KeyEvent.VK_W -> makeMove( 0,-1);
            case KeyEvent.VK_A -> makeMove(-1, 0);
            case KeyEvent.VK_S -> makeMove( 0, 1);
            case KeyEvent.VK_D -> makeMove( 1, 0);
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        for (int y = 0; y < GAME_HEIGHT; y++) {
            for (int x = 0; x < GAME_WIDTH; x++) {

                int tileID = grid[x][y];
                g2.drawImage(TILE_TEXTURES[tileID], x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);

                g2.setColor(NEW_TILE_COLOR);
                if (x == newTileX && y == newTileY)
                    g2.fillOval(x * TILE_SIZE + 16, y * TILE_SIZE + 16, TILE_SIZE - 32, TILE_SIZE - 32);
            }
        }
    }



    private void makeMove(int moveX, int moveY) {

        compressAll(moveX, moveY);
        mergeAll(moveX, moveY);
        compressAll(moveX, moveY);

        placeRandomTile();
    }



    private void placeRandomTile() {

        List<int[]> emptyTiles = new ArrayList<>();

        for (int y = 0; y < GAME_HEIGHT; y++) {
            for (int x = 0; x < GAME_WIDTH; x++) {

                int tileID = grid[x][y];
                if (tileID == 0)
                    emptyTiles.add(new int[] {x, y});
            }
        }

        int randomIndex = random.nextInt(emptyTiles.size());
        int[] pickedPos = emptyTiles.get(randomIndex);
        int pickedX = pickedPos[0];
        int pickedY = pickedPos[1];

        int newTileID = 1;
        if (random.nextInt(10) == 0)
            newTileID = 2;

        grid[pickedX][pickedY] = newTileID;
    }

    private void compressAll(int moveX, int moveY) {

        int startX = (moveX == 1) ? GAME_WIDTH - 1 : 0;
        int endX = (moveX == 1) ? -1 : GAME_WIDTH;
        int addX = (moveX == 1) ? -1 : 1;

        int startY = (moveY == 1) ? GAME_HEIGHT - 1 : 0;
        int endY = (moveY == 1) ? -1 : GAME_HEIGHT;
        int addY = (moveY == 1) ? -1 : 1;

        for (int y = startY; y != endY; y += addY) {

            for (int x = startX; x != endX; x += addX) {

                int tileID = grid[x][y];
                if (tileID == 0)
                    continue;

                compressTile(tileID, x, y, moveX, moveY);
            }
        }
    }

    private void mergeAll(int moveX, int moveY) {

        int startX = (moveX == 1) ? GAME_WIDTH - 1 : 0;
        int endX = (moveX == 1) ? -1 : GAME_WIDTH;
        int addX = (moveX == 1) ? -1 : 1;

        int startY = (moveY == 1) ? GAME_HEIGHT - 1 : 0;
        int endY = (moveY == 1) ? -1 : GAME_HEIGHT;
        int addY = (moveY == 1) ? -1 : 1;

        for (int y = startY; y != endY; y += addY) {

            for (int x = startX; x != endX; x += addX) {

                int tileID = grid[x][y];
                if (tileID == 0)
                    continue;

                mergeTile(tileID, x, y, moveX, moveY);
            }
        }
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

    private void mergeTile(int tileID, int tileX, int tileY, int moveX, int moveY) {

        int checkX = tileX + moveX;
        int checkY = tileY + moveY;

        if (checkX < 0 || checkX >= GAME_WIDTH || checkY < 0 || checkY >= GAME_HEIGHT)
            return;

        int checkID = grid[checkX][checkY];
        if (checkID != tileID)
            return;

        grid[tileX][tileY] = 0;

        grid[checkX][checkY] = tileID + 1;
    }
}
