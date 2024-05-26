package co.edu.uptc.pojo;

import java.io.Serializable;

public class InfoClient implements Serializable {
    private int code;
    private int numberPlayer;
    private int totalPlayers;
    private int left;
    private int right;

    public InfoClient(int code, int numberPlayer, int totalPlayers) {
        this.code = code;
        this.numberPlayer = numberPlayer;
        this.totalPlayers = totalPlayers;
    }

    public InfoClient(int numberPlayer, int totalPlayers,int left, int right) {
        this.numberPlayer = numberPlayer;
        this.totalPlayers = totalPlayers;
        this.left = left;
        this.right = right;
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

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
