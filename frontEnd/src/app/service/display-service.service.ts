import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ComplainDto } from 'src/Utility/complainDto';

@Injectable({
  providedIn: 'root'
})
export class DisplayServiceService {

  
  baseUrl: string="http://localhost:8080";
  userData:any=localStorage.getItem("userModel");
  user=JSON.parse(this.userData);
  constructor(private _http:HttpClient) { }

  getAllComplaints(): Observable<any> {
    return this._http.get<any>(this.baseUrl +'/showAllComplaints');
  }

  postAdminReply(reply:ComplainDto,id:number): Observable<any>{
    console.log(reply);
    console.log("Nikal gaya"+id+reply.reply+reply.status);
    let url = this.baseUrl+'/postAdminReply/'+id;
    console.log(url);
    return this._http.put(url,reply);
  } 

  getAllComplaintsForUser(): Observable<any> {
    return this._http.get<any>(this.baseUrl +'/showComplaintsByUserId/'+this.user.userId);
  }

  getAllBookingsForUser(): Observable<any> {
    console.log(this.user);
    return this._http.get<any>(this.baseUrl +'/showAllBookingByUser/'+this.user.userId);
  }

  
  getProfile(): Observable<any> {
    return this._http.get<any>(this.baseUrl +'/showUserProfile/'+this.user.userId);
  }

  postComplaint(data : any)
  {
    console.log(data)
    console.log("Entereted in postComplaintService");
    return this._http.post<any>(this.baseUrl +'/addComplaint/',data);
  }

  postUserComplaint(reply:ComplainDto,id:number): Observable<any>{
    console.log(reply);
    console.log("Nikal gaya"+id);
    let url = this.baseUrl+'/postAdminReply/'+id;
    console.log(url);
    return this._http.put(url,reply);
  }

  postFeedback(data : any)
  {
    console.log(data)
    console.log("Entereted in postpostFeedback service");
    return this._http.post<any>(this.baseUrl +'/addFeedback/',data);
  }
}
