package p.tomaszewski.FastRace.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String team;
    @NotBlank
    private String car;
    private LocalDateTime overview;


    public Driver() {
    }

    public LocalDateTime getOverview() {
        return overview;
    }

    public void setOverview(LocalDateTime overview) {
        this.overview = overview;
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    void setTeam(String team) {
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