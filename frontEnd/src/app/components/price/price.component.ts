import { Component, Inject, OnInit } from '@angular/core';
import {FormControl, FormGroup,FormBuilder,Validators} from '@angular/forms';
import { FlightServiceService } from 'src/app/service/flight-service.service';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-price',
  templateUrl: './price.component.html',
  styleUrls: ['./price.component.scss']
})
export class PriceComponent implements OnInit {
  actionBtn : string ="Save"
  priceForm !: FormGroup;
  flightData:any = localStorage.getItem("currentFlight");
  currentFlight:any=JSON.parse(this.flightData);

  constructor(private formBuilder : FormBuilder, private api : FlightServiceService, @Inject(MAT_DIALOG_DATA) public editData : any, private dialogRef: MatDialogRef<PriceComponent>) { }

  ngOnInit(): void {
    this.priceForm=this.formBuilder.group({
      economyPrice:['',Validators.required],
      businessPrice:['',Validators.required],
      premiumPrice:['',Validators.required],
      flight:[this.currentFlight]
      
    });
    
    if(this.editData)
    {
      this.actionBtn='Update';
      this.priceForm.controls['economyPrice'].setValue(this.editData.economyPrice);
      this.priceForm.controls['businessPrice'].setValue(this.editData.businessPrice);
      this.priceForm.controls['premiumPrice'].setValue(this.editData.premiumPrice);
     
 
    }
  }
  addPrice(){
    if(!this.editData)
    {
     if(this.priceForm.valid)
     {
       this.api.postPrice(this.priceForm.value)
       .subscribe({
         next:(res)=>{
           alert("Price Added Succesfully");
           this.priceForm.reset();
           this.dialogRef.close('save');
         },
         error:()=>
         {
           alert("Error While adding the Price")
         }
       })
      window.location.reload();
     }
    }else{
      this.updatePrice()
    }
   }
   updatePrice()
   {
     this.api.putPrice(this.priceForm.value,this.editData.id)
     .subscribe({
       next:(res:any)=>
       {
         alert("Price Updated");
         this.priceForm.reset();
         this.dialogRef.close('update');
       },
       error:()=>
         {
           alert("Error While updating the Price.");
         }
     })
   }

}
