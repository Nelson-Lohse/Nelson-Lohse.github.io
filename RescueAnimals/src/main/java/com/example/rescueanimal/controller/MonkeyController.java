package com.example.rescueanimal.controller;

import com.example.rescueanimal.model.Monkey;
import com.example.rescueanimal.service.MonkeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/monkeys") // Base path for monkeys
public class MonkeyController {

    private final MonkeyService monkeyService;

    @Autowired
    public MonkeyController(MonkeyService monkeyService) {
        this.monkeyService = monkeyService;
    }

    // GET all monkeys
    @GetMapping
    public List<Monkey> getAllMonkeys() {
        return monkeyService.getAllMonkeys();
    }

    // POST add a new monkey
    @PostMapping
    public Monkey addMonkey(@RequestBody Monkey monkey) {
        return monkeyService.addMonkey(monkey);
    }

    // POST multiple monkeys at once for database population
    @PostMapping("/addMultiple")
    public List<Monkey> addMonkeys(@RequestBody List<Monkey> monkeys) {
        return monkeyService.addMonkeys(monkeys);
    }

    // PUT – update an existing monkey by ID
    @PutMapping("/{id}")
    public Monkey updateMonkey(@PathVariable String id, @RequestBody Monkey updatedMonkey) {
        return monkeyService.updateMonkey(id, updatedMonkey);
    }

    // DELETE – remove a monkey by ID
    @DeleteMapping("/{id}")
    public void deleteMonkey(@PathVariable String id) {
        monkeyService.deleteMonkey(id);
    }
}