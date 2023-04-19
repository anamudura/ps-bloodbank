package com.example.bloodbank.appuser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodtype;
    private int day;
    private int month;
    private int year;

    @ManyToOne
    private Locations locations;

    public Appointment(String bloodtype, int day, int month, int year) {
        this.bloodtype = bloodtype;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
