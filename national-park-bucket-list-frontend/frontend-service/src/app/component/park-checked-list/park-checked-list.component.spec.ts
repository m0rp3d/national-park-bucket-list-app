import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkCheckedListComponent } from './park-checked-list.component';

describe('ParkCheckedListComponent', () => {
  let component: ParkCheckedListComponent;
  let fixture: ComponentFixture<ParkCheckedListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkCheckedListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParkCheckedListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
