import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtAddComponent } from './art-add.component';

describe('ArtAddComponent', () => {
  let component: ArtAddComponent;
  let fixture: ComponentFixture<ArtAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
