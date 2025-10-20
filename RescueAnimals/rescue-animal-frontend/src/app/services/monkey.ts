
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Monkey } from '../models/Monkey';

// Service decorator makes this injectable throughout the app
@Injectable({
  providedIn: 'root'
})
export class MonkeyService {
  // Base URL for backend Spring Boot endpoint
  private apiUrl = 'http://localhost:8080/monkeys';

  // HttpClient injected via dependency injection
  constructor(private http: HttpClient) {}

  // Fetch all monkeys
  getMonkeys(): Observable<Monkey[]> {
    return this.http.get<Monkey[]>(this.apiUrl);
  }

  // Add a new monkey
  addMonkey(monkey: Monkey): Observable<Monkey> {
    return this.http.post<Monkey>(this.apiUrl, monkey);
  }

  // Update an existing monkey by ID
  updateMonkey(monkey: Monkey): Observable<Monkey> {
    return this.http.put<Monkey>(`${this.apiUrl}/${monkey.id}`, monkey);
  }

  // Delete a monkey by ID
  deleteMonkey(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
