import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonkeyListComponent } from './monkey-list';

describe('MonkeyList', () => {
  let component: MonkeyListComponent;
  let fixture: ComponentFixture<MonkeyListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MonkeyListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MonkeyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
