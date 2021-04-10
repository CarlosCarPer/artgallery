import { TestBed } from '@angular/core/testing';

import { ArtsService } from './arts.service';

describe('ArtsService', () => {
  let service: ArtsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ArtsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
