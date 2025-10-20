
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MonkeyService } from '../../services/monkey';
import { Monkey } from '../../models/Monkey';
import { HttpClientModule } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';

// Component metadata
@Component({
  selector: 'app-monkey-list',
  standalone: true,
  imports: [CommonModule, HttpClientModule, RouterModule],
  templateUrl: './monkey-list.html',
  styleUrls: ['./monkey-list.css'],
  providers: [MonkeyService]
})
export class MonkeyListComponent implements OnInit {

  // Array of monkeys fetched from the backend
  monkeys: Monkey[] = [];

  // Loading and error handling states
  isLoading = true;
  errorMessage = '';

  // Sorting state
  sortColumn: string = '';
  sortDirection: 'asc' | 'desc' = 'asc';

  
  constructor(private monkeyService: MonkeyService, private router: Router) {}

  ngOnInit(): void {
    this.fetchMonkeys();
  }

  // Navigate to the edit page for the selected monkey
  editMonkey(id: string) {
    this.router.navigate(['/edit-monkey', id]);
  }

  // Fetch all monkeys from the backend service
  fetchMonkeys(): void {
    this.monkeyService.getMonkeys().subscribe({
      next: (data) => {
        this.monkeys = data;
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = 'Error fetching monkeys: ' + err.message;
        this.isLoading = false;
      }
    });
  }

  // Delete a monkey after user confirmation
  deleteMonkey(id: string): void {
    if (confirm('Are you sure you want to delete this monkey?')) {
      this.monkeyService.deleteMonkey(id).subscribe(() => {
        this.monkeys = this.monkeys.filter(m => m.id !== id);
      });
    }
  }

  // Sort the table by the specified column
  sortBy(column: string) {
    if (this.sortColumn === column) {
      // Toggle sort direction if same column is clicked
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortColumn = column;
      this.sortDirection = 'asc';
    }

    // Sort array based on column type
    this.monkeys.sort((a, b) => {
      const valA = a[column as keyof Monkey];
      const valB = b[column as keyof Monkey];

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
