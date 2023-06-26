import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from "@angular/forms"
import { HttpClient } from '@angular/common/http';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
  public invalidCredentials : boolean = false;
  public loginForm !: FormGroup
  private isLoggedIn: any;
   blockText:String = "";

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router, private data: DataService) { }
  
  ngOnInit(): void {
    this.data.Data.subscribe(result => this.isLoggedIn = result)
    this.loginForm = this.formBuilder.group({
      userEmail: ['', Validators.required],
      userPassword: ['', Validators.required]
    })
 

  }
  signin() {
    this.http.post<any>("http://localhost:8080/login", this.loginForm.value)
      .subscribe(res => {
        console.log(res)
        var user: any = res.data;
        localStorage.setItem("OtpUserModel", JSON.stringify(user));
        //var userModel: any = localStorage.getItem("userModel");
        if (res.status == "success") {
          // alert("Login Success!!");
          this.isLoggedIn = true;
          this.data.setData(this.isLoggedIn);
          this.invalidCredentials = false
          this.loginForm.reset();
          if (user.admin) {
            localStorage.setItem("userModel",JSON.stringify(user));
            this.router.navigate(['adminhome'])
          } else if(user.blocked){
            console.log("blocked account");
            this.blockText = "Your account is blocked.Please contact admin."
          }else if(user.active===false){
            this.blockText ="Your email is not verified please check your mail"
          }
          else{
            this.router.navigate(['otp'])
          }
        } else {
          // alert("user not found");
          this.invalidCredentials = true
        }
        
      }, err => {
        alert("Something went wrong!!")
        this.invalidCredentials = false
      }
      )
  }

  
}
