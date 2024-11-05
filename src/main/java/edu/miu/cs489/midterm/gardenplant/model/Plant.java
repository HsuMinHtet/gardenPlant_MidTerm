package edu.miu.cs489.midterm.gardenplant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String type;
    private LocalDate planDate;
    @ManyToOne
    @JoinColumn(name="garden_id")
    private Garden garden; //->------|--

    public Plant(String name, String type, LocalDate planDate, Garden garden) {
        this.name = name;
        this.type = type;
        this.planDate = planDate;
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", planDate=" + planDate +
                ", garden=" + garden.getName().toString() +
                '}';
    }
}
