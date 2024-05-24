import co.edu.uptc.presenter.client.ManagerPresenterClient;
import co.edu.uptc.presenter.server.ManagerPresenterServer;

public class Main {
        public static void main(String[] args) {

            if (args.length > 0 && args[0].equals("client")) {
                ManagerPresenterClient managerPresenterClient = new ManagerPresenterClient();
                managerPresenterClient.startClient();
            }
            if (args.length > 0 && args[0].equals("server")) {
                ManagerPresenterServer managerPresenterServer = new ManagerPresenterServer();
                managerPresenterServer.startServer();
            }
        }
}
