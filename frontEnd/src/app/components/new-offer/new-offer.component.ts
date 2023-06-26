import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FlightServiceService } from 'src/app/service/flight-service.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-new-offer',
  templateUrl: './new-offer.component.html',
  styleUrls: ['./new-offer.component.scss']
})
export class NewOfferComponent implements OnInit {

  actionBtn: string = "Save"


  offerForm !: FormGroup;


  constructor(private formBuilder: FormBuilder, private api: FlightServiceService, @Inject(MAT_DIALOG_DATA) public editData: any, private dialogRef: MatDialogRef<NewOfferComponent>) { }

  companyData: any;
  ngOnInit(): void {
    this.offerForm = this.formBuilder.group({
      company: ['', Validators.required],
      discount: ['', Validators.required],
    
    });

    if (this.editData) {
      this.actionBtn = 'Update';
      this.offerForm.controls['company'].setValue(this.editData.company.companyName);
      this.offerForm.controls['discount'].setValue(this.editData.discount);
      

    }
    this.api.getCompany().subscribe({
      next: (res) => {
        this.companyData = res;
        console.log(this.companyData)
        //this.allCompany=res.companyData

      }
    })
  }

  addOffer() {
    if (!this.editData) {
      if (this.offerForm.valid) {

        this.api.postOffer(this.offerForm.value)
          .subscribe({
            next: (res) => {
              alert("Offer Added Succesfully");
              this.offerForm.reset();
              this.dialogRef.close('save');
            },
            error: () => {
              alert("Error While adding the offer")
            }
          })
      }
    } else {
      this.updateOffer()
    }
  }
  updateOffer() {
    console.log(this.editData.offerId);
    this.api.putOffer(this.offerForm.value, this.editData.offerId)
      .subscribe({
        next: (res: any) => {

          alert("Offer Updated.");
          this.offerForm.reset();
          this.dialogRef.close('update');
        },
        error: () => {
          alert("Error While updating the offer details.");
        }
      })
  }

}
