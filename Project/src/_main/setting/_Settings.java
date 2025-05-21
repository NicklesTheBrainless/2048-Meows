package _main.setting;

import java.awt.*;

public abstract class _Settings {

    // WINDOW
    public static final String TITLE = "2048-Meows";

    // FPS
    public static final int SETTING_MAX_FPS = 5;

    // GAME
    public static final int GAME_WIDTH  = 4;
    public static final int GAME_HEIGHT = 4;

    // TILES
    public static final int TILE_TYPES = 10;
    public static final int TILE_SIZE   = 128;
    public static final int TILE_TEXTURE_SIZE = 16;
    public static final Color NEW_TILE_COLOR = new Color(100, 150, 250, 80);

    // SCREEN
    public static final int SCREEN_WIDTH  = GAME_WIDTH  * TILE_SIZE;
    public static final int SCREEN_HEIGHT = GAME_HEIGHT * TILE_SIZE;

}
