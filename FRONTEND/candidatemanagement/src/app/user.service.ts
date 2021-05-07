import { Location } from './Location';
import { User } from './User';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private http: HttpClient) { }

  url:string = "http://localhost:8089";

  public create(user:User)
  {
     return this.http.post(this.url+"/create",user,{responseType:'text' as 'json'});
  }

  public view(id:number,vid:number)
  {
     return this.http.get(this.url+"/view/"+id+"/"+vid);
  }

  public delete(id:number)
  {
     return this.http.delete(this.url+"/delete/"+id);
  }
  
  public search(firstName:string)
  {
     return this.http.get(this.url+"/search/"+firstName);
  }

  public edit(user:User)
  {
     return this.http.post(this.url+"/edit",user,{responseType:'text' as 'json'});
  }

  public all()
  {
     return this.http.get(this.url+"/all");
  }

  public location()
  {
     return this.http.get(this.url+"/location");
  }

  public skill()
  {
     return this.http.get(this.url+"/skill");
  }

  public role()
  {
     return this.http.get(this.url+"/role");
  }

  public year()
  {
     return this.http.get(this.url+"/year");
  }

}
