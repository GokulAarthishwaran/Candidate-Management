import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from './../user.service';
import { User } from './../User';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  tempid:number
  tempvid:number
  user:User;
  clone_user : User;

  
  date: Date = new Date(); 
  dd : number = new Date().getDate();
  mm = new Date().getMonth();
  yy = new Date().getFullYear();
  ct: string = "";

  constructor(private s: UserService,private route: Router,private ac: ActivatedRoute)
  { 

    this.ct+=this.yy
    this.ct+="-"
    var mm:number = this.mm
    if( mm < 10)
     {
        this.ct+="0"
     }
    this.ct+=++this.mm;
    this.ct+="-"
    var dd:number =this.dd
     if( dd < 10)
     {
        this.ct+="0"
     }
     this.ct+=dd
    //  console.log(this.ct);

     this.ac.queryParams.subscribe(params => { this.tempid = params.id; this.tempvid = params.vid });
     this.s.view(this.tempid,this.tempvid).subscribe((data : User)=> {console.log(data); this.user=data; this.clone_user = {...this.user}});
     
  }

  ngOnInit(): void {
  }

  submit()
  {
    this.user.updatedUser=localStorage.getItem("name");
    this.user.updateTime=this.ct
    this.s.edit(this.user).subscribe((data)=>{ 
      // console.log(data); 
      this.route.navigate(['search']);
    });
    
  }

  checkDirty()
  {
    if (this.user.contact == this.clone_user.contact && this.user.role == this.clone_user.role && this.user.location == this.clone_user.location && this.user.address == this.clone_user.address && this.user.skill == this.clone_user.skill)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

}
