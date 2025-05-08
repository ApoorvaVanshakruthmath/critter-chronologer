package com.udacity.jdnd.course3.critter.data;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection
    private Set<EmployeeSkill> skills;

    @ElementCollection
    @CollectionTable(name = "employee_days_available", joinColumns = @JoinColumn(name = "employee_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private Set<DayOfWeek> daysAvailable;
}