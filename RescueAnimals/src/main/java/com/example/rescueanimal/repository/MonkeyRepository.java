package com.example.rescueanimal.repository;

import com.example.rescueanimal.model.Monkey;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MonkeyRepository extends MongoRepository<Monkey, String> {
    List<Monkey> findByReservedFalse();
}