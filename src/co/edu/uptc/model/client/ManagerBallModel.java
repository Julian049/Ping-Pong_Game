package co.edu.uptc.model.client;

import co.edu.uptc.model.DirectionEnum;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.util.SleepUtil;

import java.awt.*;

public class ManagerBallModel {

    private BallPojo ballPojo;
    private ManagerModelClient managerModelClient;
    private int player1Points;
    private int player2Points;

    public void setManagerModelClient(ManagerModelClient managerModelClient) {
        this.managerModelClient = managerModelClient;
    }

    public ManagerBallModel() {
        this.ballPojo = new BallPojo();
        ballPojo.setSpeed(2);
        ballPojo.setDirection(DirectionEnum.RIGHT);
        ballPojo.setPoint(new Point(0, 0));
        ballPojo.setSize(20);
    }

    public void startBall() {
        Thread thread = new Thread(() -> {
            while (true) {
                moveBallPojo(ballPojo);
                SleepUtil.sleep(5);
            }
        });
        thread.start();
    }

    public void moveBallPojo(BallPojo ballPojo) {
        if (ballPojo.getDirection() == DirectionEnum.LEFT) {
            leftBallPojo(ballPojo);
        }
        if (ballPojo.getDirection() == DirectionEnum.RIGHT) {
            rightBallPojo(ballPojo);
        }
    }

    public void leftBallPojo(BallPojo ballPojo) {
        int cordX = ballPojo.getPoint().x - ballPojo.getSpeed();
        int cordY = ballPojo.getPoint().y;
        ballPojo.setPoint(new Point(cordX, cordY));
        if (ballPojo.getPoint().x <= 0) {
            ballPojo.setDirection(DirectionEnum.RIGHT);
            player2Points++;
        }
    }

    public void rightBallPojo(BallPojo ballPojo) {
        int cordX = ballPojo.getPoint().x + ballPojo.getSpeed();
        int cordY = ballPojo.getPoint().y;
        ballPojo.setPoint(new Point(cordX, cordY));
        if (ballPojo.getPoint().x >= managerModelClient.getPlayerPojo().getTotalPlayers() * 500) {
            ballPojo.setDirection(DirectionEnum.LEFT);
            player1Points++;
        }
    }

    public BallPojo getBallPojo() {
        return ballPojo;
    }

    public void initCollision() {
        Thread thread = new Thread(() -> {
            while (true) {
                SleepUtil.sleep(1);
                verifyCollisionWithRacket1();
                verifyCollisionWithRacket2();
            }
        });
        thread.start();
    }

    public void verifyCollisionWithRacket1() {
        int racket1x1 = managerModelClient.getPlayerPojo().getRacketPojo1().getPoint().x;
        int racket1x2 = managerModelClient.getPlayerPojo().getRacketPojo1().getPoint().x + managerModelClient.getPlayerPojo().getRacketPojo2().getWidth();
        int racket1y1 = managerModelClient.getPlayerPojo().getRacketPojo1().getPoint().y;
        int racket1y2 = managerModelClient.getPlayerPojo().getRacketPojo1().getPoint().y + managerModelClient.getPlayerPojo().getRacketPojo2().getHeight();

        int ballx1 = ballPojo.getPoint().x;
        int ballx2 = ballPojo.getPoint().x + ballPojo.getSize();
        int bally = ballPojo.getPoint().y;
        if (bally >= racket1y1 && bally <= racket1y2) {
            if ((ballx1 <= racket1x2 && ballx1 >= racket1x1) || (ballx2 <= racket1x2 && ballx2 >= racket1x1)) {
                ballPojo.setDirection(DirectionEnum.RIGHT);
            }
        }
    }

    public void verifyCollisionWithRacket2() {
        int racket2x1 = managerModelClient.getPlayerPojo().getRacketPojo2().getPoint().x;
        int racket2x2 = managerModelClient.getPlayerPojo().getRacketPojo2().getPoint().x + managerModelClient.getPlayerPojo().getRacketPojo2().getWidth();
        int racket2y1 = managerModelClient.getPlayerPojo().getRacketPojo2().getPoint().y;
        int racket2y2 = managerModelClient.getPlayerPojo().getRacketPojo2().getPoint().y + managerModelClient.getPlayerPojo().getRacketPojo2().getHeight();
        int ballx1 = ballPojo.getPoint().x;
        int ballx2 = ballPojo.getPoint().x + ballPojo.getSize();
        int bally = ballPojo.getPoint().y;
        if (bally >= racket2y1 && bally <= racket2y2) {
            if ((ballx1 <= racket2x2 && ballx1 >= racket2x1) || (ballx2 <= racket2x2 && ballx2 >= racket2x1)) {
                ballPojo.setDirection(DirectionEnum.LEFT);
            }
        }
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public int getPlayer2Points() {
        return player2Points;
    }

    public void setBallPojo(BallPojo ballPojo) {
        this.ballPojo = ballPojo;
    }

}
