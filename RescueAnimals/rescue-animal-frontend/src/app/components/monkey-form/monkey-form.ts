
import { Component } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MonkeyService } from '../../services/monkey';
import { Monkey } from '../../models/Monkey';

// Component metadata
@Component({
  selector: 'app-monkey-form',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, CommonModule, HttpClientModule],
  templateUrl: './monkey-form.html',
  styleUrls: ['./monkey-form.css'],
  providers: [MonkeyService]
})
export class MonkeyFormComponent {

  // Reactive form group for monkey form fields
  monkeyForm: FormGroup;

  // Predefined species options for dropdown
  speciesOptions: string[] = [
    "Capuchin", 
    "Guenon", 
    "Macaque", 
    "Marmoset", 
    "Squirrel Monkey", 
    "Tamarin"
  ];
  
  // Predefined training status options
  trainingOptions: string[] = [
    "No training", 
    "In training", 
    "Trained"
  ];

  constructor(private fb: FormBuilder, private monkeyService: MonkeyService) {
    // Initialize reactive form with default values
    this.monkeyForm = this.fb.group({
      name: [''],
      species: [''],
      gender: [''],
      age: [0],
      weight: [0],
      height: [0],
      tailLength: [0],
      bodyLength: [0],
      acquisitionDate: [''],
      acquisitionLocation: [''],
      trainingStatus: [''],
      reserved: [''],
      inServiceLocation: ['']
    });
  }

  // Submit function to send form data to backend
  submit() {
    const newMonkey: Monkey = this.monkeyForm.value;

    // Call service to add monkey
    this.monkeyService.addMonkey(newMonkey).subscribe({
      next: () => {
        console.log('Monkey added successfully');
        alert('Monkey added successfully'); // feedback to user
        this.monkeyForm.reset(); // reset form after submission
      },
      error: err => console.error('Error adding monkey:', err) // error logging
    });
  }
}
 