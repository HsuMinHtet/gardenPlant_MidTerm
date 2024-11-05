package edu.miu.cs489.midterm.gardenplant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="gardens")
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Double size;
    @OneToMany(mappedBy = "garden")
    private List<Plant> plants= new ArrayList<>();

    public Garden(String name, Double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size + " m2"+
                '}';
    }
}
