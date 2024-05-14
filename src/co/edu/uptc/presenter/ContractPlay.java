package co.edu.uptc.presenter;

import java.util.concurrent.CopyOnWriteArrayList;


public interface ContractPlay {
    interface Model {
        void setPresenter(Presenter presenter);
    }

    interface View {
        void setPresenter(Presenter presenter);
        void run();
        void initMenu();
    }

    interface Presenter {
        void setView(View view);
        void setModel(Model model);
        void run();
        void startGame();
    }
}
