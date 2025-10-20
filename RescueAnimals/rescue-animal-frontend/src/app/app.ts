import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { DogListComponent } from './components/dog-list/dog-list';
import { DogFormComponent } from './components/dog-form/dog-form';
import { MonkeyListComponent } from './components/monkey-list/monkey-list';
import { MonkeyFormComponent } from './components/monkey-form/monkey-form';
import { NavbarComponent } from './components/navbar/navbar';
import { EditDogComponent } from './components/edit-dog/edit-dog';
import { EditMonkeyComponent } from './components/edit-monkey/edit-monkey';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
	RouterOutlet,
	HttpClientModule,
	ReactiveFormsModule,
	NavbarComponent,
	
  ],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('rescue-animal-frontend');
}
