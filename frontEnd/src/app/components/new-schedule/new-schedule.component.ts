import { Component, OnInit, Inject } from '@angular/core';
import { FormControl,FormGroup,FormBuilder,Validators} from '@angular/forms';
import { FlightServiceService } from 'src/app/service/flight-service.service';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-new-schedule',
  templateUrl: './new-schedule.component.html',
  styleUrls: ['./new-schedule.component.scss']
})
export class NewScheduleComponent implements OnInit {
  cityData:any;
  actionBtn : string ="Save";
  scheduleForm !: FormGroup;
  currentFlight:any= this.api.getCurrentFlight();
  constructor(private formBuilder : FormBuilder, private api : FlightServiceService, @Inject(MAT_DIALOG_DATA) public editData : any, private dialogRef: MatDialogRef<NewScheduleComponent>) { }

  ngOnInit(): void {

   

    this.scheduleForm=this.formBuilder.group({
      flight:[this.currentFlight],
      fromCity:['',Validators.required],
      toCity:['',Validators.required],
      depatureDate:['',Validators.required],
      depatureTime:['',Validators.required],
      arrivalDate:['',Validators.required],
      arrivalTime:['',Validators.required]
      
    });
  

  if(this.editData)
   {
     this.actionBtn='Update';
     this.scheduleForm.controls['fromCity'].setValue(this.editData.fromCity.cityName);
     this.scheduleForm.controls['toCity'].setValue(this.editData.toCity.cityName);
     this.scheduleForm.controls['depatureDate'].setValue(this.editData.depatureDate);
     this.scheduleForm.controls['depatureTime'].setValue(this.editData.depatureTime);
     this.scheduleForm.controls['arrivalDate'].setValue(this.editData.arrivalDate);
     this.scheduleForm.controls['arrivalTime'].setValue(this.editData.arrivalTime);
   }

   this.api.getCity().subscribe({
    next: (res) => {
      this.cityData = res;
      console.log(this.cityData)
      //this.allCompany=res.companyData

    }
  })
  }

  addSchedule(){
   if(!this.editData)
   {
    if(this.scheduleForm.valid)
    {
      this.api.postSchedule(this.scheduleForm.value)
      .subscribe({
        next:(res)=>{
          console.log(this.scheduleForm.value)
          alert("Schedule Added Succesfully");
          this.scheduleForm.reset();
          this.dialogRef.close('save');
        },
        error:()=>
        {
          alert("Error While adding the schedule")
        }
      })
    }
   }else{
     this.updateSchedule()
   }
  }
  updateSchedule()
  {
    console.log(this.editData.scheduleId)
    this.api.putSchedule(this.scheduleForm.value,this.editData.scheduleId)
    .subscribe({
      next:(res:any)=>
      {
        alert("Schedule Updated Successfully");
        this.scheduleForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>
        {
          alert("Error While updating the schedule details.");
        }
    })
  }

}
