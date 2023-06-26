import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DisplayServiceService } from 'src/app/service/display-service.service';
import { ComplainDto } from 'src/Utility/complainDto';

@Component({
  selector: 'app-admin-complaints',
  templateUrl: './admin-complaints.component.html',
  styleUrls: ['./admin-complaints.component.scss']
})

export class AdminComplaintsComponent implements OnInit {
  complaints:any;
  replydto:ComplainDto = {
    reply:"",
    status:false
  }

  constructor(private _displayComplaints: DisplayServiceService,private _http:HttpClient) { }

  ngOnInit(): void {
    this._displayComplaints.getAllComplaints().subscribe(
      (Response)=>{
        this.complaints=Response;
        // console.log(this.complaints);
      }
    )
  }

  sendReply(reply:string,id:number,status:boolean) :void{
    // console.log(reply);
    this.replydto.reply = reply;
    this.replydto.status= status;
    this._displayComplaints.postAdminReply(this.replydto,id).subscribe(resp=>console.log(resp));
    window.location.reload();
  }
  
}
