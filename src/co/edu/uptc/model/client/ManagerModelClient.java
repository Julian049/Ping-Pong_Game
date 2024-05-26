package co.edu.uptc.model.client;

import co.edu.uptc.connection.client.ClientSocket;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.InfoClient;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;

public class ManagerModelClient implements ContractPlay.ModelClient {

    private ContractPlay.PresenterClient presenter;
    private ClientSocket clientSocket = new ClientSocket();
    private ManagerBallModel ballModel = new ManagerBallModel();
    private PlayerPojo playerPojo;
    private boolean firstUpdate = false;
    private boolean ballIsMoving = false;

    public ManagerModelClient() {
        ballModel.setManagerModelClient(this);
    }

    @Override
    public void setPresenter(ContractPlay.PresenterClient presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sendKey(int keyCode, int numberPLayer, int totalPlayers) {
        InfoClient info = new InfoClient(keyCode, numberPLayer, totalPlayers);
        clientSocket.write(info);
    }

    @Override
    public void playerSetKeys(int numberOfPlayer, int totalPlayers, int left, int right) {
        InfoClient info = new InfoClient(numberOfPlayer, totalPlayers, left, right);
        clientSocket.write(info);
    }

    @Override
    public void run() {
        clientSocket.setPresenter(presenter);
        clientSocket.initClient();
        playerPojo = clientSocket.getPlayerPojo();
    }

    @Override
    public void startBall() {
        ballModel.startBall();
    }

    @Override
    public BallPojo getBallPojo() {
        return ballModel.getBallPojo();
    }

    @Override
    public void updatePLayer(PlayerPojo newPLayer) {
        if (!firstUpdate) {
            this.playerPojo = newPLayer;
            firstUpdate = true;
            System.out.println("First update");
        } else {
            this.playerPojo.setRacketPojo1(newPLayer.getRacketPojo1());
            this.playerPojo.setRacketPojo2(newPLayer.getRacketPojo2());
            this.playerPojo.setTotalPlayers(newPLayer.getTotalPlayers());
            this.playerPojo.setPlayer1StartGame(newPLayer.getPlayer1StartGame());
            this.playerPojo.setPlayer2StartGame(newPLayer.getPlayer2StartGame());
            this.playerPojo.setPlayer1LeftKey(newPLayer.getPlayer1LeftKey());
            this.playerPojo.setPlayer1RightKey(newPLayer.getPlayer1RightKey());
            this.playerPojo.setPlayer2LeftKey(newPLayer.getPlayer2LeftKey());
            this.playerPojo.setPlayer2RightKey(newPLayer.getPlayer2RightKey());
        }
        if ((playerPojo.getPlayer1StartGame() && playerPojo.getPlayer2StartGame()) && !ballIsMoving) {
            startBall();
            ballModel.initCollision();
            ballIsMoving = true;
        }
    }

    @Override
    public PlayerPojo getPlayerPojo() {
        return playerPojo;
    }

    @Override
    public void updateCountPoints() {
        Thread thread = new Thread(() -> {
            while (true) {
                int player1Points = ballModel.getPlayer1Points();
                int player2Points = ballModel.getPlayer2Points();
                presenter.updatePlayer1Points(player1Points);
                presenter.updatePlayer2Points(player2Points);
            }
        });
        thread.start();
    }

    public void setBallIsMoving(boolean ballIsMoving) {
        this.ballIsMoving = ballIsMoving;
    }
}
