import { TestBed } from '@angular/core/testing';

import { ParkCheckedService } from './park-checked.service';

describe('ParkCheckedService', () => {
  let service: ParkCheckedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParkCheckedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
