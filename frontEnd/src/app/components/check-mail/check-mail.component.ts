import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-check-mail',
  templateUrl: './check-mail.component.html',
  styleUrls: ['./check-mail.component.scss']
})
export class CheckMailComponent implements OnInit {

  constructor(private _router:Router) { }

  ngOnInit(): void {
  }
  navigate(){
    this._router.navigate(["signin"]);
  }
}
