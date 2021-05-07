import { Location } from './../Location';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { multi, single } from "./../data";

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css']
})

export class TrendsComponent implements OnInit {

  title = " Trend charts"

  location:any[];
  skill:any[];
  role:any[];
  doj:any[];

  view: any[] = [600, 400];
  xAxis = true;
  yAxis = true;
  gradient = false;
  legend = true;
  showXAxisLabel = true;
  showYAxisLabel = true;
  xAxisLabel1 = 'Locations';
  xAxisLabel2 = 'Skills';
  xAxisLabel3 = 'roles';
  xAxisLabel4 = 'joining year';
  yAxisLabel = 'Number of people';
  timeline = true;
  scheme = { domain: ['red', 'blue', 'black', 'brown', 'yellow', 'green'] };
  showLabels = true;
  
  constructor(private s: UserService)  {}
  
  ngOnInit(): void 
  {
    
    this.s.location().subscribe((trend1:Location[]) => 
    {
         let data1: Location[] =[];     
         for (let i of trend1)
          {
            data1.push({
                "name" : i.name,
                "value" : i.value,
             })
          }
          this.location = data1;
          // console.log("location log is ",this.location);
    });
    
    this.s.skill().subscribe((trend2:Location[]) => 
    {
         let data2: Location[] =[];     
         for (let j of trend2)
          {
            data2.push({
                "name" : j.name,
                "value" : j.value,
             })
          }
          this.skill =data2;
          // console.log("skill log is ",this.skill);
    });

    this.s.role().subscribe((trend3:Location[]) => 
    {
         let data3: Location[] =[];     
         for (let k of trend3)
          {
            data3.push({
                "name" : k.name,
                "value" : k.value,
             })
          }
          this.role =data3;
          // console.log("role log is ",this.role);
    });

    this.s.year().subscribe((trend4:Location[]) => 
    {
         let data4: Location[] =[];     
         for (let l of trend4)
          {
            data4.push({
                "name" : l.name,
                "value" : l.value,
             })
          }
          this.doj =data4;
          // console.log("Joining year log is ",this.doj);
    });

  }

}
