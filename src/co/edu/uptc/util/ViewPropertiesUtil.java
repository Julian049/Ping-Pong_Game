package co.edu.uptc.util;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ViewPropertiesUtil {
    private static final Properties propertiesConfig = new Properties();
    private static final Properties propertiesText = new Properties();
    private static Font myFont;

    static {
        try {
            propertiesConfig.load(new FileInputStream("src/ViewConfig.properties"));
            propertiesText.load(new FileInputStream("src/TextConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Font getMyFont() {
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, new File(propertiesConfig.getProperty("fontPath")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return myFont;
    }

    public static int MENU_WIDTH = Integer.parseInt(propertiesConfig.getProperty("menuWidth"));
    public static int MENU_HEIGHT = Integer.parseInt(propertiesConfig.getProperty("menuHeight"));
    public static String BACKGROUND_IMAGE = propertiesConfig.getProperty("backgroundImage");
    public static String GAME_TITLE = propertiesText.getProperty("gameTitle");
    public static String CLICK_TO_SET_A_KEY = propertiesText.getProperty("clickToSetAKey");
    public static String PRESS_A_KEY = propertiesText.getProperty("pressKey");
    public static String KEY_SELECTED = propertiesText.getProperty("keySelected");
    public static String MOVE_UP = propertiesText.getProperty("moveUp");
    public static String MOVE_DOWN = propertiesText.getProperty("moveDown");
    public static String THROW_BALL = propertiesText.getProperty("throwBall");
    public static String ANY_KEY_SELECTED_ERROR = propertiesText.getProperty("anyKeySelectedError");
    public static String ERROR_TITLE = propertiesText.getProperty("errorWindowTitle");
    public static String NOTE = propertiesText.getProperty("note");
    public static String START_BUTTON = propertiesText.getProperty("startButton");
    public static String SETTINGS_BUTTON = propertiesText.getProperty("settingsButton");
    public static Color TEXT_COLOR = new Color(131,127,183);
    public static Color TEXT_COLOR2 = new Color(0,0,0);
    public static String BACK_BUTTON = propertiesText.getProperty("backButton");
    public static int PAINT_SPEED_THREAD = Integer.parseInt(propertiesConfig.getProperty("paintSpeedThread"));
    public static Color TABLE_COLOR = new Color(0, 166, 81);
    public static Color BALL_COLOR = new Color(232,184,18);
    public static String PLAYER_1_INITIAL_TEXT = propertiesText.getProperty("player1InitialText");
    public static String PLAYER_2_INITIAL_TEXT = propertiesText.getProperty("player2InitialText");
    public static String PLAYER_1_POINTS_TEXT = propertiesText.getProperty("player1PointsText");
    public static String PLAYER_2_POINTS_TEXT = propertiesText.getProperty("player2PointsText");
}
