
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { DogService } from '../../services/dog';
import { Dog } from '../../models/Dog';
import { HttpClientModule } from '@angular/common/http';

// Component metadata
@Component({
  selector: 'app-edit-dog',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule, HttpClientModule],
  templateUrl: './edit-dog.html',
  styleUrls: ['./edit-dog.css'],
  providers: [DogService]
})
export class EditDogComponent implements OnInit {
  
  // Reactive form to handle the dog editing form
  dogForm!: FormGroup;

  // Stores the dog ID from the route parameter
  dogId!: string;
  
  // Predefined breed options for dropdown
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

  // Predefined training status options for dropdown
  trainingOptions: string[] = [
    'No training',
    'In training',
    'Trained'
  ];

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private dogService: DogService
  ) {}

  ngOnInit(): void {
    // Initialize the form with default values
    this.dogForm = this.fb.group({
      name: [''],
      breed: [''],
      gender: [''],
      age: [''],
      weight: [''],
      acquisitionDate: [''],
      acquisitionLocation: [''],
      trainingStatus: [''],
      reserved: [''],
      inServiceLocation: ['']
    });

    // Get dog ID from the route parameter
    this.dogId = this.route.snapshot.paramMap.get('id')!;
    
    // Load the existing dog data into the form
    this.loadDog();
  }

  loadDog() {
    this.dogService.getDogs().subscribe((dogs: Dog[]) => {
      const dog = dogs.find(d => d.id === this.dogId);
      if (dog) {
        this.dogForm.patchValue({
          ...dog,
          age: dog.age?.toString(),
          weight: dog.weight?.toString(),
          reserved: dog.reserved?.toString()
        });
      }
    });
  }

  // Called when the user submits the form
  onSubmit() {
    const formValue = this.dogForm.value;

    // Construct a Dog object from form values
    const updatedDog: Dog = {
      id: this.dogId,
      name: formValue.name!,
      breed: formValue.breed!,
      gender: formValue.gender!,
      age: Number(formValue.age),
      weight: Number(formValue.weight),
      acquisitionDate: formValue.acquisitionDate!,
      acquisitionLocation: formValue.acquisitionLocation!,
      trainingStatus: formValue.trainingStatus!,
      reserved: formValue.reserved === 'true',
      inServiceLocation: formValue.inServiceLocation!
    };

    // Send updated dog data to the backend
    this.dogService.updateDog(updatedDog).subscribe(() => {
      alert('Dog updated successfully!');
      this.router.navigate(['/dogs']); // Navigate back to dog list
    });
  }
}
