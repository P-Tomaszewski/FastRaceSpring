package p.tomaszewski.FastRace.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

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


    public Driver() {
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

    void setCar(String car) {
        this.car = car;
    }

   public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
