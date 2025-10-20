package com.example.rescueanimal.service;

import com.example.rescueanimal.model.Monkey;
import com.example.rescueanimal.repository.MonkeyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonkeyService {
    private final MonkeyRepository monkeyRepository;

    public MonkeyService(MonkeyRepository monkeyRepository) {
        this.monkeyRepository = monkeyRepository;
    }

    // Get all monkeys
    public List<Monkey> getAllMonkeys() {
        return monkeyRepository.findAll();
    }

    // Get only available (not reserved) monkeys
    public List<Monkey> getAvailableMonkeys() {
        return monkeyRepository.findByReservedFalse();
    }

    // Add one monkey
    public Monkey addMonkey(Monkey monkey) {
        return monkeyRepository.save(monkey);
    }

    // Add multiple monkeys
    public List<Monkey> addMonkeys(List<Monkey> monkeys) {
        return monkeyRepository.saveAll(monkeys);
    }

    // Update monkey
    public Monkey updateMonkey(String id, Monkey updatedMonkey) {
        Optional<Monkey> existingMonkey = monkeyRepository.findById(id);
        if (existingMonkey.isPresent()) {
            Monkey monkey = existingMonkey.get();
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

            // Monkey-specific fields
            monkey.setHeight(updatedMonkey.getHeight());
            monkey.setTailLength(updatedMonkey.getTailLength());
            monkey.setBodyLength(updatedMonkey.getBodyLength());

            return monkeyRepository.save(monkey);
        } else {
            throw new RuntimeException("Monkey with id " + id + " not found");
        }
    }

    // Delete monkey
    public void deleteMonkey(String id) {
        monkeyRepository.deleteById(id);
    }
}