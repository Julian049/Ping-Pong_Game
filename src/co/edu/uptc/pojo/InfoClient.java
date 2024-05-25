package co.edu.uptc.pojo;

import java.io.Serializable;

public class InfoClient implements Serializable {
    private int code;
    private int numberPlayer;
    private int totalPlayers;
    private boolean stop;

    public InfoClient(int code, int numberPlayer, int totalPlayers) {
        this.code = code;
        this.numberPlayer = numberPlayer;
        this.totalPlayers = totalPlayers;
    }

    public InfoClient(boolean stop) {
        this.stop = stop;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }

    public void setNumberPlayer(int numberPlayer) {
        this.numberPlayer = numberPlayer;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public boolean getStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
