import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingListForComplaintComponent } from './booking-list-for-complaint.component';

describe('BookingListForComplaintComponent', () => {
  let component: BookingListForComplaintComponent;
  let fixture: ComponentFixture<BookingListForComplaintComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookingListForComplaintComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingListForComplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
