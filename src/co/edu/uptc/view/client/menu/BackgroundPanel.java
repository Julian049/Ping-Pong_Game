package co.edu.uptc.view.client.menu;

import co.edu.uptc.util.ViewPropertiesUtil;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(ViewPropertiesUtil.BACKGROUND_IMAGE);
        background = new ImageIcon(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
        g.drawImage(background.getImage(), 0, 0, null);
    }
}
