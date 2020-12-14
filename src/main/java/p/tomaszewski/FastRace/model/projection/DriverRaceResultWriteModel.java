package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.Race;

public class DriverRaceResultWriteModel {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public DriverRaceResult toDriverRaceResult(){
        return new DriverRaceResult(score);
    }
}