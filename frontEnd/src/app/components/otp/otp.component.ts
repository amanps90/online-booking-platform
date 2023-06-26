import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { OtpService } from 'src/app/service/otp.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.scss']
})
export class OtpComponent implements OnInit {
  otpEnterByUser= new FormControl('');
  error:string="";
  userData:any = localStorage.getItem("OtpUserModel");
  user = JSON.parse(this.userData);
  invalidAttempt:number = this._otpService.getCount();
  constructor(private _router:Router,private _otpService:OtpService) { }

  ngOnInit(): void {
  }
  verifyOtp(){
    let otp = this.otpEnterByUser.value;
    this._otpService.verify(this.user.userEmail,otp).subscribe(resp=>{
      if(resp.msg==="true"){
        console.log(this.invalidAttempt);
      this._otpService.setCount(0);
      //now set actual user to local storage
      localStorage.setItem("userModel",JSON.stringify(this.user));
      localStorage.removeItem("OtpUserModel");
      //api call to clear otp 
      //navigate to homepage 
      console.log("otp good");
      this._router.navigate(["home"]);
      }else{
        this._otpService.incrementCountByOne();
        this.invalidAttempt= this._otpService.getCount();
        console.log(this.invalidAttempt);
        this.error = "invalid otp"
        if(this.invalidAttempt>2){
          this.error = "too many attempt your account has been blocked for 24hrs"
          this._otpService.blockAccount(this.user).subscribe(resp=>{
            console.log(resp);
          })
          document.getElementById("otp")?.setAttribute("disabled","true");
        }
      }
    });
    
  }
  navigate(){
    this._router.navigate(["signin"])
  }
}
