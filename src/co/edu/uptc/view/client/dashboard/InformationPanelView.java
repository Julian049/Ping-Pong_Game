package co.edu.uptc.view.client.dashboard;

import co.edu.uptc.util.ViewPropertiesUtil;

import javax.swing.*;
import java.awt.*;

public class InformationPanelView extends JPanel {

    private JLabel player1PointsLabel;
    private JLabel player2PointsLabel;

    public InformationPanelView() {
        initComponents();
    }

    private void initComponents() {
        this.setBackground(Color.black);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        createLabels(gbc);
    }

    private void createLabels(GridBagConstraints gbc) {
        createLabelPointsPlayer1(gbc);
        createLabelPointsPlayer2(gbc);
    }

    private void createLabelPointsPlayer1(GridBagConstraints gbc) {
        player1PointsLabel = new JLabel("Player 1: 0");
        player1PointsLabel.setForeground(Color.WHITE);
        player1PointsLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(player1PointsLabel, gbc);
    }

    private void createLabelPointsPlayer2(GridBagConstraints gbc) {
        player2PointsLabel = new JLabel("Player 2: 0");
        player2PointsLabel.setForeground(Color.WHITE);
        player2PointsLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 25, 0, 0);
        add(player2PointsLabel, gbc);
    }

    public JLabel getPlayer1PointsLabel() {
        return player1PointsLabel;
    }

    public JLabel getPlayer2PointsLabel() {
        return player2PointsLabel;
    }

}
