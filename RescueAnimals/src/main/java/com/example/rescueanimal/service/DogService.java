package com.example.rescueanimal.service;

import com.example.rescueanimal.model.Dog;
import com.example.rescueanimal.repository.DogRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {
	private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public List<Dog> getAvailableDogs() {
        return dogRepository.findByReservedFalse();
    }

    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }
    
    public List<Dog> addDogs(List<Dog> dogs) {
        return dogRepository.saveAll(dogs);
    }
    
    public Dog updateDog(String id, Dog updatedDog) {
        Optional<Dog> existingDog = dogRepository.findById(id);
        if (existingDog.isPresent()) {
            Dog dog = existingDog.get();
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
            return dogRepository.save(dog);
        } else {
            throw new RuntimeException("Dog with id " + id + " not found");
        }
    }

    public void deleteDog(String id) {
        dogRepository.deleteById(id);
    }
}
