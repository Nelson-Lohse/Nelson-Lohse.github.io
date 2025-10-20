
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { MonkeyService } from '../../services/monkey';
import { Monkey } from '../../models/Monkey';
import { HttpClientModule } from '@angular/common/http';

// Component metadata
@Component({
  selector: 'app-edit-monkey',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule, HttpClientModule],
  templateUrl: './edit-monkey.html',
  styleUrls: ['./edit-monkey.css'],
  providers: [MonkeyService]
})
export class EditMonkeyComponent implements OnInit {

  // Reactive form to handle monkey editing
  monkeyForm!: FormGroup;

  // Stores the monkey ID from the route
  monkeyId!: string;

  // Predefined species options for dropdown
  speciesList: string[] = [
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

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private monkeyService: MonkeyService
  ) {}

  ngOnInit(): void {
    // Initialize the form with default values
    this.monkeyForm = this.fb.group({
      name: [''],
      species: [''],
      gender: [''],
      age: [''],
      weight: [''],
      height: [''],
      tailLength: [''],
      bodyLength: [''],
      acquisitionDate: [''],
      acquisitionLocation: [''],
      trainingStatus: [''],
      reserved: [''],
      inServiceLocation: ['']
    });

    // Get monkey ID from route
    this.monkeyId = this.route.snapshot.paramMap.get('id')!;

    // Load the existing monkey data into the form
    this.loadMonkey();
  }

  loadMonkey() {
    this.monkeyService.getMonkeys().subscribe(monkeys => {
      const monkey = monkeys.find(m => m.id === this.monkeyId);
      if (monkey) {
        this.monkeyForm.patchValue({
          ...monkey,
          age: monkey.age?.toString(),
          weight: monkey.weight?.toString(),
          reserved: monkey.reserved?.toString()
        });
      }
    });
  }

  // Called when the user submits the form
  onSubmit() {
    const formValue = this.monkeyForm.value;

    // Construct a Monkey object from form values
    const updatedMonkey: Monkey = {
      id: this.monkeyId,
      name: formValue.name!,
      species: formValue.species!,
      gender: formValue.gender!,
      age: Number(formValue.age),
      weight: Number(formValue.weight),
      height: Number(formValue.height),
      tailLength: Number(formValue.tailLength),
      bodyLength: Number(formValue.bodyLength),
      acquisitionDate: formValue.acquisitionDate!,
      acquisitionLocation: formValue.acquisitionLocation!,
      trainingStatus: formValue.trainingStatus!,
      reserved: formValue.reserved === 'true',
      inServiceLocation: formValue.inServiceLocation!
    };

    // Send updated monkey data to the backend
    this.monkeyService.updateMonkey(updatedMonkey).subscribe(() => {
      alert('Monkey updated successfully!');
      this.router.navigate(['/monkeys']); // Navigate back to monkey list
    });
  }
}
