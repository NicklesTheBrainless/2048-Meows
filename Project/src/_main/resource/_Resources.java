package _main.resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static _main.setting._Settings.TILE_TEXTURE_SIZE;
import static _main.setting._Settings.TILE_TYPES;

public abstract class _Resources {

    public static final BufferedImage ICON = readImage("/icon.png");

    private static final BufferedImage TILE_SET = readImage("/tile_set.png");
    public static final BufferedImage[] TILE_TEXTURES = splitTileSet();



    private static BufferedImage readImage(String filePath) {

        try {
            return ImageIO.read(Objects.requireNonNull(_Resources.class.getResourceAsStream(filePath)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedImage[] splitTileSet() {

        BufferedImage[] tile_textures = new BufferedImage[TILE_TYPES];

        for (int i = 0; i < TILE_TYPES; i++) {

            int xOffset = i * TILE_TEXTURE_SIZE;
            tile_textures[i] = TILE_SET.getSubimage(xOffset, 0, TILE_TEXTURE_SIZE, TILE_TEXTURE_SIZE);
        }

        return tile_textures;
    }
}
