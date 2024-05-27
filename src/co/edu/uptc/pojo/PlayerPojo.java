package co.edu.uptc.pojo;

import java.io.Serializable;

public class PlayerPojo implements Serializable {
    private RacketPojo racketPojo1;
    private RacketPojo racketPojo2;
    private BallPojo ballPojo;
    private int numberPlayer;
    private int totalPlayers;
    private boolean player1StartGame = false;
    private boolean player2StartGame = false;
    private int player1RightKey;
    private int player1LeftKey;
    private int player2RightKey;
    private int player2LeftKey;
    private int player1Score;
    private int player2Score;

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

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

    public BallPojo getBallPojo() {
        return ballPojo;
    }

    public void setBallPojo(BallPojo ballPojo) {
        this.ballPojo = ballPojo;
    }
}
