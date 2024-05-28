package co.edu.uptc.view.client.dashboard;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.view.client.ManagerView;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ManagerPlayerView extends JFrame implements Serializable {
    private PlayerView playerView;
    private InformationPanelView informationPanelView;

    public ManagerPlayerView(ManagerView managerView, BallPojo ballPojo) {
        initComponents(managerView, ballPojo);
    }

    private void initComponents(ManagerView managerView, BallPojo ballPojo) {
        setSize(ModelPropertiesUtil.PLAYER_WIDTH+16, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setResizable(false);
        initGame(managerView, ballPojo);
    }

    private void initGame(ManagerView managerView, BallPojo ballPojo) {
        GridBagConstraints constraints = new GridBagConstraints();
        informationPanelView = new InformationPanelView();
        constraints.weighty = 0.1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(informationPanelView, constraints);

        playerView = new PlayerView(ballPojo);
        playerView.setManagerView(managerView);
        constraints.weighty = 0.9;
        constraints.gridx = 0;
        constraints.gridy = 1;
        playerView.threadPaint();
        add(playerView, constraints);
    }

    public void run() {
        setVisible(true);
    }

    public JLabel player1PointsLabel() {
        return informationPanelView.getPlayer1PointsLabel();
    }

    public JLabel player2PointsLabel() {
        return informationPanelView.getPlayer2PointsLabel();
    }
}
