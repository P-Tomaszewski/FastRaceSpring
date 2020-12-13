package p.tomaszewski.FastRace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String team;
    private String car;
    private LocalDateTime overview;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private Set<DriverRaceResult> driverRaceResults;

    public Driver() {
    }

    public Set<DriverRaceResult> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(Set<DriverRaceResult> driverRaceResults) {
        this.driverRaceResults = driverRaceResults;
    }

    public LocalDateTime getOverview() {
        return overview;
    }

    public Driver(String firstName, String lastName, String team,
                  String car, LocalDateTime overview) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.car = car;
        this.overview = overview;
    }

    public void setOverview(LocalDateTime overview) {
        this.overview = overview;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}