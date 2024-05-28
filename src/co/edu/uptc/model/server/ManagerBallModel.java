package co.edu.uptc.model.server;

import co.edu.uptc.model.DirectionEnum;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.awt.*;
import java.util.Properties;

public class ManagerBallModel {

    private ManagerModelServer managerModelServer;

    public void setManagerModelServer(ManagerModelServer managerModelServer) {
        this.managerModelServer = managerModelServer;
    }

    public void startBall() {
        Thread thread = new Thread(() -> {
            while (true) {
              if ((managerModelServer.getPlayerPojo().getPlayer1StartGame() && managerModelServer.getPlayerPojo().getPlayer2StartGame())) {
                    moveBallPojo(managerModelServer.getPlayerPojo().getBallPojo());
                }
                SleepUtil.sleep(5);
            }
        });
        thread.start();
    }

    public void moveBallPojo(BallPojo ballPojo) {
        int cordX = ballPojo.getPoint().x;
        int cordY = ballPojo.getPoint().y;

        if (ballPojo.getDirection() == DirectionEnum.LEFT) {
            cordX -= ballPojo.getSpeed();
        } else if (ballPojo.getDirection() == DirectionEnum.RIGHT) {
            cordX += ballPojo.getSpeed();
        }

        cordY += ballPojo.getDy();

        if (cordY <= 0 || cordY >= 600 - ballPojo.getSize()) {
            ballPojo.setDy(-ballPojo.getDy());
        }

        ballPojo.setPoint(new Point(cordX, cordY));


        if (cordX <= 0) {
            managerModelServer.getPlayerPojo().setPlayer2Score(managerModelServer.getPlayerPojo().getPlayer2Score() + 1);
            ballPojo.setDirection(DirectionEnum.RIGHT);
            ballPojo.setPoint(new Point(((managerModelServer.getPlayerPojo().getTotalPlayers() * ModelPropertiesUtil.TOTALWIDTH)-ModelPropertiesUtil.SPACEBETWEENBALL), cordY));
            managerModelServer.getPlayerPojo().getRacketPojo2().setPoint(new Point((managerModelServer.getPlayerPojo().getTotalPlayers() * ModelPropertiesUtil.TOTALWIDTH) - ModelPropertiesUtil.SPACEBETWEEN, (cordY-20)));
            managerModelServer.getPlayerPojo().setPlayer2StartGame(false);
        } else if (cordX >= managerModelServer.getPlayerPojo().getTotalPlayers() * ModelPropertiesUtil.TOTALWIDTH) {
            managerModelServer.getPlayerPojo().setPlayer1Score(managerModelServer.getPlayerPojo().getPlayer1Score() + 1);
            ballPojo.setDirection(DirectionEnum.LEFT);
            ballPojo.setPoint(new Point(ModelPropertiesUtil.SPACEBETWEEN, cordY));
            managerModelServer.getPlayerPojo().getRacketPojo1().setPoint(new Point(ModelPropertiesUtil.RACKET1X, (cordY-20)));
            managerModelServer.getPlayerPojo().setPlayer1StartGame(false);
        }
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
        int racket1x1 = managerModelServer.getPlayerPojo().getRacketPojo1().getPoint().x;
        int racket1x2 = managerModelServer.getPlayerPojo().getRacketPojo1().getPoint().x + managerModelServer.getPlayerPojo().getRacketPojo2().getWidth();
        int racket1y1 = managerModelServer.getPlayerPojo().getRacketPojo1().getPoint().y;
        int racket1y2 = managerModelServer.getPlayerPojo().getRacketPojo1().getPoint().y + managerModelServer.getPlayerPojo().getRacketPojo2().getHeight();

        int ballx1 = managerModelServer.getPlayerPojo().getBallPojo().getPoint().x;
        int ballx2 = managerModelServer.getPlayerPojo().getBallPojo().getPoint().x + managerModelServer.getPlayerPojo().getBallPojo().getSize();
        int bally = managerModelServer.getPlayerPojo().getBallPojo().getPoint().y;
        if (bally >= racket1y1 && bally <= racket1y2) {
            if ((ballx1 <= racket1x2 && ballx1 >= racket1x1) || (ballx2 <= racket1x2 && ballx2 >= racket1x1)) {
                managerModelServer.getPlayerPojo().getBallPojo().setDirection(DirectionEnum.RIGHT);
            }
        }
    }

    public void verifyCollisionWithRacket2() {
        int racket2x1 = managerModelServer.getPlayerPojo().getRacketPojo2().getPoint().x;
        int racket2x2 = managerModelServer.getPlayerPojo().getRacketPojo2().getPoint().x + managerModelServer.getPlayerPojo().getRacketPojo2().getWidth();
        int racket2y1 = managerModelServer.getPlayerPojo().getRacketPojo2().getPoint().y;
        int racket2y2 = managerModelServer.getPlayerPojo().getRacketPojo2().getPoint().y + managerModelServer.getPlayerPojo().getRacketPojo2().getHeight();
        int ballx1 = managerModelServer.getPlayerPojo().getBallPojo().getPoint().x;
        int ballx2 = managerModelServer.getPlayerPojo().getBallPojo().getPoint().x + managerModelServer.getPlayerPojo().getBallPojo().getSize();
        int bally = managerModelServer.getPlayerPojo().getBallPojo().getPoint().y;
        if (bally >= racket2y1 && bally <= racket2y2) {
            if ((ballx1 <= racket2x2 && ballx1 >= racket2x1) || (ballx2 <= racket2x2 && ballx2 >= racket2x1)) {
                managerModelServer.getPlayerPojo().getBallPojo().setDirection(DirectionEnum.LEFT);
            }
        }
    }
}
