package com.udacity.jdnd.course3.critter.data;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@Data
@Table
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String notes;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Pet>pets;

    public void insertPet(Pet pet){
        if(pets==null){
            pets=new ArrayList<>();
        }
        pets.add(pet);
    }
}