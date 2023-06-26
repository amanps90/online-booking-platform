import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  
   public signupForm !: FormGroup;

  constructor(private formBulider : FormBuilder, private http : HttpClient, private router:Router) { }
  ngOnInit(): void {
    this.signupForm = this.formBulider.group({
      userName:['',Validators.required], //^(?=.*\d)(?=.*[a-zA-Z]).{4,8}$
      /*This will check for text string to have atleast one Numeric and one Character and the  length of text string to be 
      between 4 to 8 characters. */
      userEmail:['',[Validators.email,Validators.required]],
      userPassword:['',Validators.required],
      confirmPassword:['',Validators.required],
      userContact:['',[Validators.minLength(10),Validators.required]]
    })
  }
  signup(){
    this.http.post<any>("http://localhost:8080/addUser",this.signupForm.value)
    .subscribe(res=>{
      // alert("signup successfull");
      this.signupForm.reset();
      this.router.navigate(['checkMail']);
    },err=> {
      alert("Something went wrong please try again!")
    }
      )
  }
}
