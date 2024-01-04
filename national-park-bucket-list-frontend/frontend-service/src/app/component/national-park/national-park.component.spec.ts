import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NationalParkComponent } from './national-park.component';

describe('NationalParkComponent', () => {
  let component: NationalParkComponent;
  let fixture: ComponentFixture<NationalParkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NationalParkComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NationalParkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
