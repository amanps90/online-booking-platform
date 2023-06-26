import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {
  public isLoggedIn: any;
  userData:any = localStorage.getItem("userModel");
  loggedUser = JSON.parse(this.userData);
  constructor(private data: DataService, private router: Router) { }

  ngOnInit(): void {
    this.data.Data.subscribe(result => this.isLoggedIn = result);
    console.log("in nav component");
    console.log(this.loggedUser);

  }
  
  logout() {
    this.data.setData(false)
    this.router.navigate(['home'])
  }
}
