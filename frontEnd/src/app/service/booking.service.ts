import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  passengerList: any = [
  ]
  totalBookingFair: number = 0;
  currentBooking: any = {};
  private scheduleData: any;
  constructor(private http: HttpClient, private _router: Router) { }

  getBookingFair(): number {
    return this.totalBookingFair;
  }
  incrementBookingFair(price: number) {
    this.totalBookingFair = this.totalBookingFair + price;
  }
  resetBookingFair() {
    this.totalBookingFair = 0;
  }
  getbooking() {
    return this.currentBooking;
  }

  getConfirmPassengersByTicket(booking: any) {
    return this.http.post<any>("http://localhost:8080/getPassengerByTickets", booking);
  }

  setbooking(booking: any) {
    this.currentBooking = booking;
  }



  postPassenger(data: any) {
    // return this.http.post<any>("http://localhost:3000/passengerList/", data);
    this.passengerList.push(data);
    console.log(this.scheduleData);
    if (data.class === 'Economy') {
      this.incrementBookingFair(this.scheduleData.flight.economyPrice);
    }
    else if (data.class === 'Business') {
      this.incrementBookingFair(this.scheduleData.flight.businessPrice);

    }
    else {
      this.incrementBookingFair(this.scheduleData.flight.premiumPrice);

    }
    console.log(this.passengerList);

  }
  getPassenger() {
    // return this.http.get<any>("http://localhost:3000/passengerList/");
    return this.passengerList;
  }

  deletePassenger(data: any) {
    // return this.http.delete<any>("http://localhost:3000/passengerList/" + id);
    if (data.class === 'Economy') {
      this.totalBookingFair = this.totalBookingFair - this.scheduleData.flight.economyPrice;
    }
    else if (data.class === 'Business') {
      this.totalBookingFair = this.totalBookingFair - this.scheduleData.flight.businessPrice;

    }
    else {
      this.totalBookingFair = this.totalBookingFair - this.scheduleData.flight.premiumPrice;

    }
    return this.passengerList.splice(this.passengerList.indexOf(data), 1);

  }
  setSchedule(schedule: any): void {
    this.scheduleData = schedule;
    this._router.navigate(["/booking"]);
  }
  confirmBooking(bookingData: any) {
    this.resetPassengerList();
    this.resetBookingFair();
    return this.http.post<any>("http://localhost:8080/addBooking/", bookingData);
  }

  getbookedTickets() {
    this._router.navigate(["/bookingList"]);

  }

  getSchedule() {
    return this.scheduleData;
  }

  resetPassengerList() {
    this.passengerList = [];
  }

  getOffers(company: any) {
    return this.http.post<any>("http://localhost:8080/getOffer", company);
  }

  applyDiscount(discount:number){
    this.totalBookingFair=this.totalBookingFair-((this.totalBookingFair*discount)/100);
  }

}
