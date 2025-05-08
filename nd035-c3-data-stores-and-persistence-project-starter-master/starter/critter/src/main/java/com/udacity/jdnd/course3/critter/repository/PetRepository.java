package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.data.Pet;
import com.udacity.jdnd.course3.critter.pet.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> getAllByCustomerId(Long customerId);
}