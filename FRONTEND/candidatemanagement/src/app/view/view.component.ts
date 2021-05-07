import { UserService } from './../user.service';
import { User } from './../User';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})

export class ViewComponent implements OnInit {

  tempid:number
  tempvid:number
  user:User

  constructor(private s:UserService, private route:Router, private ac:ActivatedRoute)
  {
    this.ac.queryParams.subscribe(params => { this.tempid = params.id; this.tempvid = params.vid });
    // console.log(this.tempid,this.tempvid);
    this.s.view(this.tempid,this.tempvid).subscribe((data : User)=> {console.log(data); this.user=data;});
  }

  ngOnInit(): void {
      
      
  }

  edit(id:number,vid:number)
  {
    this.route.navigate( ["edit"], {queryParams: {'id':id , "vid":vid } });
  }


}
