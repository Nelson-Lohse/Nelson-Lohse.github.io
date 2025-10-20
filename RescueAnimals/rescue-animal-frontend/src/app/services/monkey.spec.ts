import { TestBed } from '@angular/core/testing';

import { MonkeyService } from './monkey';

describe('Monkey', () => {
  let service: MonkeyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MonkeyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
