import { UserService } from './../user.service';
import { User } from './../User';
import { Component, OnInit, NgModule } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})

export class CreateComponent implements OnInit {

  date: Date = new Date(); 
  dd : number = new Date().getDate();
  mm = new Date().getMonth();
  yy = new Date().getFullYear();
  ct: string = "";

  user:User = new User(1,1,"","","","","","","","","","","","","","",2021,"","","");

  constructor(private s: UserService,private route: Router)
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
     
  }

  ngOnInit(): void {
  }

  create()
  {
    this.user.createTime=this.ct
    this.s.create(this.user).subscribe((data)=>{
      // console.log(data);
      this.route.navigate(['search']);
    });
    
  }

}
