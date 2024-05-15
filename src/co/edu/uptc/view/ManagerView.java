package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.view.menu.MenuView;

import javax.swing.*;
import java.awt.*;
 

public class ManagerView extends JFrame implements ContractPlay.View {
    public ContractPlay.Presenter presenter;
    private MenuView menuView;

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
        menuView = new MenuView();
        menuView.setManagerView(getInstance());
        menuView.run();
    }

    @Override
    public void run() {

    }

    public void startGame() {
        presenter.startGame();
    }
}
