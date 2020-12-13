package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.Race;

import java.time.LocalDateTime;

public class DriverRaceResultReadModel {
    private int place;
    private LocalDateTime time;
    private LocalDateTime theBestTime;

    public DriverRaceResultReadModel(DriverRaceResult source) {
        place = source.getPlace();
        time = source.getTime();
        theBestTime = source.getTheBestTime();
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTheBestTime() {
        return theBestTime;
    }

    public void setTheBestTime(LocalDateTime theBestTime) {
        this.theBestTime = theBestTime;
    }


}
