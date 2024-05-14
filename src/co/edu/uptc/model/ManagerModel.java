package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractPlay;

import java.util.concurrent.CopyOnWriteArrayList;


public class ManagerModel implements ContractPlay.Model {
    private ContractPlay.Presenter presenter;

    private ManagerModel getInstance() {
        return this;
    }

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    }
