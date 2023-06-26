import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog, MatDialogClose, MAT_DIALOG_DATA} from '@angular/material/dialog'
import { NewFlightComponent } from '../new-flight/new-flight.component';
import { FlightServiceService } from 'src/app/service/flight-service.service';






/**
 * @title Data table with sorting, pagination, and filtering.
 */
@Component({
  selector: 'app-flight-list',
  styleUrls: ['./flight-list.component.scss'],
  templateUrl: './flight-list.component.html',
})
export class FlightListComponent implements OnInit {

 

  openDialog() {
    this.dialog.open(NewFlightComponent, {
      width:'30%'
    }).afterClosed().subscribe(val=>
      {
        if(val==='save')
        {
          this.getAllFlight();
        }
      })
  }

  getAllFlight()
  {
    this.api.getFlight()
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
  editFlight(row : any)
  {
    console.log(row);
    this.dialog.open(NewFlightComponent,{
      width:'30%',
      data:row
    }).afterClosed().subscribe(val=>
      {
        if(val==='update')
        {
          
          this.getAllFlight();
        }
      })
  }

  deleteFlight(flightId:number)
  {
    this.api.deleteFlight(flightId)
    .subscribe({
      next:(res)=>{
        alert("Flight deleted Successfully");
        this.getAllFlight();
      },
      error:()=>{
        alert("Error while deleting flight");
      }
    })
  }


  displayedColumns: string[] = ['company', 'flightNumber','schedule','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog : MatDialog,private api: FlightServiceService) {
    
  
  }
  ngOnInit(): void {
    this.getAllFlight();
  }

  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  navigateToSchedule(flight:any){
   // localStorage.removeItem("currentFlight");
    this.api.setCurrentFlight(flight);
    
  }
}


