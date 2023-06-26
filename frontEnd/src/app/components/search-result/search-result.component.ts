import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.scss']
})
export class SearchResultComponent implements OnInit{
  example =[ {
    arrivalDate: "2022-04-22",
    arrivalTime: "21:00:00",
    depatureDate: "2022-04-22",
    depatureTime: "19:00:00",
    flight: {flightId: 6, company: {}, flightNumber: 'INDI567', active: false},
    fromCity: {cityId: 1, cityName: 'MUMBAI'},
    scheduleId: 5,
    toCity: {cityId: 2, cityName: 'PUNE'}
  }];

  displayedColumns = ['scheduleId', 'flight.flightNumber','fromCity.cityName','toCity.cityName','depatureTime','arrivalTime'];

  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor( private _searchService: SearchService) { }

  ngOnInit(): void {
    this.getAllPassengers();
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
    this.dataSource = new MatTableDataSource(this.example);
    console.log(this.dataSource);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }


}
