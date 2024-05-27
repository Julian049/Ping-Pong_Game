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
    private int player1UpKey;
    private int player1DownKey;
    private int player1ThrowBallKey;
    private int player2UpKey;
    private int player2DownKey;
    private int player2ThrowBallKey;
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

    public int getPlayer1UpKey() {
        return player1UpKey;
    }

    public void setPlayer1UpKey(int player1UpKey) {
        this.player1UpKey = player1UpKey;
    }

    public int getPlayer1DownKey() {
        return player1DownKey;
    }

    public void setPlayer1DownKey(int player1DownKey) {
        this.player1DownKey = player1DownKey;
    }

    public int getPlayer2UpKey() {
        return player2UpKey;
    }

    public void setPlayer2UpKey(int player2UpKey) {
        this.player2UpKey = player2UpKey;
    }

    public int getPlayer2DownKey() {
        return player2DownKey;
    }

    public void setPlayer2DownKey(int player2DownKey) {
        this.player2DownKey = player2DownKey;
    }

    public BallPojo getBallPojo() {
        return ballPojo;
    }

    public void setBallPojo(BallPojo ballPojo) {
        this.ballPojo = ballPojo;
    }

    public int getPlayer2ThrowBallKey() {
        return player2ThrowBallKey;
    }

    public void setPlayer2ThrowBallKey(int player2ThrowBallKey) {
        this.player2ThrowBallKey = player2ThrowBallKey;
    }

    public int getPlayer1ThrowBallKey() {
        return player1ThrowBallKey;
    }

    public void setPlayer1ThrowBallKey(int player1ThrowBallKey) {
        this.player1ThrowBallKey = player1ThrowBallKey;
    }
}
