import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class FlightServiceService {
  
 

  currentFlight:any={};
  constructor(private http : HttpClient,private _router:Router) { }

  postFlight(data : any)
  {
    console.log(data)
    return this.http.post<any>("http://localhost:8080/addFlight/",data);
  }
  getFlight()
  {
    return this.http.get<any>("http://localhost:8080/showAllFlights/");
  }
  putFlight(data :any,id:number)
  { 
    console.log("id "+id);
    console.log(data);
    return this.http.put<any>("http://localhost:8080/updateFlight/"+id,data)
  }
  deleteFlight(id:number)
  {
    return this.http.delete<any>("http://localhost:8080/removeFlight/"+id);
  }

  postSchedule(data : any)
  {
    console.log(data);
    return this.http.post<any>("http://localhost:8080/addSchedule/",data);
  }
  getSchedule(flight:any)
  {
    return this.http.post<any>("http://localhost:8080/flightSchedule",flight);
  }
  putSchedule(data :any,id:number)
  {
    return this.http.put<any>("http://localhost:8080/updateSchedule/"+id,data)
  }
  deleteSchedule(id:number)
  {
    console.log("id "+id);
    return this.http.delete<any>("http://localhost:8080/removeSchedule/"+id);
  }

  postPrice(data : any)
  {
    console.log(data);
    this.setCurrentFlight(data.flight.flightId);
    return this.http.post<any>("http://localhost:8080/addPrice/",data);
    
  }
  putPrice(data :any,id:number)
  {
    return this.http.put<any>("http://localhost:8080/priceList/"+id,data)
  }

  postOffer(data : any)
  {
    console.log(data)
    return this.http.post<any>("http://localhost:8080/addOffer/",data);
  }
  getOffer()
  {
    return this.http.get<any>("http://localhost:8080/showAllOffers/");
  }
  putOffer(data :any,id:number)
  { 
    console.log("id "+id);
    console.log(data);
    return this.http.put<any>("http://localhost:8080/updateOffer/"+id,data)
  }
  deleteOffer(id:number)
  {
    return this.http.delete<any>("http://localhost:8080/removeOffer/"+id);
  }


  getCompany()
  {
    return this.http.get<any>("http://localhost:8080/getAllCompany/");
  }

  getCity()
  {
    return this.http.get<any>("http://localhost:8080/getAllCity/");
  }
  getCurrentFlight()
  {
    return this.currentFlight;
  }
  setCurrentFlight(flightId:any)
  {
    this.http.get<any>("http://localhost:8080/getCurrentFlight/"+flightId).subscribe(resp=>{
      this.currentFlight = resp;
      console.log(this.currentFlight)
      localStorage.setItem("currentFlight",JSON.stringify(resp));
      localStorage.setItem("flightId",flightId);
      this._router.navigate(["schedule"]);
    }
    );
    
  }
  getFlightFromBackEnd(id:number){
     return this.http.get<any>("http://localhost:8080/getCurrentFlight/"+id);
  }
}
