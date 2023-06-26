import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {


  citizenTypeList = ["Child", "Defence Personnel", "Senior Citizen", "Adult"]
  bookingForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, private api: BookingService, private dialog: MatDialogRef<DialogComponent>) { }
  actionBtn: string = "Save"
  ngOnInit(): void {
    this.bookingForm = this.formBuilder.group({
      passengerName: ['', Validators.required],
      gender: ['', Validators.required],
      citizenType: ['', Validators.required],
      class: ['',Validators.required],
      age: ['', Validators.required]
    })
  }

  addPassenger() {
    if (this.bookingForm.valid) {
      //   this.api.postPassenger(this.bookingForm.value).subscribe({
      //     next: (res) => {
      //       alert("Passenger Added Successfully");
      //       this.bookingForm.reset();
      //       this.dialog.close('save');
      //     },
      //     error: () => {
      //       alert("Error While adding the passenger");
      //     }
      //   })
      /*
      data.map((element:any)=>{
        if(element.class==='Economy'){
          this.totalFair = this.totalFair + this.currentSchedule.flight.economyPrice;
        }
        else if(element.class='Business'){
          this.totalFair = this.totalFair + this.currentSchedule.flight.businessPrice;
        }
        else{
          this.totalFair = this.totalFair + this.currentSchedule.flight.premiumPrice;
        }
      }) */
      this.api.postPassenger(this.bookingForm.value);
      // alert("Passenger Added Successfully");
      this.bookingForm.reset();
      this.dialog.close('save');
    }
  }

}
