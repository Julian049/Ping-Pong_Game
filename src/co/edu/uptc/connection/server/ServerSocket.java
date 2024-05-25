package co.edu.uptc.connection.server;

import co.edu.uptc.model.DirectionEnum;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.pojo.RacketPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerSocket implements ContractPlay.Server {
    private ContractPlay.PresenterServer presenter;
    private java.net.ServerSocket serverSocket;
    private CopyOnWriteArrayList<ClientServerSocket> clients = new CopyOnWriteArrayList<>();
    private boolean isGameStarted = false;
    private PlayerPojo playerPojo;
    private int numberPlayers = 0;

    public ServerSocket() {
        createPlayer();
        sendInfoClient();
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
            while (!isGameStarted) {
                Socket socket = serverSocket.accept();
                numberPlayers++;
                playerPojo.setNumberPlayer(numberPlayers);
                playerPojo.setTotalPlayers(numberPlayers);
                playerPojo.setSpectator(setSpectator());
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
        if (playerPojo.getPlayer1StartGame() && playerPojo.getPlayer2StartGame()) {
            playerPojo.setStartMoveBall(true);
        }
        for (ClientServerSocket server : clients) {
            server.write(playerPojo);
        }
    }

    public void moveRacket1(int keyCode) {
        if (keyCode == 65) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y - 10));
        } else if (keyCode == 68) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y + 10));
        }
    }

    public void moveRacket2(int keyCode) {
        if (keyCode == 71) {
            playerPojo.getRacketPojo2().setPoint(new Point(playerPojo.getRacketPojo2().getPoint().x, playerPojo.getRacketPojo2().getPoint().y - 10));
        } else if (keyCode == 72) {
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

    private boolean setSpectator() {
        boolean isSpectator = true;
        if (clients.size() == 1 || clients.isEmpty()) {
            isSpectator = false;
        }
        return isSpectator;
    }

    private PlayerPojo createPlayer() {
        playerPojo = new PlayerPojo();
        playerPojo.setNumberPlayer(numberPlayers);
        playerPojo.setTotalPlayers(numberPlayers + 1);
        playerPojo.setSpectator(setSpectator());
        playerPojo.setRacketPojo1(assignRacket1(playerPojo));
        playerPojo.setRacketPojo2(assignRacket2(playerPojo));
        return playerPojo;
    }

    private RacketPojo assignRacket1(PlayerPojo playerPojo) {
        RacketPojo racket = new RacketPojo();
        racket.setPoint(new Point(10, 10));
        racket.setHeight(60);
        racket.setWidth(20);
        racket.setSpeed(5);
        return racket;
    }

    private RacketPojo assignRacket2(PlayerPojo playerPojo) {
        RacketPojo racket = new RacketPojo();
        int x = (playerPojo.getTotalPlayers() * 500) - 30;
        int y = 10;
        racket.setPoint(new Point(x, y));
        racket.setHeight(60);
        racket.setWidth(20);
        racket.setSpeed(5);

        return racket;
    }

    public void player1StartGame(int keyCode) {
        if (keyCode == 80) {
            playerPojo.setPlayer1StartGame(true);
        }
    }

    public void player2StartGame(int keyCode) {
        if (keyCode == 80) {
            playerPojo.setPlayer2StartGame(true);
        }
    }
}
