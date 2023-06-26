import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog, MatDialogClose, MAT_DIALOG_DATA} from '@angular/material/dialog'
import { NewFlightComponent } from '../new-flight/new-flight.component';
import { FlightServiceService } from 'src/app/service/flight-service.service';
import { NewOfferComponent } from '../new-offer/new-offer.component';

@Component({
  selector: 'app-offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.scss']
})
export class OfferListComponent implements OnInit {

  openDialog() {
    this.dialog.open(NewOfferComponent, {
      width:'30%'
    }).afterClosed().subscribe(val=>
      {
        if(val==='save')
        {
          this.getAllOffers();
        }
      })
  }

  getAllOffers()
  {
    this.api.getOffer()
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
  editOffer(row : any)
  {
    console.log(row);
    this.dialog.open(NewOfferComponent,{
      width:'30%',
      data:row
    }).afterClosed().subscribe(val=>
      {
        if(val==='update')
        {
          
          this.getAllOffers();
        }
      })
  }

  deleteOffer(offerId:number)
  {
    this.api.deleteOffer(offerId)
    .subscribe({
      next:(res)=>{
        alert("Offer deleted Successfully");
        this.getAllOffers();
      },
      error:()=>{
        alert("Error while deleting offer");
      }
    })
  }


  displayedColumns: string[] = ['offerId','company', 'discount','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog : MatDialog,private api: FlightServiceService) {
    
  
  }
  ngOnInit(): void {
    this.getAllOffers();
  }

  

 
 
  
}
