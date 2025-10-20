package com.example.rescueanimal.repository;

import com.example.rescueanimal.model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DogRepository extends MongoRepository<Dog, String> {
	   List<Dog> findByReservedFalse();
	   List<Dog> findByInServiceLocation(String country);
}
