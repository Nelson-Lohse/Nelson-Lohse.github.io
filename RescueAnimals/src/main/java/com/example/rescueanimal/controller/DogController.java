package com.example.rescueanimal.controller;

import com.example.rescueanimal.model.Dog;
import com.example.rescueanimal.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dogs") // This is the base path
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    // GET all dogs
    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    // POST add a new dog
    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }
    
 // POST multiple dogs at once for database population
    @PostMapping("/addMultiple")
    public List<Dog> addDogs(@RequestBody List<Dog> dogs) {
        return dogService.addDogs(dogs);
    }
    
 // PUT – update an existing dog by ID
    @PutMapping("/{id}")
    public Dog updateDog(@PathVariable String id, @RequestBody Dog updatedDog) {
        return dogService.updateDog(id, updatedDog);
    }

    // DELETE – remove a dog by ID
    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable String id) {
        dogService.deleteDog(id);
    }
}