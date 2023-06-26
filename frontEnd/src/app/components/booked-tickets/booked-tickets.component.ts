import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-booked-tickets',
  templateUrl: './booked-tickets.component.html',
  styleUrls: ['./booked-tickets.component.scss']
})
export class BookedTicketsComponent implements OnInit {

  constructor(private booking: BookingService) { }
  currentBooking: any;
  confirmPassengers: any = [];
  ngOnInit(): void {
    this.currentBooking = this.booking.getbooking();
    this.booking.getConfirmPassengersByTicket(this.currentBooking).subscribe(response => {
      this.confirmPassengers = response;
      console.log(this.confirmPassengers);
    })
  }

}
