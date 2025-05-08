package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.Customer;
import com.udacity.jdnd.course3.critter.data.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PetRepository petRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        // Eagerly load pets for each customer
        customers.forEach(customer -> {
            if (customer.getPets() != null) {
                customer.getPets().size(); // This triggers lazy loading
            }
        });
        return customers;
    }

    public Customer getCustomerByPetId(long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId))
                .getCustomer();
    }

    public Customer getCustomerById(long ownerId) {
        return customerRepository.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + ownerId));
    }

    public Customer addPetToCustomer(Pet pet, Customer customer) {
        customer.getPets().add(pet);
        return customerRepository.save(customer);
    }
}