package org.example.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "capitals")
@Getter
@Setter
@NoArgsConstructor
public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double square;

    private long people;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Country country;

    public Capital(String name, double square, long people) {
        this.name = name;
        this.square = square;
        this.people = people;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "name='" + name + '\'' +
                ", square=" + square +
                ", people=" + people +
                '}';
    }
}
