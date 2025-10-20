import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, Routes } from '@angular/router';
import { App } from './app/app';
import { appConfig } from './app/app.config';

// Import all components
import { DogListComponent } from './app/components/dog-list/dog-list';
import { DogFormComponent } from './app/components/dog-form/dog-form';
import { EditDogComponent } from './app/components/edit-dog/edit-dog';
import { MonkeyListComponent } from './app/components/monkey-list/monkey-list';
import { MonkeyFormComponent } from './app/components/monkey-form/monkey-form';
import { EditMonkeyComponent } from './app/components/edit-monkey/edit-monkey';

// Application routes
const routes: Routes = [
  { path: 'dogs', component: DogListComponent },
  { path: 'add-dog', component: DogFormComponent },
  { path: 'edit-dog/:id', component: EditDogComponent },
  { path: 'monkeys', component: MonkeyListComponent },
  { path: 'add-monkey', component: MonkeyFormComponent },
  { path: 'edit-monkey/:id', component: EditMonkeyComponent },
  { path: '', redirectTo: '/dogs', pathMatch: 'full' } // default route
];

// Bootstrap Angular application with router
bootstrapApplication(App, {
  providers: [provideRouter(routes)]
}).catch((err) => console.error(err));
