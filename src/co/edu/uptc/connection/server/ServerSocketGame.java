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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerSocketGame implements ContractPlay.Server {
    private ContractPlay.PresenterServer presenter;
    private ServerSocket serverSocketGame;
    private CopyOnWriteArrayList<ClientServerSocket> clients = new CopyOnWriteArrayList<>();
    private PlayerPojo playerPojo;
    private int numberPlayers = 0;

    public ServerSocketGame() {
        createPlayer();
        sendInfoClient();
    }

    @Override
    public void setPresenter(ContractPlay.PresenterServer presenter) {
        this.presenter = presenter;
    }

    @Override
    public void run() {
        Thread thread = new Thread(() -> {
            try {
                serverSocketGame = new ServerSocket(ModelPropertiesUtil.PORT);
                while ((!playerPojo.getPlayer1StartGame() && !playerPojo.getPlayer2StartGame())) {
                    Socket socket = serverSocketGame.accept();
                    numberPlayers++;
                    playerPojo.setNumberPlayer(numberPlayers);
                    playerPojo.setTotalPlayers(numberPlayers);
                    playerPojo.setRacketPojo2(assignRacket2(playerPojo));
                    ClientServerSocket clientServerSocket = new ClientServerSocket(socket);
                    clientServerSocket.setServerSocket(this);
                    clients.add(clientServerSocket);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    public void sendAllClients() {
        for (ClientServerSocket server : clients) {
            server.write(playerPojo);
        }
    }

    public void moveRacket1(int keyCode) {
        if (keyCode == playerPojo.getPlayer1UpKey()) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y - ModelPropertiesUtil.RACKETS_PIXEL_MOVEMENT));
        } else if (keyCode == playerPojo.getPlayer1DownKey()) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y + ModelPropertiesUtil.RACKETS_PIXEL_MOVEMENT));
        }
    }

    public void moveRacket2(int keyCode) {
        if (keyCode == playerPojo.getPlayer2UpKey()) {
            playerPojo.getRacketPojo2().setPoint(new Point(playerPojo.getRacketPojo2().getPoint().x, playerPojo.getRacketPojo2().getPoint().y - ModelPropertiesUtil.RACKETS_PIXEL_MOVEMENT));
        } else if (keyCode == playerPojo.getPlayer2DownKey()) {
            playerPojo.getRacketPojo2().setPoint(new Point(playerPojo.getRacketPojo2().getPoint().x, playerPojo.getRacketPojo2().getPoint().y + ModelPropertiesUtil.RACKETS_PIXEL_MOVEMENT));
        }
    }

    public void sendInfoClient() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    sendAllClients();
                    presenter.updatePlayerPojo(playerPojo);
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
        ballPojo.setSpeed(ModelPropertiesUtil.BALL_DX);
        ballPojo.setDirection(DirectionEnum.RIGHT);
        ballPojo.setPoint(new Point(ModelPropertiesUtil.BALL_X, ModelPropertiesUtil.BALL_Y));
        ballPojo.setSize(ModelPropertiesUtil.BALL_SIZE);
        ballPojo.setDy(ModelPropertiesUtil.BALL_DY);
        playerPojo.setBallPojo(ballPojo);

    }

    private RacketPojo assignRacket1(PlayerPojo playerPojo) {
        RacketPojo racket = new RacketPojo();
        racket.setPoint(new Point(ModelPropertiesUtil.RACKET1X, ModelPropertiesUtil.RACKETS_Y));
        racket.setHeight(ModelPropertiesUtil.RACKETS_HEIGHT);
        racket.setWidth(ModelPropertiesUtil.RACKETS_WIDTH);
        racket.setSpeed(ModelPropertiesUtil.RACKETS_SPEED);
        return racket;
    }

    private RacketPojo assignRacket2(PlayerPojo playerPojo) {
        RacketPojo racket = new RacketPojo();
        int x = (playerPojo.getTotalPlayers() * ModelPropertiesUtil.PLAYER_WIDTH) - ModelPropertiesUtil.SPACE_BETWEEN;
        int y = ModelPropertiesUtil.RACKETS_Y;
        racket.setPoint(new Point(x, y));
        racket.setHeight(ModelPropertiesUtil.RACKETS_HEIGHT);
        racket.setWidth(ModelPropertiesUtil.RACKETS_WIDTH);
        racket.setSpeed(ModelPropertiesUtil.RACKETS_SPEED);

        return racket;
    }

    public void player1StartGame(int keyCode) {
        if (keyCode == ModelPropertiesUtil.GENERAL_KEY_CODE || keyCode == playerPojo.getPlayer1ThrowBallKey()) {
            playerPojo.setPlayer1StartGame(true);
        }
    }

    public void player2StartGame(int keyCode) {
        if (keyCode == ModelPropertiesUtil.GENERAL_KEY_CODE || keyCode == playerPojo.getPlayer2ThrowBallKey()) {
            playerPojo.setPlayer2StartGame(true);
        }
    }

    public void player1Keys(int up, int down, int throwBall) {
        playerPojo.setPlayer1UpKey(up);
        playerPojo.setPlayer1DownKey(down);
        playerPojo.setPlayer1ThrowBallKey(throwBall);
    }

    public void player2Keys(int up, int down, int throwBall) {
        playerPojo.setPlayer2UpKey(up);
        playerPojo.setPlayer2DownKey(down);
        playerPojo.setPlayer2ThrowBallKey(throwBall);
    }

}
