import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DisplayServiceService } from 'src/app/service/display-service.service';


@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {
  food = 0; 
  sanitization = 0; 
  hospitality = 0; 
  timing = 0; 

  feedbackForm !: FormGroup;

 constructor(private formBuilder : FormBuilder, private api : DisplayServiceService, @Inject(MAT_DIALOG_DATA) public editData : any, private dialogRef: MatDialogRef<FeedbackComponent>) { }

  ngOnInit(): void {
    this.feedbackForm=this.formBuilder.group({
      // complaintDescription:['',Validators.required],
      // booking:[this.editData,Validators.required],
      // user:[this.editData.user,Validators.required]
      // food:['',Validators.required],
      // hospitality:['',Validators.required],
      // sanitization:['',Validators.required],
      // time:['',Validators.required]
      food :['',Validators.required],
      sanitization :['',Validators.required],
      hospitality  :['',Validators.required],
      timing  :['',Validators.required],

      company :[this.editData.offer.company,Validators.required],
      user : [this.editData.user,Validators.required],
      booking : [this.editData,Validators.required],
    });
  }

  addFeedback(){
     if(this.feedbackForm.valid)
     {
      console.log("Entereted in "+this.feedbackForm.value);
       this.api.postFeedback(this.feedbackForm.value)
       .subscribe({
         next:(Response)=>{
           alert("Feedback Added Succesfully");
           this.feedbackForm.reset();
           this.dialogRef.close('Submit');
         },
         error:()=>
         {
           alert("Error While adding the feedback");
           this.dialogRef.close('Submit');
         }
       })
     }   
   }

}
