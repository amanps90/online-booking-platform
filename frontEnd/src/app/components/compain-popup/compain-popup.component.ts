import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DisplayServiceService } from 'src/app/service/display-service.service';

@Component({
  selector: 'app-compain-popup',
  templateUrl: './compain-popup.component.html',
  styleUrls: ['./compain-popup.component.scss']
})
export class CompainPopupComponent implements OnInit {
  actionBtn : string ="Submit"
 complaintForm !: FormGroup;

 constructor(private formBuilder : FormBuilder, private api : DisplayServiceService, @Inject(MAT_DIALOG_DATA) public editData : any, private dialogRef: MatDialogRef<CompainPopupComponent>) { }

  ngOnInit(): void {
    this.complaintForm=this.formBuilder.group({
      complaintDescription:['',Validators.required],
      booking:[this.editData,Validators.required],
      user:[this.editData.user,Validators.required]
    });
  }

  addComplaint(){
    // console.log("Entereted in addComplaint");
    // console.log(this.complaintForm.value+123);
    // console.log(this.editData);
     if(this.complaintForm.valid)
     {
      // console.log("Entereted in ");
       this.api.postComplaint(this.complaintForm.value)
       .subscribe({
         next:(Response)=>{
           alert("Complaint Added Succesfully");
           this.complaintForm.reset();
           this.dialogRef.close('Submit');
         },
         error:()=>
         {
           alert("Error While adding the complaint");
           this.dialogRef.close('Submit');
         }
       })
     }   
   }
}
