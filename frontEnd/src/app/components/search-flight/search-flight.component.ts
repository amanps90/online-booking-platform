import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { SearchService } from 'src/app/service/search.service';
import { BookingService } from 'src/app/service/booking.service';


@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.scss']
})
export class SearchFlightComponent implements OnInit {


  constructor(private _service:SearchService,private bookingService:BookingService) { }


  ngOnInit(): void {
    this.getAllPassengers();
  }

  displayedColumns: string[] = ['scheduleId', 'flight.flightNumber','flight.company.companyName', 'fromCity.cityName', 'toCity.cityName', 'depatureTime', 'arrivalTime','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  getAllPassengers() {
    this._service.showAllFlights().subscribe(resp=>{
      this.dataSource = new MatTableDataSource(resp);
    console.log(resp);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    })
  }
  bookTicket(schedule:any){
    console.log(schedule);
    this.bookingService.setSchedule(schedule);

  }

}
