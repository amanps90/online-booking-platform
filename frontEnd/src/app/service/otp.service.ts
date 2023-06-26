import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OtpService {
  baseUrl="http://localhost:8080/";
  count:number =0;
  constructor(private http:HttpClient) { }
  verify(email:string,userOtp:string){
    let otpDto ={
      userEmail: email,
      otp: userOtp
    }
    return this.http.post<any>(this.baseUrl+"verifyOtp",otpDto);
  }
  blockAccount(user:any){
    return this.http.post<any>(this.baseUrl+"blockUser",user);
  }
  unblockAccount(user:any){
    return this.http.post<any>(this.baseUrl+"unblockUser",user);
  }
  getCount(){
    return this.count;
  }

  incrementCountByOne(){
    this.count = this.count+1;
  }

  setCount(data:number){
    this.count = data;
  }

  getAllBlockedUsers(){
    return this.http.get<any>(this.baseUrl+"getAllBlockUsers");
  }
}
