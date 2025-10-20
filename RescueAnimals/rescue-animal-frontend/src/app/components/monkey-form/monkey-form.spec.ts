import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonkeyFormComponent } from './monkey-form';

describe('MonkeyForm', () => {
  let component: MonkeyFormComponent;
  let fixture: ComponentFixture<MonkeyFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MonkeyFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MonkeyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
