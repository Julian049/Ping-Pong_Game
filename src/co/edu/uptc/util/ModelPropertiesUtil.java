package co.edu.uptc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ModelPropertiesUtil {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/ModelConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int PORT = Integer.parseInt(properties.getProperty("port"));
    public static String HOST = properties.getProperty("host");
    public static int RACKET1X= Integer.parseInt(properties.getProperty("racket1x"));
    public static int RACKETS_Y =Integer.parseInt(properties.getProperty("racketsY"));
    public static int RACKETS_HEIGHT =Integer.parseInt(properties.getProperty("racketsHeight"));
    public static int RACKETS_WIDTH =Integer.parseInt(properties.getProperty("racketsWidth"));
    public static int RACKETS_SPEED =Integer.parseInt(properties.getProperty("racketsSpeed"));
    public static int SPACE_BETWEEN =Integer.parseInt(properties.getProperty("spaceBetween"));
    public static int SPACE_BETWEEN_BALL =Integer.parseInt(properties.getProperty("spaceBetweenBall"));
    public static int PLAYER_WIDTH =Integer.parseInt(properties.getProperty("playerWidth"));
    public static int GENERAL_KEY_CODE =Integer.parseInt(properties.getProperty("generalKeyCode"));
    public static int BALL_X =Integer.parseInt(properties.getProperty("ballPointX"));
    public static int BALL_Y =Integer.parseInt(properties.getProperty("ballPointY"));
    public static int BALL_SIZE =Integer.parseInt(properties.getProperty("ballSize"));
    public static int BALL_DX =Integer.parseInt(properties.getProperty("ballDx"));
    public static int BALL_DY =Integer.parseInt(properties.getProperty("ballDy"));
    public static int RACKETS_PIXEL_MOVEMENT = Integer.parseInt(properties.getProperty("racketsPixelMovement"));
    public static int PLAYER_HEIGHT = Integer.parseInt(properties.getProperty("playerHeight"));
}
