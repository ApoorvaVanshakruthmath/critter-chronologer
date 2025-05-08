package com.udacity.jdnd.course3.critter.data;

import com.udacity.jdnd.course3.critter.pet.PetType;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table
@Data
@NoArgsConstructor
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private PetType type;


    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private LocalDate birthDate;

    private String notes;
}
