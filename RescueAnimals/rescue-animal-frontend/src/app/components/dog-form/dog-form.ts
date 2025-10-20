
import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Dog } from '../../models/Dog';
import { DogService } from '../../services/dog';

// Component metadata
@Component({
  selector: 'app-dog-form', 
  standalone: true, 
  imports: [ReactiveFormsModule, CommonModule, FormsModule, HttpClientModule], 
  templateUrl: `./dog-form.html`, 
  styleUrls: ['./dog-form.css'], 
  providers: [DogService] 
})
export class DogFormComponent {
  dogForm: FormGroup;
  
  // Predefined breed list shown in dropdown options
  breeds: string[] = [
    'Labrador Retriever',
    'German Shepherd',
    'Golden Retriever',
    'Bulldog',
    'Poodle',
    'Beagle',
    'Rottweiler',
    'Dachshund',
    'Other'
  ];

  // Predefined training options shown in dropdown
  trainingOptions: string[] = [
    'No training',
    'In training',
    'Trained'
  ];

  constructor(private fb: FormBuilder, private dogService: DogService) {
    // Define the structure and default values for the form fields
    this.dogForm = this.fb.group({
      name: [''],
      breed: [''],
      gender: [''],
      age: [0],
      weight: [0],
      acquisitionDate: [''],
      acquisitionLocation: [''],
      trainingStatus: [''],
      reserved: [false],
      inServiceLocation: ['']
    });
  }

  // Function called when the user submits the form
  submit() {
    console.log("Submit clicked"); 
    const newDog: Dog = this.dogForm.value; 

    // Send data to backend using DogService
    this.dogService.addDog(newDog).subscribe({
      next: () => {
        console.log('Dog added successfully');
        alert('Dog added successfully'); 
        this.dogForm.reset(); 
      },
      error: err => console.error('Error adding dog:', err) 
    });
  }
}
