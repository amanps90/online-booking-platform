import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-verify',
  templateUrl: './verify.component.html',
  styleUrls: ['./verify.component.scss']
})
export class VerifyComponent implements OnInit {
  baseUrl = "http://localhost:8080/"; 
  code:any;
  constructor(private http:HttpClient,private _route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    
  }
  verifyAccount(){
    this._route.queryParams
      .subscribe(params => {
        console.log(params); // { orderby: "price" }
        this.code = params['code'];
        console.log(this.code); // price
        this.http.post<any>(this.baseUrl+"activateAccount",this.code).subscribe(resp=>{
          console.log(resp);
          this.router.navigate(['signin']);
        })
        
      }
    );
  }
}
