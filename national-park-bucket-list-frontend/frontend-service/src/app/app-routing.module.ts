import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParkListComponent } from './component/park-list/park-list.component';
import { LoginLogoutComponent } from './component/login-logout/login-logout.component';
import { NationalParkComponent } from './component/national-park/national-park.component';

const routes: Routes = [
  {path: 'parks', component: ParkListComponent},
  {path: 'login-logout', component: LoginLogoutComponent},
  {path: 'national-park/:id', component: NationalParkComponent},
  {path: '', redirectTo: 'parks', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
