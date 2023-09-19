import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './paginas/login/login.component';
import { UserDashboardComponent } from './paginas/user/user-dashboard/user-dashboard.component';
import { DashboardComponent } from './paginas/admin/dashboard/dashboard.component';
import { AdminGuard } from './servicios/admin.guard';
import { NormalGuard } from './servicios/normal.guard';

const routes: Routes = [

  {
    path : 'login',
    component : LoginComponent,
    pathMatch : 'full'
  },
  {
    path:'user-dashboard',
    component:UserDashboardComponent,
    pathMatch:'full',
    canActivate:[NormalGuard]
  },
  {
    path:'admin',
    component:DashboardComponent,
    pathMatch:'full',
    canActivate:[AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
