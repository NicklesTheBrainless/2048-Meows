package _main.resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class _Resources {

    BufferedImage TILE_SET = readImage("/tile_set.png");



    private static BufferedImage readImage(String filePath) {

        try {
            return ImageIO.read(Objects.requireNonNull(_Resources.class.getResourceAsStream(filePath)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
