package co.edu.uptc.presenter.server;

import co.edu.uptc.model.server.ManagerModelServer;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.connection.server.ServerSocket;

public class ManagerPresenterServer implements ContractPlay.PresenterServer{

    private ContractPlay.ModelServer model;
    private ContractPlay.Server server;

    @Override
    public void setModel(ContractPlay.ModelServer model) {
        this.model = model;
    }

    @Override
    public void setServer(ContractPlay.Server server) {
        this.server = server;
    }

    @Override
    public void startServer() {
        makeMVP();
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.setPresenter(this);
        setServer(serverSocket);
        serverSocket.run();
    }

    private void makeMVP() {
        ManagerModelServer model = new ManagerModelServer();
        model.setPresenter(this);
        setModel(model);
    }
}
