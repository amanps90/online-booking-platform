import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DisplayServiceService } from 'src/app/service/display-service.service';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { CompainPopupComponent } from '../compain-popup/compain-popup.component';
import { BookingService } from 'src/app/service/booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-list-for-complaint',
  templateUrl: './booking-list-for-complaint.component.html',
  styleUrls: ['./booking-list-for-complaint.component.scss']
})

export class BookingListForComplaintComponent implements OnInit {

  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog: MatDialog,private router:Router, private passngerService: BookingService, private _displayBookings: DisplayServiceService, private _http: HttpClient) { }

  ngOnInit(): void {
    this._displayBookings.getAllBookingsForUser().subscribe(
      (Response) => {
        this.dataSource = new MatTableDataSource(Response);
        // console.log(Response);
        this.dataSource.paginator = this.paginator;
      }
    )
  }

  displayedColumns: string[] = ['ticketNumber','finalAmount', 'flightNumber', 'viewPassenger', 'source', 'destination', 'Action', 'Feedback'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  createComplaint(row: any) {
    // console.log(row);
    this.dialog.open(CompainPopupComponent, {
      width: '30%',
      data: row
    })
      .afterClosed().subscribe(val => {
        if (val === 'save') {
          this.ngOnInit();
        }
      })
  }

  // deleteComplaint(complaintId:number)
  // {
  //   this.api.deleteComplaint(complaintId)
  //   .subscribe({
  //     next:(res)=>{
  //       alert("Complaint deleted Successfully");
  //       this.getAllFlight();
  //     },
  //     error:()=>{
  //       alert("Error while deleting complaint");
  //     }
  //   })
  // }

  viewPassenger(booking: any) {
    this.passngerService.setbooking(booking);
    this.router.navigate(["bookedTickets"]);
  }
}
