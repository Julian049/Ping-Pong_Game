package co.edu.uptc.model.client;

import co.edu.uptc.model.DirectionEnum;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.util.SleepUtil;

import java.awt.*;

public class ManagerBallModel {

    private BallPojo ballPojo;

    public ManagerBallModel() {
        this.ballPojo = new BallPojo();
        ballPojo.setSpeed(5);
        ballPojo.setDirection(DirectionEnum.RIGHT);
        ballPojo.setPoint(new Point(0,0));
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
        ballPojo.setPoint(new Point(cordX,cordY));
        if (ballPojo.getPoint().x <= 0) {
            ballPojo.setDirection(DirectionEnum.RIGHT);
        }
    }

    public void rightBallPojo(BallPojo ballPojo) {
        int cordX = ballPojo.getPoint().x + ballPojo.getSpeed();
        int cordY = ballPojo.getPoint().y;
        ballPojo.setPoint(new Point(cordX,cordY));
        if (ballPojo.getPoint().x >= 1000) {
            ballPojo.setDirection(DirectionEnum.LEFT);
        }
    }

    public BallPojo getBallPojo() {
        return ballPojo;
    }

    public void setBallPojo(BallPojo ballPojo) {
        this.ballPojo = ballPojo;
    }
}
