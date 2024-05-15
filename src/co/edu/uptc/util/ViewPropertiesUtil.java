package co.edu.uptc.util;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ViewPropertiesUtil {
    private static final Properties properties = new Properties();
    private static Font myFont;

    static {
        try {
            properties.load(new FileInputStream("src/ViewConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Font getMyFont() {
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, new File(properties.getProperty("fontPath")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return myFont;
    }

    public static int MENU_WIDTH = Integer.parseInt(properties.getProperty("menuWidth"));
    public static int MENU_HEIGHT = Integer.parseInt(properties.getProperty("menuHeight"));
    public static String BACKGROUND_IMAGE = properties.getProperty("backgroundImage");
}
