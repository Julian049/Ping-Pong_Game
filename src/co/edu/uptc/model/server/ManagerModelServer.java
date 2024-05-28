package co.edu.uptc.model.server;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;

public class ManagerModelServer implements ContractPlay.ModelServer{
    public ContractPlay.PresenterServer presenter;
    private ManagerBallModel managerBallModel;
    private PlayerPojo playerPojo;

    public ManagerModelServer() {
        managerBallModel = new ManagerBallModel();
        managerBallModel.setManagerModelServer(this);
    }

    @Override
    public void setPresenter(ContractPlay.PresenterServer presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updatePlayerPojo(PlayerPojo playerPojo) {
        this.playerPojo = playerPojo;
    }

    @Override
    public void initBall() {
        managerBallModel.startBall();
        managerBallModel.initCollision();
    }

    public PlayerPojo getPlayerPojo() {
        return playerPojo;
    }
}
