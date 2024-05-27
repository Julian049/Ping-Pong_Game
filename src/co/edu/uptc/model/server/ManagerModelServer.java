package co.edu.uptc.model.server;

import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;

public class ManagerModelServer implements ContractPlay.ModelServer{
    public ContractPlay.PresenterServer presenter;


    @Override
    public void setPresenter(ContractPlay.PresenterServer presenter) {
        this.presenter = presenter;
    }

}
