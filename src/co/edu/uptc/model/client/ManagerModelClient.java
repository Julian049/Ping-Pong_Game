package co.edu.uptc.model.client;

import co.edu.uptc.connection.client.ClientSocket;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.InfoClient;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;

public class ManagerModelClient implements ContractPlay.ModelClient {

    private ContractPlay.PresenterClient presenter;
    private ClientSocket clientSocket = new ClientSocket();
    private PlayerPojo playerPojo;
    private boolean firstUpdate = false;
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
    public void playerSetKeys(int numberOfPlayer, int totalPlayers, int down, int up,int throwBall){
        InfoClient info = new InfoClient(numberOfPlayer, totalPlayers, down, up,throwBall);
        clientSocket.write(info);
    }

    @Override
    public void run() {
        clientSocket.setPresenter(presenter);
        clientSocket.initClient();
        playerPojo = clientSocket.getPlayerPojo();
    }

    @Override
    public BallPojo getBallPojo() {
        return playerPojo.getBallPojo();
    }

    @Override
    public void updatePLayer(PlayerPojo newPLayer) {
        if (!firstUpdate) {
            this.playerPojo = newPLayer;
            firstUpdate = true;
        } else {
            this.playerPojo.setRacketPojo1(newPLayer.getRacketPojo1());
            this.playerPojo.setRacketPojo2(newPLayer.getRacketPojo2());
            this.playerPojo.setTotalPlayers(newPLayer.getTotalPlayers());
            this.playerPojo.setPlayer1StartGame(newPLayer.getPlayer1StartGame());
            this.playerPojo.setPlayer2StartGame(newPLayer.getPlayer2StartGame());
            this.playerPojo.setPlayer1DownKey(newPLayer.getPlayer1DownKey());
            this.playerPojo.setPlayer1UpKey(newPLayer.getPlayer1UpKey());
            this.playerPojo.setPlayer1ThrowBallKey(newPLayer.getPlayer1ThrowBallKey());
            this.playerPojo.setPlayer2DownKey(newPLayer.getPlayer2DownKey());
            this.playerPojo.setPlayer2UpKey(newPLayer.getPlayer2UpKey());
            this.playerPojo.setPlayer2ThrowBallKey(newPLayer.getPlayer2ThrowBallKey());
            this.playerPojo.setBallPojo(newPLayer.getBallPojo());
            this.playerPojo.setPlayer1Score(newPLayer.getPlayer1Score());
            this.playerPojo.setPlayer2Score(newPLayer.getPlayer2Score());
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
                int player1Points = playerPojo.getPlayer1Score();
                int player2Points = playerPojo.getPlayer2Score();
                presenter.updatePlayer1Points(player1Points);
                presenter.updatePlayer2Points(player2Points);
            }
        });
        thread.start();
    }

    public void setBallIsMoving(boolean ballIsMoving) {
    }

}
