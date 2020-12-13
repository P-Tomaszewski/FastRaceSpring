package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverWriteModel {
    private String firstName;
    private String lastName;
    private String team;
    private String car;
    private LocalDateTime overview;
    private Set<DriverRaceResultWriteModel> driverRaceResults;

    public Set<DriverRaceResultWriteModel> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(Set<DriverRaceResultWriteModel> driverRaceResults) {
        this.driverRaceResults = driverRaceResults;
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

    public LocalDateTime getOverview() {
        return overview;
    }

    public void setOverview(LocalDateTime overview) {
        this.overview = overview;
    }

    public Driver toDriver(){
        var result = new Driver();
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setCar(car);
        result.setTeam(team);
        result.setOverview(overview);
        result.setDriverRaceResults(
                driverRaceResults.stream()
                        .map(DriverRaceResultWriteModel::toDriverRaceResult)
                        .collect(Collectors.toSet()));
    return result;
    }
}
