import { CallbackComponent } from './callback/callback.component';
import { LoginComponent } from './login/login.component';
import { EditComponent } from './edit/edit.component';
import { TrendsComponent } from './trends/trends.component';
import { ViewComponent } from './view/view.component';
import { CreateComponent } from './create/create.component';
import { SearchComponent } from './search/search.component';
import { HomeComponent } from './home/home.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "./auth.guard";

const routes: Routes = [
  {
    path: 'home', component: HomeComponent, canActivate: [AuthGuard]
  },
  {
    path:'login',component:LoginComponent
  },
  {
    path:'callback',component:CallbackComponent
  },
  {
    path:'search',component: SearchComponent, canActivate: [AuthGuard]
  },
  {
    path:'create',component: CreateComponent
  },
  {
    path:'view',component: ViewComponent
  },
  {
    path:'trends',component: TrendsComponent
  },
  {
    path:'edit',component: EditComponent
  },
  {
    path: '', redirectTo: '/home', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { 


  
}
