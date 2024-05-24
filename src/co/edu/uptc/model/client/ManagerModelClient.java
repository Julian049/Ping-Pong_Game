package co.edu.uptc.model.client;

import co.edu.uptc.connection.client.ClientSocket;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.InfoClient;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.presenter.ContractPlay;

public class ManagerModelClient implements ContractPlay.ModelClient{

    private ContractPlay.PresenterClient presenter;
    private ClientSocket clientSocket = new ClientSocket();
    private ManagerBallModel ballModel = new ManagerBallModel();
    private PlayerPojo playerPojo;

    @Override
    public void setPresenter(ContractPlay.PresenterClient presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sendKey(char keyCode) {
        InfoClient info = new InfoClient(keyCode);
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
}
