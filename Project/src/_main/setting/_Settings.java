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

    // TILE TYPES AND TEXTURES
    public static final int TILE_TYPES = 10;
    public static final int TILE_SIZE   = 128;
    public static final int TILE_TEXTURE_SIZE = 16;

    // TILE STATES
    public static final int DEFAULT = 0;
    public static final int MERGED  = 1;
    public static final int SPAWNED = 2;

    // TILES STATE COLORS
    public static final Color DEFAULT_TILE_COLOR = new Color(0, 0, 0, 0);
    public static final Color SPAWNED_TILE_COLOR = new Color(100, 150, 250, 60);
    public static final Color MERGED_TILE_COLOR  = new Color(190, 80, 60, 60);

    // SCREEN
    public static final int SCREEN_WIDTH  = GAME_WIDTH  * TILE_SIZE;
    public static final int SCREEN_HEIGHT = GAME_HEIGHT * TILE_SIZE;

}
