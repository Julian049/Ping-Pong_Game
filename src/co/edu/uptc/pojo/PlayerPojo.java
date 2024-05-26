package co.edu.uptc.pojo;

import java.io.Serializable;

public class PlayerPojo implements Serializable {
    private RacketPojo racketPojo1;
    private RacketPojo racketPojo2;
    private int numberPlayer;
    private int totalPlayers;
    private boolean player1StartGame = false;
    private boolean player2StartGame = false;
    private boolean startMoveBall = false;
    private int player1RightKey;
    private int player1LeftKey;
    private int player2RightKey;
    private int player2LeftKey;

    public RacketPojo getRacketPojo1() {
        return racketPojo1;
    }

    public void setRacketPojo1(RacketPojo racketPojo1) {
        this.racketPojo1 = racketPojo1;
    }

    public RacketPojo getRacketPojo2() {
        return racketPojo2;
    }

    public void setRacketPojo2(RacketPojo racketPojo2) {
        this.racketPojo2 = racketPojo2;
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

    public boolean getStartMoveBall() {
        return startMoveBall;
    }

    public void setStartMoveBall(boolean startMoveBall) {
        this.startMoveBall = startMoveBall;
    }

    public boolean getPlayer1StartGame() {
        return player1StartGame;
    }

    public void setPlayer1StartGame(boolean player1StartGame) {
        this.player1StartGame = player1StartGame;
    }

    public boolean getPlayer2StartGame() {
        return player2StartGame;
    }

    public void setPlayer2StartGame(boolean player2StartGame) {
        this.player2StartGame = player2StartGame;
    }

    public int getPlayer1RightKey() {
        return player1RightKey;
    }

    public void setPlayer1RightKey(int player1RightKey) {
        this.player1RightKey = player1RightKey;
    }

    public int getPlayer1LeftKey() {
        return player1LeftKey;
    }

    public void setPlayer1LeftKey(int player1LeftKey) {
        this.player1LeftKey = player1LeftKey;
    }

    public int getPlayer2RightKey() {
        return player2RightKey;
    }

    public void setPlayer2RightKey(int player2RightKey) {
        this.player2RightKey = player2RightKey;
    }

    public int getPlayer2LeftKey() {
        return player2LeftKey;
    }

    public void setPlayer2LeftKey(int player2LeftKey) {
        this.player2LeftKey = player2LeftKey;
    }
}
