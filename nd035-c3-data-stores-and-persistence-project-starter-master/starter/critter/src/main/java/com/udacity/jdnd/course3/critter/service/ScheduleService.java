package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.Employee;
import com.udacity.jdnd.course3.critter.data.Pet;
import com.udacity.jdnd.course3.critter.data.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PetService petService;

    public Schedule saveSchedule(Schedule schedule, List<Long> employeeIds, List<Long> petIds) {
        // Set employees
        List<Employee> employees = employeeIds.stream()
                .map(employeeService::getEmployeeById)
                .collect(Collectors.toList());
        schedule.setEmployees(employees);

        // Set pets
        List<Pet> pets = petIds.stream()
                .map(petService::getPetById)
                .collect(Collectors.toList());
        schedule.setPets(pets);

        return scheduleRepository.save(schedule);

}

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesForPet(long petId) {
        return scheduleRepository.findAllByPetsId(petId);
    }

    public List<Schedule> getSchedulesForEmployee(long employeeId) {
        return scheduleRepository.findAllByEmployeesId(employeeId);
    }

    public List<Schedule> getSchedulesForCustomer(long customerId) {
        return scheduleRepository.findAllByPetsCustomerId(customerId);
    }
}