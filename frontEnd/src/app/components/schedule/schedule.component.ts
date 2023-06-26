import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog, MatDialogClose, MAT_DIALOG_DATA} from '@angular/material/dialog'
import { NewScheduleComponent } from '../new-schedule/new-schedule.component';
import { FlightServiceService } from 'src/app/service/flight-service.service';
import { PriceComponent } from '../price/price.component';
import * as _ from 'lodash';
@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.scss']
})
export class ScheduleComponent implements OnInit {
  currentFlight:any;
  apiResponse: any=[];
  
  constructor(private dialog : MatDialog,private api: FlightServiceService) { }
  currentFlightPrice:any;

  displayedColumns: string[] = ['scheduleId', 'fromCity.cityName', 'toCity.cityName', 'depatureDate','depatureTime','arrivalDate','arrivalTime','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  ngOnInit(): void {
     let flightData:any = localStorage.getItem("currentFlight");
  let currentFlight1:any=JSON.parse(flightData);
  this.currentFlight = JSON.parse(flightData);
      this.getAllSchedule(currentFlight1);
      console.log(currentFlight1);  
  }

  openSchedule(){
    let flightData:any = localStorage.getItem("currentFlight");
    let currentFlight:any=JSON.parse(flightData);
    this.dialog.open(NewScheduleComponent,{
      width:"30%"
    }).afterClosed().subscribe(val=>
      {
        if(val==='save')
        {
          this.getAllSchedule(currentFlight);
        }
      })
  }
  editPrice(){
    let flightData:any = localStorage.getItem("currentFlight");
    let currentFlight:any=JSON.parse(flightData);
    this.dialog.open(PriceComponent,{
      width:"30%"
    }).afterClosed().subscribe(val=>{
      if(val==='save')
      {
        this.getAllSchedule(currentFlight);
      }
    })
  }

  getAllSchedule(flight:any)
  {
    this.api.getSchedule(flight)
    .subscribe({
      next:(res)=>{
        this.dataSource=new MatTableDataSource(res),
        this.dataSource.paginator=this.paginator;
        this.dataSource.sort=this.sort;
      },
      error:(err)=>{
        alert("Error while fetching Data.")
      }
    })
  }
  
  editSchedule(row : any)
  {
    let flightData:any = localStorage.getItem("currentFlight");
    let currentFlight:any=JSON.parse(flightData);
    this.dialog.open(NewScheduleComponent,{
      width:'30%',
      data:row
    }).afterClosed().subscribe(val=>
      {
        if(val==='update')
        {
          this.getAllSchedule(currentFlight);
        }
      })
  }

  deleteSchedule(scheduleId:number)
  {
    let flightData:any = localStorage.getItem("currentFlight");
    let currentFlight:any=JSON.parse(flightData);
    this.api.deleteSchedule(scheduleId)
    .subscribe({
      next:(res)=>{
        alert("Schedule deleted Successfully");
        this.getAllSchedule(currentFlight);
      },
      error:()=>{
        alert("Error while deleting Schedule");
      }
    })
  }
  
  onChange($event:any)
  {
    let filteredData = _.filter(this.apiResponse,(item)=>{
      return item.depatureTime ==$event.value.toLowerCase();
    }
    )
    this.dataSource=new MatTableDataSource(filteredData);
  }
  



  

}
