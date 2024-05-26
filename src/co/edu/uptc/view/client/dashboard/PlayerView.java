package co.edu.uptc.view.client.dashboard;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.pojo.RacketPojo;
import co.edu.uptc.util.SleepUtil;
import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.client.ManagerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerView extends JPanel {

    private BallPojo ballPojo;
    private RacketPojo racketPojo1;
    private RacketPojo racketPojo2;
    private ManagerView managerView;
    private PlayerPojo playerPojo;

    public PlayerView(BallPojo ballPojo) {
        initComponents();
        moveRacket();
    }

    public void initPojo() {
        playerPojo = managerView.presenter.getPlayerPojo();
        ballPojo = managerView.presenter.getBallPojo();
        racketPojo1 = managerView.presenter.getRacketPojo1();
        racketPojo2 = managerView.presenter.getRacketPojo2();
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }

    private void initComponents() {
        this.setBackground(new Color(0, 0, 255));
    }

    public void threadPaint() {
        Thread thread = new Thread(() -> {
            while (true) {
                SleepUtil.sleep(ViewPropertiesUtil.PAINT_SPEED_THREAD);
                initPojo();
                repaint();
            }
        });
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        if (playerPojo != null) {
            int finalPoint = playerPojo.getNumberPlayer() * 500;
            int initPoint = finalPoint - 500;
            int translate = initPoint* -1;
            g.translate(translate, 0);
            g.setClip(initPoint, 0, 500, this.getHeight());

            //Pinta la linea inicial horizontal
            g.fillRect(0, 0, managerView.getTotalFrameSize(), 10);

            //Pinta la linea inicial vertical
            g.fillRect(0, 0, 10, this.getHeight());

            //Pinta la linea final horizontal
            g.fillRect(0, (this.getHeight() - 10), managerView.getTotalFrameSize(), 10);

            //Pinta la linea horizontal en el medio
            int calculateMiddleToPaint = (this.getHeight() / 2) - (10 / 2);
            g.fillRect(0, calculateMiddleToPaint, managerView.getTotalFrameSize(), 10);

            //Pinta la linea final vertical
            g.fillRect(((managerView.getTotalFrameSize() - 10)), 0, 10, this.getHeight());

            //Borrar desde aquí
            g.setColor(Color.RED);
            int calculateMiddleToPaint2 = (managerView.getTotalFrameSize() / 2) - (10 / 2);
            g.fillRect(calculateMiddleToPaint2, 0, 10, this.getHeight());
            //Borrar hasta aquí

            if (ballPojo != null) {
                paintBall(g);
            }
            if (racketPojo1 != null && racketPojo2 != null) {
                paintRacket(g);
            }
        }
    }

    private void paintRacket(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(racketPojo1.getPoint().x, racketPojo1.getPoint().y, racketPojo1.getWidth(), racketPojo1.getHeight());

        g.setColor(Color.BLACK);
        g.fillRect(racketPojo2.getPoint().x, racketPojo2.getPoint().y, racketPojo2.getWidth(), racketPojo2.getHeight());
    }

    private void paintBall(Graphics g) {
//        ImageIcon cannon = new ImageIcon(ViewPropertiesUtil.CANNON_IMAGE);
//        cannon = new ImageIcon(cannon.getImage().getScaledInstance(cannonPojo.getWidth(), cannonPojo.getHeight(), Image.SCALE_FAST));
//        managerView.presenter.updateCannonYCoordinate();
//        g.drawImage(cannon.getImage(), cannonPojo.getCoordinateX(), cannonPojo.getCoordinateY(), null);

        g.setColor(Color.GREEN);
        g.fillOval(ballPojo.getPoint().x, ballPojo.getPoint().y, ballPojo.getSize(), ballPojo.getSize());
    }

    public void moveRacket() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                managerView.presenter.sendKey(Character.toUpperCase(e.getKeyChar()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        this.addKeyListener(keyListener);
        this.setFocusable(true);
    }
}
