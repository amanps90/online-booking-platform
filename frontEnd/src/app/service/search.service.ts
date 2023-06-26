import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
   baseUrl = "http://localhost:8080/";   
  private searchResult = new Subject<any>();
  formData:any;

  constructor(private _http:HttpClient,private _router:Router) { }
  

  fetchFlights(data:any){
   this._http.post(this.baseUrl+"showAllSearchResult",data).subscribe(resp=>{
    this.searchResult.next(resp);
   });
   console.log("data "+this.searchResult);
  }

  getResult():Observable<any>{
    return this.searchResult.asObservable();
  }

  showAllFlights():Observable<any>{
    return this._http.get(this.baseUrl+"showAllSchedule");
    // console.log("http all"+result);
    // this.searchResult.next(result);
  }
  navigateToSearchFlights(){
    this._router.navigate(["/searchResult"]);
  }
  getFormData(){
    return this.formData;
  }
  setFormData(data:any):any{
    this.formData = data;
    console.log("formdata "+this.formData);
    this.navigateToSearchFlights();
  }
}