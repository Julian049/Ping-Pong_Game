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
    public static int RACKETSY=Integer.parseInt(properties.getProperty("racketsy"));
    public static int RACKETSHEIGHT=Integer.parseInt(properties.getProperty("racketsHeight"));
    public static int RACKETSWIDTH=Integer.parseInt(properties.getProperty("racketsWidth"));
    public static int RACKETSSPEED=Integer.parseInt(properties.getProperty("racketsSpeed"));
    public static int SPACEBETWEEN=Integer.parseInt(properties.getProperty("SpaceBetween"));
    public static int SPACEBETWEENBALL=Integer.parseInt(properties.getProperty("SpaceBetweenBall"));
    public static int TOTALWIDTH=Integer.parseInt(properties.getProperty("TotalWidht"));
    public static int GENERALKEYCODE=Integer.parseInt(properties.getProperty("GeneralKeyCode"));
    public static int BALLX=Integer.parseInt(properties.getProperty("BallPointX"));
    public static int BALLY=Integer.parseInt(properties.getProperty("BallPointY"));
    public static int BALLSIZE=Integer.parseInt(properties.getProperty("BallSize"));
    public static int BALLDX=Integer.parseInt(properties.getProperty("Balldx"));
    public static int BALLDY=Integer.parseInt(properties.getProperty("Balldy"));

}
