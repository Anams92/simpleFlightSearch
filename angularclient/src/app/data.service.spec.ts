import { TestBed, inject } from '@angular/core/testing';

import { FlightSearchService } from './data.service';

describe('DataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FlightSearchService]
    });
  });

  it('should be created', inject([FlightSearchService], (service: FlightSearchService) => {
    expect(service).toBeTruthy();
  }));
});
