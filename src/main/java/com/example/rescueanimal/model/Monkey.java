package com.example.rescueanimal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "monkeys")
public class Monkey {
    @Id
    private String id;  // MongoDB unique ID
    private String name;
    private String species;
    private String gender;
    private int age;
    private double weight;
    private LocalDate acquisitionDate;
    private String acquisitionLocation;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceLocation;

    // Monkey-specific fields
    private int height;       
    private int tailLength;  
    private int bodyLength;   

    // Constructors
    public Monkey() {}

    public Monkey(String name, String species, String gender, int age, double weight,
                  LocalDate acquisitionDate, String acquisitionLocation, String trainingStatus,
                  boolean reserved, String inServiceLocation,
                  int height, int tailLength, int bodyLength) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.acquisitionDate = acquisitionDate;
        this.acquisitionLocation = acquisitionLocation;
        this.trainingStatus = trainingStatus;
        this.reserved = reserved;
        this.inServiceLocation = inServiceLocation;
        this.height = height;
        this.tailLength = tailLength;
        this.bodyLength = bodyLength;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getAcquisitionLocation() {
        return acquisitionLocation;
    }

    public void setAcquisitionLocation(String acquisitionLocation) {
        this.acquisitionLocation = acquisitionLocation;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getInServiceLocation() {
        return inServiceLocation;
    }

    public void setInServiceLocation(String inServiceLocation) {
        this.inServiceLocation = inServiceLocation;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }
}