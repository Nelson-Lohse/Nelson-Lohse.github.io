package com.example.rescueanimal.service;

import com.example.rescueanimal.model.Dog;
import com.example.rescueanimal.repository.DogRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service (business logic layer)
public class DogService {
	
    // Reference to the DogRepository (handles database operations)
	private final DogRepository dogRepository;

    // Constructor injection — Spring automatically injects the repository instance
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    
    // Retrieve all dogs from the database.
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

   
    // Add a single new dog to the database.
    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }
    
    // Add multiple dogs to the database in a single operation.
    public List<Dog> addDogs(List<Dog> dogs) {
        return dogRepository.saveAll(dogs);
    }
    
    // Update an existing dog's details by its ID.
    // Finds the dog, updates all fields, and saves it.
    public Dog updateDog(String id, Dog updatedDog) {
        Optional<Dog> existingDog = dogRepository.findById(id);
        if (existingDog.isPresent()) {
            Dog dog = existingDog.get();
            
            // Update all relevant fields
            dog.setName(updatedDog.getName());
            dog.setBreed(updatedDog.getBreed());
            dog.setGender(updatedDog.getGender());
            dog.setAge(updatedDog.getAge());
            dog.setWeight(updatedDog.getWeight());
            dog.setAcquisitionDate(updatedDog.getAcquisitionDate());
            dog.setAcquisitionLocation(updatedDog.getAcquisitionLocation());
            dog.setTrainingStatus(updatedDog.getTrainingStatus());
            dog.setReserved(updatedDog.isReserved());
            dog.setInServiceLocation(updatedDog.getInServiceLocation());
            
            // Save the updated entity back to the database
            return dogRepository.save(dog);
        } else {
            // If no matching dog is found, throw an exception
            throw new RuntimeException("Dog with id " + id + " not found");
        }
    }

    // Delete a dog from the database using its ID.
    public void deleteDog(String id) {
        dogRepository.deleteById(id);
    }
}
