package co.edu.uptc.presenter.client;

import co.edu.uptc.model.client.ManagerModelClient;
import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.pojo.RacketPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.view.client.ManagerView;

public class ManagerPresenterClient implements ContractPlay.PresenterClient {

    private ContractPlay.View view;
    private ContractPlay.ModelClient model;
    private ContractPlay.Client client;

    @Override
    public void setModel(ContractPlay.ModelClient model) {
        this.model = model;
    }

    @Override
    public void setView(ContractPlay.View view) {
        this.view = view;
    }

    @Override
    public void setClient(ContractPlay.Client client) {
        this.client = client;
    }

    @Override
    public void startClient() {
        makeMVP();
        model.run();
        view.setPlayerPojo(model.getPlayerPojo());
        view.startGame();
        model.updateCountPoints();
    }

    public void makeMVP() {
        ManagerView managerView = new ManagerView();
        managerView.setPresenter(this);

        ManagerModelClient managerModelClient = new ManagerModelClient();
        managerModelClient.setPresenter(this);

        setView(managerView);
        setModel(managerModelClient);
    }

    @Override
    public void sendKey(int keyCode) {
        model.sendKey(keyCode, model.getPlayerPojo().getNumberPlayer(), model.getPlayerPojo().getTotalPlayers());
    }

    @Override
    public void startBall() {
        model.startBall();
    }

    @Override
    public void updatePlayers(PlayerPojo newPLayer) {
        model.updatePLayer(newPLayer);
        view.setPlayerPojo(model.getPlayerPojo());
    }

    @Override
    public BallPojo getBallPojo() {
        return model.getBallPojo();
    }

    @Override
    public RacketPojo getRacketPojo1() {
        if (model.getPlayerPojo() != null) {
            return model.getPlayerPojo().getRacketPojo1();
        }
        return new RacketPojo();
    }

    @Override
    public RacketPojo getRacketPojo2() {
        if (model.getPlayerPojo() != null) {
            return model.getPlayerPojo().getRacketPojo2();
        }
        return new RacketPojo();
    }

    @Override
    public PlayerPojo getPlayerPojo() {
        return model.getPlayerPojo();
    }

    @Override
    public void updatePlayer1Points(int player1Points) {
        view.updatePlayer1Points(player1Points);
    }

    @Override
    public void updatePlayer2Points(int player2Points) {
        view.updatePlayer2Points(player2Points);
    }
}
