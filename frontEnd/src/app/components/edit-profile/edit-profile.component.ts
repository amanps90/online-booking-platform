import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DisplayServiceService } from 'src/app/service/display-service.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {

  profile=
    {
      "userId": null,
      "userName": "",
      "userPassword": "",
      "userEmail": "",
      "userContact": "",
      "gender": "",
      "accountCreationDate": "",
      "active": null,
      "blocked": null,
      "admin": null
  
    };

  constructor(private _displayProfile: DisplayServiceService,private _http:HttpClient) { }

  ngOnInit(): void {

    this._displayProfile.getProfile().subscribe(
      (Response)=>{
        this.profile=Response;
        console.log(this.profile);
      }
    )

    
  }
  // sendReply(reply:string,id:number) :void{
  //   console.log(reply);
  //   this.replydto.reply = reply;
  //   this._displayComplaints.postAdminReply(this.replydto,id).subscribe(resp=>console.log(resp));
  // }
  
}

