package co.edu.uptc.connection.server;

import co.edu.uptc.model.DirectionEnum;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.pojo.RacketPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerSocket implements ContractPlay.Server {
    private ContractPlay.PresenterServer presenter;
    private java.net.ServerSocket serverSocket;
    private CopyOnWriteArrayList<ClientServerSocket> clients = new CopyOnWriteArrayList<>();
    private PlayerPojo playerPojo;
    private int numberPlayers = 0;
    private boolean ballIsMoving = false;

    public ServerSocket() {
        createPlayer();
        sendInfoClient();
        initCollision();
        startBall();
    }

    @Override
    public void setPresenter(ContractPlay.PresenterServer presenter) {
        this.presenter = presenter;
    }

    @Override
    public void run() {
        try {
            serverSocket = new java.net.ServerSocket(ModelPropertiesUtil.PORT);
            System.out.println("Servidor iniciado");
            System.out.println("Esperando jugadores...");
            while ((!playerPojo.getPlayer1StartGame() && !playerPojo.getPlayer2StartGame())) {
                Socket socket = serverSocket.accept();
                numberPlayers++;
                playerPojo.setNumberPlayer(numberPlayers);
                playerPojo.setTotalPlayers(numberPlayers);
                playerPojo.setRacketPojo2(assignRacket2(playerPojo));
                System.out.println("Cliente conectado");
                ClientServerSocket clientServerSocket = new ClientServerSocket(socket);
                clientServerSocket.setServerSocket(this);
                clients.add(clientServerSocket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendAllClients() {
        for (ClientServerSocket server : clients) {
            server.write(playerPojo);
        }
    }

    public void moveRacket1(int keyCode) {
        if (keyCode == playerPojo.getPlayer1UpKey()) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y - 10));
        } else if (keyCode == playerPojo.getPlayer1DownKey()) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y + 10));
        }
    }

    public void moveRacket2(int keyCode) {
        if (keyCode == playerPojo.getPlayer2UpKey()) {
            playerPojo.getRacketPojo2().setPoint(new Point(playerPojo.getRacketPojo2().getPoint().x, playerPojo.getRacketPojo2().getPoint().y - 10));
        } else if (keyCode == playerPojo.getPlayer2DownKey()) {
            playerPojo.getRacketPojo2().setPoint(new Point(playerPojo.getRacketPojo2().getPoint().x, playerPojo.getRacketPojo2().getPoint().y + 10));
        }
    }

    public void sendInfoClient() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    sendAllClients();
                    SleepUtil.sleep(1);
                }
            }
        });
        thread.start();
    }

    private void createPlayer() {
        playerPojo = new PlayerPojo();
        playerPojo.setNumberPlayer(numberPlayers);
        playerPojo.setTotalPlayers(numberPlayers + 1);
        playerPojo.setRacketPojo1(assignRacket1(playerPojo));
        playerPojo.setRacketPojo2(assignRacket2(playerPojo));
        BallPojo ballPojo = new BallPojo();
        ballPojo.setSpeed(2);
        ballPojo.setDirection(DirectionEnum.RIGHT);
        ballPojo.setPoint(new Point(20, 0));
        ballPojo.setSize(20);
        ballPojo.setDy(2);
        playerPojo.setBallPojo(ballPojo);
        
    }

    private RacketPojo assignRacket1(PlayerPojo playerPojo) {
        RacketPojo racket = new RacketPojo();
        racket.setPoint(new Point(10, 0));
        racket.setHeight(60);
        racket.setWidth(20);
        racket.setSpeed(5);
        return racket;
    }

    private RacketPojo assignRacket2(PlayerPojo playerPojo) {
        RacketPojo racket = new RacketPojo();
        int x = (playerPojo.getTotalPlayers() * 500) - 30;
        int y = 0;
        racket.setPoint(new Point(x, y));
        racket.setHeight(60);
        racket.setWidth(20);
        racket.setSpeed(5);

        return racket;
    }

    public void player1StartGame(int keyCode) {
        if (keyCode == 16 || keyCode == playerPojo.getPlayer1ThrowBallKey()) {
            playerPojo.setPlayer1StartGame(true);
        }
    }

    public void player2StartGame(int keyCode) {
        if (keyCode == 16 || keyCode == playerPojo.getPlayer2ThrowBallKey()) {
            playerPojo.setPlayer2StartGame(true);
        }
    }

    public void player1Keys(int up, int down, int throwBall) {
        playerPojo.setPlayer1UpKey(up);
        playerPojo.setPlayer1DownKey(down);
        playerPojo.setPlayer1ThrowBallKey(throwBall);
    }

    public void player2Keys(int up, int down,int throwBall) {
        playerPojo.setPlayer2UpKey(up);
        playerPojo.setPlayer2DownKey(down);
        playerPojo.setPlayer2ThrowBallKey(throwBall);
    }

    public void startBall() {
        Thread thread = new Thread(() -> {
            while (true) {
                if ((playerPojo.getPlayer1StartGame() && playerPojo.getPlayer2StartGame())) {
                    moveBallPojo(playerPojo.getBallPojo());
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
            //Nose
            playerPojo.setPlayer2Score(playerPojo.getPlayer2Score() + 1);
            ballPojo.setDirection(DirectionEnum.RIGHT);
            ballPojo.setPoint(new Point(((playerPojo.getTotalPlayers() * 500)-50), cordY));
            playerPojo.getRacketPojo2().setPoint(new Point((playerPojo.getTotalPlayers() * 500) - 30, (cordY-20)));
            playerPojo.setPlayer2StartGame(false);
        } else if (cordX >= playerPojo.getTotalPlayers() * 500) {
            playerPojo.setPlayer1Score(playerPojo.getPlayer1Score() + 1);
            ballPojo.setDirection(DirectionEnum.LEFT);
            ballPojo.setPoint(new Point(30, cordY));
            playerPojo.getRacketPojo1().setPoint(new Point(10, (cordY-20)));
            playerPojo.setPlayer1StartGame(false);
        }
    }

    public void initCollision() {
        //aaasdaadasdasdasdasd
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
        int racket1x1 = playerPojo.getRacketPojo1().getPoint().x;
        int racket1x2 = playerPojo.getRacketPojo1().getPoint().x + playerPojo.getRacketPojo2().getWidth();
        int racket1y1 = playerPojo.getRacketPojo1().getPoint().y;
        int racket1y2 = playerPojo.getRacketPojo1().getPoint().y + playerPojo.getRacketPojo2().getHeight();

        int ballx1 = playerPojo.getBallPojo().getPoint().x;
        int ballx2 = playerPojo.getBallPojo().getPoint().x + playerPojo.getBallPojo().getSize();
        int bally = playerPojo.getBallPojo().getPoint().y;
        if (bally >= racket1y1 && bally <= racket1y2) {
            if ((ballx1 <= racket1x2 && ballx1 >= racket1x1) || (ballx2 <= racket1x2 && ballx2 >= racket1x1)) {
                playerPojo.getBallPojo().setDirection(DirectionEnum.RIGHT);
            }
        }
    }

    public void verifyCollisionWithRacket2() {
        int racket2x1 = playerPojo.getRacketPojo2().getPoint().x;
        int racket2x2 = playerPojo.getRacketPojo2().getPoint().x + playerPojo.getRacketPojo2().getWidth();
        int racket2y1 = playerPojo.getRacketPojo2().getPoint().y;
        int racket2y2 = playerPojo.getRacketPojo2().getPoint().y + playerPojo.getRacketPojo2().getHeight();
        int ballx1 = playerPojo.getBallPojo().getPoint().x;
        int ballx2 = playerPojo.getBallPojo().getPoint().x + playerPojo.getBallPojo().getSize();
        int bally = playerPojo.getBallPojo().getPoint().y;
        if (bally >= racket2y1 && bally <= racket2y2) {
            if ((ballx1 <= racket2x2 && ballx1 >= racket2x1) || (ballx2 <= racket2x2 && ballx2 >= racket2x1)) {
                playerPojo.getBallPojo().setDirection(DirectionEnum.LEFT);
            }
        }
    }
}
