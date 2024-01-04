import { TestBed } from '@angular/core/testing';

import { ParkServiceService } from './park-service.service';

describe('ParkServiceService', () => {
  let service: ParkServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParkServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
