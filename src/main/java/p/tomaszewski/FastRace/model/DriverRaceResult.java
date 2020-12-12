package p.tomaszewski.FastRace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "driverraceresults")
public class DriverRaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int place;
    private LocalDateTime time;
    private LocalDateTime theBestTime;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;



    public DriverRaceResult() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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