package co.edu.uptc.presenter.server;

import co.edu.uptc.model.server.ManagerModelServer;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.connection.server.ServerSocketGame;

public class ManagerPresenterServer implements ContractPlay.PresenterServer {

    private ContractPlay.ModelServer model;
    @Override
    public void setModel(ContractPlay.ModelServer model) {
        this.model = model;
    }

    @Override
    public void setServer(ContractPlay.Server server) {
    }

    @Override
    public void startServer() {
        makeMVP();
        ServerSocketGame serverSocketGame = new ServerSocketGame();
        serverSocketGame.setPresenter(this);
        setServer(serverSocketGame);
        serverSocketGame.run();
        model.initBall();
    }

    private void makeMVP() {
        ManagerModelServer model = new ManagerModelServer();
        model.setPresenter(this);
        setModel(model);
    }

    @Override
    public void updatePlayerPojo(PlayerPojo playerPojo) {
        model.updatePlayerPojo(playerPojo);
    }
}
