package co.edu.uptc.presenter;

import co.edu.uptc.pojo.BallPojo;
import co.edu.uptc.pojo.PlayerPojo;
import co.edu.uptc.pojo.RacketPojo;


public interface ContractPlay {
    interface ModelServer {
        void setPresenter(PresenterServer presenter);
        void updatePlayerPojo(PlayerPojo playerPojo);
        void initBall();
    }

    interface ModelClient {
        void setPresenter(PresenterClient presenter);
        void sendKey(int keyCode, int numberPLayer, int totalPlayers);
        void run();
        BallPojo getBallPojo();
        void updatePLayer(PlayerPojo newPLayer);
        PlayerPojo getPlayerPojo();
        void updateCountPoints();
        void playerSetKeys(int numberOfPlayer,int totalPlayers,int down, int up,int throwBall);
    }

    interface View {
        void setPresenter(PresenterClient presenter);
        void initMenu();
        void startGame(int codeStart);
        void setPlayerPojo(PlayerPojo player);
        void updatePlayer2Points(int player2Points);
        void updatePlayer1Points(int player1Points);
    }

    interface PresenterServer {
        void setModel(ModelServer model);
        void setServer(Server server);
        void startServer();
        void updatePlayerPojo(PlayerPojo playerPojo);
    }

    interface PresenterClient{
        void setModel(ModelClient model);
        void setView(View view);
        void setClient(Client client);
        void startClient();
        void updatePlayers(PlayerPojo playerPojo);
        void sendKey(int keyCode);
        BallPojo getBallPojo();
        RacketPojo getRacketPojo1();
        RacketPojo getRacketPojo2();
        PlayerPojo getPlayerPojo();
        void updatePlayer1Points(int player1Points);
        void updatePlayer2Points(int player2Points);
        void sendPlayerKeys(int downKey,int upKey,int throwBall);
        void updateCountPoints();
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
