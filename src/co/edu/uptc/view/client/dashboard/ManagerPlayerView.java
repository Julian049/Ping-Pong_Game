package co.edu.uptc.view.client.dashboard;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.view.client.ManagerView;

import javax.swing.*;
import java.io.Serializable;

public class ManagerPlayerView extends JFrame implements Serializable {
    private PlayerView playerView;

    public ManagerPlayerView(ManagerView managerView, BallPojo ballPojo) {
        initComponents(managerView, ballPojo);
    }

    private void initComponents(ManagerView managerView, BallPojo ballPojo) {
        setSize(516, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initGame(managerView, ballPojo);
    }

    private void initGame(ManagerView managerView, BallPojo ballPojo) {
        playerView = new PlayerView(ballPojo);
        playerView.setManagerView(managerView);
        playerView.threadPaint();
        add(playerView);
    }

    public void run() {
        setVisible(true);
    }
}
