
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DogService } from '../../services/dog';
import { Dog } from '../../models/Dog';
import { HttpClientModule } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';

// Component metadata
@Component({
  selector: 'app-dog-list',
  standalone: true,
  imports: [CommonModule, HttpClientModule, RouterModule],
  templateUrl: './dog-list.html',
  styleUrls: ['./dog-list.css'],
  providers: [DogService]
})
export class DogListComponent implements OnInit {
  
  // Holds the list of dogs fetched from the backend
  dogs: Dog[] = [];

  // Loading state to show spinner or message
  isLoading = true;
  errorMessage = '';

  // Stores which column is currently sorted
  sortColumn: string = '';
  sortDirection: 'asc' | 'desc' = 'asc';

  constructor(private dogService: DogService, private router: Router) {}

  // Lifecycle hook called after component initialization
  ngOnInit(): void {
    this.fetchDogs();
  }

  // Fetches all dogs from the backend
  fetchDogs(): void {
    this.dogService.getDogs().subscribe({
      next: (data) => {
        this.dogs = data;
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = 'Error fetching dogs: ' + err.message;
        this.isLoading = false;
      }
    });
  }

  // Navigate to the Edit Dog page with the selected dog's ID
  editDog(id: string): void {
    console.log('Edit clicked for dog', id); 
    this.router.navigate(['/edit-dog', id]);
  }

  // Deletes a dog after confirmation
  deleteDog(id: string): void {
    if (confirm('Are you sure you want to delete this dog?')) {
      this.dogService.deleteDog(id).subscribe(() => {
        this.dogs = this.dogs.filter(d => d.id !== id);
      });
    }
  }

  // Sort the dog list by the specified column
  sortBy(column: string) {
    if (this.sortColumn === column) {
      // Toggle sort direction if same column clicked
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      // Set new sort column and default to ascending
      this.sortColumn = column;
      this.sortDirection = 'asc';
    }

    // Sort dogs array based on column type
    this.dogs.sort((a, b) => {
      const valA = a[column as keyof Dog];
      const valB = b[column as keyof Dog];

      if (typeof valA === 'number' && typeof valB === 'number') {
        return this.sortDirection === 'asc' ? valA - valB : valB - valA;
      }

      if (typeof valA === 'boolean' && typeof valB === 'boolean') {
        return this.sortDirection === 'asc'
          ? Number(valA) - Number(valB)
          : Number(valB) - Number(valA);
      }

      if (typeof valA === 'string' && typeof valB === 'string') {
        return this.sortDirection === 'asc'
          ? valA.localeCompare(valB)
          : valB.localeCompare(valA);
      }

      return 0;
    });
  }
}
