package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

public class DriverReadModel {
    private int id;
    @NotNull
    private String firstName;
    private String lastName;
    private String team;
    private String car;
    private LocalDateTime overview;
    private Set<DriverRaceResultReadModel> driverRaceResults;

    public DriverReadModel(Driver source) {
        firstName = source.getFirstName();
        lastName = source.getLastName();
        team = source.getTeam();
        car = source.getCar();
        id = source.getId();
//        overview = source.getOverview();
//        source.getDriverRaceResults().stream()
//                .sorted(Comparator.comparing(DriverRaceResult::getTheBestTime))
//                .if
//        driverRaceResults = source.getDriverRaceResults().stream().map(DriverRaceResultReadModel::new)
//                .collect(Collectors
//                        .toSet());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<DriverRaceResultReadModel> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(Set<DriverRaceResultReadModel> driverRaceResults) {
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
}
