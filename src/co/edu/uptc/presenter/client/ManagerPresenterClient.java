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
    private PlayerPojo playerPojo;
    private boolean firstUpdate = false;

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
        view.setPlayerPojo(playerPojo);
        view.startGame();
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
    public void sendKey(char keyCode) {
        model.sendKey(keyCode);
    }

    @Override
    public void startBall() {
        model.startBall();
    }

    @Override
    public void updatePlayers(PlayerPojo newPLayer) {
        if (!firstUpdate) {
            this.playerPojo = newPLayer;
            firstUpdate = true;
            System.out.println("First update");
        }else {
            this.playerPojo.setRacketPojo1(newPLayer.getRacketPojo1());
            this.playerPojo.setRacketPojo2(newPLayer.getRacketPojo2());
            this.playerPojo.setTotalPlayers(newPLayer.getTotalPlayers());
        }
        view.setPlayerPojo(playerPojo);
    }
    @Override
    public BallPojo getBallPojo() {
        return model.getBallPojo();
    }

    @Override
    public RacketPojo getRacketPojo1() {
        if (playerPojo != null) {
            return playerPojo.getRacketPojo1();
        }
        return new RacketPojo();
    }

    @Override
    public RacketPojo getRacketPojo2() {
        if (playerPojo != null) {
            return playerPojo.getRacketPojo2();
        }
        return new RacketPojo();
    }

    @Override
    public PlayerPojo getPlayerPojo() {
        return playerPojo;
    }
}
