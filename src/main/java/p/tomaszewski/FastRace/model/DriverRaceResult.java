package p.tomaszewski.FastRace.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "driverraceresults")
public class DriverRaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int driverId;
    private int raceId;
    private int place;
    private LocalDateTime time;
    private LocalDateTime theBestTime;

    public DriverRaceResult() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
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