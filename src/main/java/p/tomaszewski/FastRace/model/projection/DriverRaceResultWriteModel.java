package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.DriverRaceResult;

import java.time.LocalDateTime;

public class DriverRaceResultWriteModel {
    private int place;
    private LocalDateTime time;
    private LocalDateTime theBestTime;

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

    public DriverRaceResult toDriverRaceResult(){
        return new DriverRaceResult(place, time, theBestTime);
    }
}
