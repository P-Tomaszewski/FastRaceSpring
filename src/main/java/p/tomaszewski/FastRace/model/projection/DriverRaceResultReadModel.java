package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.DriverRaceResult;

public class DriverRaceResultReadModel {
    private int score;

    public DriverRaceResultReadModel(DriverRaceResult source) {
        score = source.getScore();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}