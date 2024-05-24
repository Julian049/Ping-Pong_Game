package co.edu.uptc.model.server;

import co.edu.uptc.model.client.ManagerBallModel;
import co.edu.uptc.presenter.ContractPlay;

public class ManagerModelServer implements ContractPlay.ModelServer{
    public ContractPlay.PresenterServer presenter;
    private ManagerBallModel ballModel;

    public ManagerModelServer() {
        ballModel = new ManagerBallModel();
    }

    @Override
    public void setPresenter(ContractPlay.PresenterServer presenter) {
        this.presenter = presenter;
    }
}
