package com.example.rescueanimal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "dogs")
public class Dog {
    @Id
    private String id;  // MongoDB unique ID
    private String name;
    private String breed;
    private String gender;
    private int age;
    private double weight;
    private LocalDate acquisitionDate;
    private String acquisitionLocation;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceLocation;

    // Constructors
    public Dog() {}

    public Dog(String name, String breed, String gender, int age, double weight, 
               LocalDate acquisitionDate, String acquisitionLocation, String trainingStatus,
               boolean reserved, String inServiceLocation) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.acquisitionDate = acquisitionDate;
        this.acquisitionLocation = acquisitionLocation;
        this.trainingStatus = trainingStatus;
        this.reserved = reserved;
        this.inServiceLocation = inServiceLocation;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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
}