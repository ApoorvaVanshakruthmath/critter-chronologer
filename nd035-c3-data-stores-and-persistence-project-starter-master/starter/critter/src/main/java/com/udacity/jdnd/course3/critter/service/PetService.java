package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.Customer;
import com.udacity.jdnd.course3.critter.data.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(long ownerId) {
        return petRepository.getAllByCustomerId(ownerId);
    }

    public Pet getPetById(long petId) {
        Optional<Pet> petOptional = petRepository.findById(petId);
        if (petOptional.isEmpty()) {
            throw new IllegalArgumentException("Pet not found with ID: " + petId);
        }
        return petOptional.get();
    }

    public Pet savePet(Pet pet) {
        Customer customer = pet.getCustomer();

        if (customer == null || customer.getId() == null) {
            throw new IllegalArgumentException("Owner information is required to save pet.");
        }

        Customer owner = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customer.getId()));

        pet.setCustomer(owner);
        Pet savedPet = petRepository.save(pet);

        owner.insertPet(savedPet);
        customerRepository.save(owner);

        return savedPet;
    }
}
