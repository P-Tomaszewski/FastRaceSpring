package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.Race;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class RaceWriteModel {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surface;
    @NotEmpty
    private LocalDateTime data;
    private Set<DriverRaceResultWriteModel> driverRaceResults;

    public Set<DriverRaceResultWriteModel> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(Set<DriverRaceResultWriteModel> driverRaceResults) {
        this.driverRaceResults = driverRaceResults;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Race toRace(){
        var result = new Race();
        result.setSurface(surface);
        result.setData(data);
        result.setName(name);
        result.setDriverRaceResults(
                driverRaceResults.stream()
                        .map(DriverRaceResultWriteModel::toDriverRaceResult)
                        .collect(Collectors.toSet()));
        return result;
    }
}
