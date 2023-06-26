import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { DatePipe } from '@angular/common';

import axios from 'axios';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})



export class HomeComponent implements OnInit {

  date = new Date();
  dateToday = new Date();

  searchFlightForm = new FormGroup({
    fromCity: new FormControl(""),
    toCity: new FormControl(""),
    doj: new FormControl(),

  })
  constructor(private _searchService: SearchService) { 
    this.dateToday.setDate=this.date.getDate;
  }
  ngOnInit(): void {
  }


  searchFlight() {
    let data = this.searchFlightForm.value;
    console.log(data);
    //this._searchService.fetchFlights(data);
    //this._searchService.showAllFlights();
    this._searchService.setFormData(data);


  }
}
