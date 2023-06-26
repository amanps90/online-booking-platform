import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private data: BehaviorSubject<any> = new  BehaviorSubject(false);

  public get Data(): Observable<any> {
    return this.data.asObservable();
  }

  constructor() { }

  setData(isLoggedIn: any) {
    this.data.next(isLoggedIn);
  }
}
