package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractPlay;

import javax.swing.*;
import java.awt.*;
 

public class ManagerView extends JFrame implements ContractPlay.View {
    public ContractPlay.Presenter presenter;

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    public ManagerView() {
        initComponents();
    }

    private ManagerView getInstance() {
        return this;
    }

    private void initComponents() {

    }

    private void initGame() {

    }

    @Override
    public void initMenu() {

    }

    @Override
    public void run() {
    }


}
