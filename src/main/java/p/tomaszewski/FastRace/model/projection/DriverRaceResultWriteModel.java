package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.Race;

//mapuje tylko score
public class DriverRaceResultWriteModel {
    private int score;
    private Driver driver;
    private Race race2;
    private int race;

    public int getRace() {
        return race;
    }

    public void setRace(int raceId) {
        this.race = raceId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Race getRace2() {
        return race2;
    }

    public void setRace2(Race race2) {
        this.race2 = race2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

//    public DriverRaceResult toDriverRaceResult(){
//        return new DriverRaceResult();
//    }

    public DriverRaceResult toDriverRaceResult(){
        var result = new DriverRaceResult();
//        result.setDriver(driver);

        result.setRace(race2);
        result.setScore(score);
        return result;
    }
}
