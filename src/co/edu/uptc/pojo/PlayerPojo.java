package co.edu.uptc.pojo;

import java.io.Serializable;

public class PlayerPojo implements Serializable {
    private RacketPojo racketPojo1;
    private RacketPojo racketPojo2;
    private boolean spectator = false;
    private int numberPlayer;
    private int totalPlayers;

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

    public boolean getSpectator() {
        return spectator;
    }

    public void setSpectator(boolean spectator) {
        this.spectator = spectator;
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

    @Override
    public String toString() {
        return "racketPojo1=" + racketPojo1 +
                ", spectator=" + spectator + "\n";
    }
}
