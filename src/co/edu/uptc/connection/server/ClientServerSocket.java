package co.edu.uptc.connection.server;

import co.edu.uptc.pojo.InfoClient;
import co.edu.uptc.pojo.PlayerPojo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientServerSocket {
    private Socket socket;
    private ServerSocketGame serverSocketGame;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ClientServerSocket(Socket socket) {
        this.socket = socket;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        listen();
    }

    public void listen() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (objectInputStream != null) {
                            InfoClient info = (InfoClient) objectInputStream.readObject();
                            int code = info.getCode();
                            int numberOfPLayer = info.getNumberPlayer();
                            int totalPlayers = info.getTotalPlayers();
                            if (code != 0) {
                                if (numberOfPLayer == 1) {
                                    serverSocketGame.moveRacket1(code);
                                    serverSocketGame.player1StartGame(code);
                                } else if (numberOfPLayer == totalPlayers) {
                                    serverSocketGame.moveRacket2(code);
                                    serverSocketGame.player2StartGame(code);
                                }
                            } else {
                                if (numberOfPLayer == 1) {
                                    serverSocketGame.player1Keys(info.getDown(), info.getUp(), info.getThrowBall());
                                } else if (numberOfPLayer == totalPlayers) {
                                    serverSocketGame.player2Keys(info.getDown(), info.getUp(), info.getThrowBall());
                                }
                            }

                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        thread.start();
    }

    public void write(PlayerPojo playerPojo) {
        try {
            objectOutputStream.writeObject(playerPojo);
            objectOutputStream.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setServerSocket(ServerSocketGame serverSocketGame) {
        this.serverSocketGame = serverSocketGame;
    }
}
