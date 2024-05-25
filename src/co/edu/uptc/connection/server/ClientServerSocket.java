package co.edu.uptc.connection.server;

import co.edu.uptc.pojo.InfoClient;
import co.edu.uptc.pojo.PlayerPojo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientServerSocket {
    private Socket socket;
    private ServerSocket serverSocket;
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
                            if(numberOfPLayer == 1 ){
                                serverSocket.moveRacket1(code);
                                serverSocket.player1StartGame(code);
                            } else if (numberOfPLayer == totalPlayers) {
                                serverSocket.moveRacket2(code);
                                serverSocket.player2StartGame(code);
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

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
