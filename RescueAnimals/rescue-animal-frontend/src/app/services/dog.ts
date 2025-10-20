
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dog } from '../models/Dog';

// Service decorator makes this injectable throughout the app
@Injectable({
  providedIn: 'root'
})
export class DogService {
  // Base URL for backend Spring Boot endpoint
  private apiUrl = 'http://localhost:8080/dogs';

  // HttpClient injected via dependency injection
  constructor(private http: HttpClient) {}

  // Fetch all dogs
  getDogs(): Observable<Dog[]> {
    return this.http.get<Dog[]>(this.apiUrl);
  }

  // Add a new dog
  addDog(dog: Dog): Observable<Dog> {
    return this.http.post<Dog>(this.apiUrl, dog);
  }

  // Update an existing dog by ID
  updateDog(dog: Dog): Observable<Dog> {
    return this.http.put<Dog>(`${this.apiUrl}/${dog.id}`, dog);
  }

  // Delete a dog by ID
  deleteDog(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
