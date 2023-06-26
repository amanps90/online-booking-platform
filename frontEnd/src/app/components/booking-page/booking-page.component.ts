import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-booking-page',
  templateUrl: './booking-page.component.html',
  styleUrls: ['./booking-page.component.scss']
})
export class BookingPageComponent implements OnInit {

  displayedColumns: string[] = ['passengerName', 'gender', 'citizenType', 'class', 'age', 'action'];
  dataSource!: MatTableDataSource<any>;
  currentSchedule = this.api.getSchedule();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog: MatDialog, private api: BookingService) {

  }
  totalFair: number = 0;
  ngOnInit(): void {
    this.getAllPassengers();
    this.totalFair = this.api.getBookingFair();
    this.api.getOffers(this.currentSchedule.flight.company).subscribe(response => {
      this.offerList = response;
    });
  }

  offerList: any = [];

  openDialog() {
    this.dialog.open(DialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val => {
      if (val == 'save') {
        this.getAllPassengers();
        this.totalFair = this.api.getBookingFair();
      }
    })
  }

  getAllPassengers() {
    // this.api.getPassenger().subscribe({
    //   next: (res) => {
    // this.dataSource = new MatTableDataSource(res);
    //     this.dataSource.paginator = this.paginator;
    //     this.dataSource.sort = this.sort;
    //   },
    //   error: (err) => {
    //     alert("Error While Fetching the Record");
    //   }
    // })
    let data = this.api.getPassenger();
    console.log(data);

    this.dataSource = new MatTableDataSource(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }


  applyOffer(offer: any) {
    this.bookingDto.booking.offer = offer;
    this.api.applyDiscount(offer.discount);
    this.totalFair = this.api.getBookingFair();
  }


  deletePassenger(data: any) {
    this.api.deletePassenger(data);
    this.totalFair = this.api.getBookingFair();
    this.getAllPassengers();

  }
  userData: any = localStorage.getItem("userModel");
  user: any = JSON.parse(this.userData);


  bookingDto = {
    "booking": {
      "user": this.user,
      "schedule": this.currentSchedule,
      "finalAmount": 0,
      "offer": null
    },
    "passengerList": this.api.getPassenger()

  }

  confirmBooking() {
    this.bookingDto.booking.finalAmount = this.api.getBookingFair()
    let bookingData = this.bookingDto;
    console.log(bookingData);
    this.api.confirmBooking(bookingData).subscribe(response => {
      console.log(response);
      this.getBookedTickets();
    });
  }

  getBookedTickets() {
    this.api.getbookedTickets();
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
