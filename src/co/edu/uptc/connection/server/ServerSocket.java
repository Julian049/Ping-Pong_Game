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

public class ServerSocket implements ContractPlay.Server {
    private ContractPlay.PresenterServer presenter;
    private java.net.ServerSocket serverSocket;
    private List<ClientServerSocket> clients = new ArrayList<>();
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

    public void moveRacket(char keyCode) {
        if ((int)keyCode == 97) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y - 10));
        } else if ((int)keyCode == 100) {
            playerPojo.getRacketPojo1().setPoint(new Point(playerPojo.getRacketPojo1().getPoint().x, playerPojo.getRacketPojo1().getPoint().y + 10));
        } else if ((int)keyCode == 103) {
            playerPojo.getRacketPojo2().setPoint(new Point(playerPojo.getRacketPojo2().getPoint().x, playerPojo.getRacketPojo2().getPoint().y - 10));
        } else if ((int)keyCode == 104) {
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

    private PlayerPojo createPlayer() {
        playerPojo = new PlayerPojo();
        if (clients.size() == 1 || clients.isEmpty()) {
            playerPojo.setSpectator(false);
        } else {
            playerPojo.setSpectator(true);
        }
        playerPojo.setNumberPlayer(numberPlayers);
        playerPojo.setTotalPlayers(numberPlayers+1);
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
}
