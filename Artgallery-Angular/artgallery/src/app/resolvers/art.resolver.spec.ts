import { TestBed } from '@angular/core/testing';

import { ArtResolver } from './art.resolver';

describe('ArtResolver', () => {
  let resolver: ArtResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(ArtResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
