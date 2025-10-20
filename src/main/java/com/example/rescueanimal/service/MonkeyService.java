package com.example.rescueanimal.service;

import com.example.rescueanimal.model.Monkey;
import com.example.rescueanimal.repository.MonkeyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component (used for business logic)
public class MonkeyService {

    // Injects the repository that handles database operations for Monkey objects
    private final MonkeyRepository monkeyRepository;

    // Constructor injection for the MonkeyRepository dependency
    public MonkeyService(MonkeyRepository monkeyRepository) {
        this.monkeyRepository = monkeyRepository;
    }

    // Retrieve all monkeys from the database
    public List<Monkey> getAllMonkeys() {
        return monkeyRepository.findAll();
    }

    // Add a single new monkey to the database
    public Monkey addMonkey(Monkey monkey) {
        return monkeyRepository.save(monkey);
    }

    // Add multiple monkeys to the database at once (bulk insert)
    public List<Monkey> addMonkeys(List<Monkey> monkeys) {
        return monkeyRepository.saveAll(monkeys);
    }

    // Update an existing monkey’s information
    public Monkey updateMonkey(String id, Monkey updatedMonkey) {
        // Try to find the existing monkey in the database by its ID
        Optional<Monkey> existingMonkey = monkeyRepository.findById(id);

        // If found, update all relevant fields
        if (existingMonkey.isPresent()) {
            Monkey monkey = existingMonkey.get();

            // Basic animal information
            monkey.setName(updatedMonkey.getName());
            monkey.setSpecies(updatedMonkey.getSpecies());
            monkey.setGender(updatedMonkey.getGender());
            monkey.setAge(updatedMonkey.getAge());
            monkey.setWeight(updatedMonkey.getWeight());
            monkey.setAcquisitionDate(updatedMonkey.getAcquisitionDate());
            monkey.setAcquisitionLocation(updatedMonkey.getAcquisitionLocation());
            monkey.setTrainingStatus(updatedMonkey.getTrainingStatus());
            monkey.setReserved(updatedMonkey.isReserved());
            monkey.setInServiceLocation(updatedMonkey.getInServiceLocation());

            // Monkey-specific physical characteristics
            monkey.setHeight(updatedMonkey.getHeight());
            monkey.setTailLength(updatedMonkey.getTailLength());
            monkey.setBodyLength(updatedMonkey.getBodyLength());

            // Save and return the updated monkey
            return monkeyRepository.save(monkey);
        } else {
            // If the monkey doesn't exist, throw an error
            throw new RuntimeException("Monkey with id " + id + " not found");
        }
    }

    // Delete a monkey from the database by ID
    public void deleteMonkey(String id) {
        monkeyRepository.deleteById(id);
    }
}
