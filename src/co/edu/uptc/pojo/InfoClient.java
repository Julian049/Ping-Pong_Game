package co.edu.uptc.pojo;

import java.io.Serializable;

public class InfoClient implements Serializable {
    private int code;
    private int numberPlayer;
    private int totalPlayers;
    private int down;
    private int up;
    private int throwBall;

    public InfoClient(int code, int numberPlayer, int totalPlayers) {
        this.code = code;
        this.numberPlayer = numberPlayer;
        this.totalPlayers = totalPlayers;
    }

    public InfoClient(int numberPlayer, int totalPlayers, int down, int up,int throwBall) {
        this.numberPlayer = numberPlayer;
        this.totalPlayers = totalPlayers;
        this.down = down;
        this.up = up;
        this.throwBall = throwBall;
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

    public int getDown() {
        return down;
    }

    public int getUp() {
        return up;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getThrowBall() {
        return throwBall;
    }

    public void setThrowBall(int throwBall) {
        this.throwBall = throwBall;
    }

    public void setUp(int up) {
        this.up = up;
    }
}
