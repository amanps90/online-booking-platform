import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { SearchService } from 'src/app/service/search.service';
import { BookingService } from 'src/app/service/booking.service';
import { OtpService } from 'src/app/service/otp.service';

@Component({
  selector: 'app-block-accounts',
  templateUrl: './block-accounts.component.html',
  styleUrls: ['./block-accounts.component.scss']
})
export class BlockAccountsComponent implements OnInit {

  constructor(private otpService:OtpService) { }


  ngOnInit(): void {
    this.getAllBlockedAccounts();
  }

  displayedColumns: string[] = ['userId','userName','userEmail','userContact','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  getAllBlockedAccounts() {
    this.otpService.getAllBlockedUsers().subscribe(resp=>{
      this.dataSource = new MatTableDataSource(resp);
    console.log(resp);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    })
  }
  
  blockUser(user:any){
    this.otpService.unblockAccount(user).subscribe(resp=>{
      console.log(resp);
      this.ngOnInit();
    })
  }

}
