package co.edu.uptc.connection.client;

import co.edu.uptc.pojo.InfoClient;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ModelPropertiesUtil;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements ContractPlay.Client {
    private Socket socket;
    private ContractPlay.PresenterClient presenter;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private PlayerPojo playerPojo;

    @Override
    public void setPresenter(ContractPlay.PresenterClient presenter) {
        this.presenter = presenter;
    }

    public void initClient() {
        try {
            socket = new Socket(ModelPropertiesUtil.HOST, ModelPropertiesUtil.PORT);
            System.out.println("Cliente conectado");
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            listenClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listenClient() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        PlayerPojo playerPojo = (PlayerPojo) objectInputStream.readObject();
                        if (playerPojo != null) {
                            presenter.updatePlayers(playerPojo);
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

    public void write(InfoClient info){
        try {
            objectOutputStream.writeObject(info);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PlayerPojo getPlayerPojo() {
        return playerPojo;
    }
}
