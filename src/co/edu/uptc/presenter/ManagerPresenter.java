package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.view.ManagerView;

import java.util.concurrent.CopyOnWriteArrayList;


public class ManagerPresenter implements ContractPlay.Presenter {
    private ContractPlay.View view;
    private ContractPlay.Model model;

    @Override
    public void setView(ContractPlay.View view) {
        this.view = view;
    }

    @Override
    public void setModel(ContractPlay.Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        makeMVP();
        view.initMenu();
    }

    @Override
    public void startGame() {
        view.run();
    }

    public void makeMVP() {
        ManagerView managerView = new ManagerView();
        managerView.setPresenter(this);

        ManagerModel managerModel = new ManagerModel();
        managerModel.setPresenter(this);

        setView(managerView);
        setModel(managerModel);
    }

}
