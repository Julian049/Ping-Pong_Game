package co.edu.uptc.view.client;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.view.client.dashboard.ManagerPlayerView;
import co.edu.uptc.view.client.menu.MenuView;
import co.edu.uptc.view.client.menu.OptionsPanelView;

import javax.swing.*;


public class ManagerView extends JFrame implements ContractPlay.View {
    public ContractPlay.PresenterClient presenter;
    private MenuView menuView;
    private OptionsPanelView optionsPanelView;
    private ManagerPlayerView managePlayerView;
    private PlayerPojo playerPojo;
    private BallPojo ballPojo;

    @Override
    public void setPresenter(ContractPlay.PresenterClient presenter) {
        this.presenter = presenter;
    }

    public ManagerView() {
        this.playerPojo = playerPojo;
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

    public void backToMenu() {
        menuView.backToMenu();
    }

    public void startGame() {
        managePlayerView = new ManagerPlayerView(this, ballPojo);
        managePlayerView.run();
    }

    @Override
    public void setPlayerPojo(PlayerPojo playerPojo) {
        this.playerPojo = playerPojo;
    }

    public int getTotalFrameSize(){
        int totalPlayers = playerPojo.getTotalPlayers() * 500;
        return (totalPlayers);
    }

}
