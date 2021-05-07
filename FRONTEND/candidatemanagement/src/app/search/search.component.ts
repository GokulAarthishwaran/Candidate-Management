import { Router } from '@angular/router';
import { User } from './../User';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';

declare var $ : any;

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit{

  users: any[];
  p:number=1;
  searchname: string
  temp: any;
  count: number=0;
  data_availability : boolean = false;
  modal_id : any;

  constructor(private s: UserService,private route:Router) { }
 
  ngOnInit()
  {
      this.searchname="";
      this.s.all().subscribe((data:any[])=>this.users=data);
      this.data_availability = true;
  }

  search(f : string)
  {
      this.s.search(f).subscribe((data:any[])=>{
        if(data.length ==1)
        {
          if(data[0].firstName =='empty')
            this.data_availability = false;
          else
          {
            this.users=data;
            this.data_availability = true;
          }
        }
        else
        {
          this.users=data;
          this.data_availability = true;
        }
      });
      // console.log("user is searched with name ",this.users);
     
  }

  delete()
  {
    this.s.delete(this.modal_id).subscribe((data)=>this.temp=data);
    // console.log("user is deleted with id ",this.modal_id);
    window.location.reload();
  }
  
  view(id:number,vid:number)
  {
    this.route.navigate( ["view"], {queryParams: {'id': id ,"vid": vid} } );
  }
  
  openModal(id: number)
  {
    $("#exampleModal").modal("show");
    this.modal_id = id;
  }
  
  closeModal()
  {
    $("#exampleModal").modal("hide");
  }
  
}
