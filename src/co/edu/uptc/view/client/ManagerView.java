package co.edu.uptc.view.client;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ViewPropertiesUtil;
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

    @Override
    public void startGame(int codeStart) {
        managePlayerView = new ManagerPlayerView(this, ballPojo);
        managePlayerView.run();
        presenter.sendKey(codeStart);
        presenter.updateCountPoints();
    }

    @Override
    public void setPlayerPojo(PlayerPojo playerPojo) {
        this.playerPojo = playerPojo;
    }

    public int getTotalFrameSize(){
        int totalPlayers = playerPojo.getTotalPlayers() * 500;
        return (totalPlayers);
    }

    @Override
    public void updatePlayer1Points(int player1Points) {
        managePlayerView.player1PointsLabel().setText("Player 1: " + player1Points);
    }

    @Override
    public void updatePlayer2Points(int player2Points) {
        managePlayerView.player2PointsLabel().setText("Player 2: " + player2Points);
    }

    public PlayerPojo getPlayerPojo() {
        return playerPojo;
    }

    public int getRightKey() {
        return menuView.getRightKey();
    }

    public int getLeftKey() {
        return menuView.getLeftKey();
    }

}
