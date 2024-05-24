package co.edu.uptc.presenter;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.pojo.RacketPojo;


public interface ContractPlay {
    interface ModelServer {
        void setPresenter(PresenterServer presenter);;
    }

    interface ModelClient {
        void setPresenter(PresenterClient presenter);
        void sendKey(char keyCode);
        void run();
        void startBall();
        BallPojo getBallPojo();
    }

    interface View {
        void setPresenter(PresenterClient presenter);
        void initMenu();
        void startGame();
        void setPlayerPojo(PlayerPojo player);
    }

    interface PresenterServer {
        void setModel(ModelServer model);
        void setServer(Server server);
        void startServer();
    }

    interface PresenterClient{
        void setModel(ModelClient model);
        void setView(View view);
        void setClient(Client client);
        void startClient();
        void updatePlayers(PlayerPojo playerPojo);
        void sendKey(char keyCode);
        void startBall();
        BallPojo getBallPojo();
        RacketPojo getRacketPojo1();
        RacketPojo getRacketPojo2();
        PlayerPojo getPlayerPojo();
    }

    interface Server {
        void setPresenter(PresenterServer presenter);
        void run();
    }

    interface Client{
        void setPresenter(PresenterClient presenter);
        PlayerPojo getPlayerPojo();
    }
}
