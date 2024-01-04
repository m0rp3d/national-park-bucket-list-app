import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ParkListComponent } from './component/park-list/park-list.component';
import { LoginLogoutComponent } from './component/login-logout/login-logout.component';
import { NationalParkComponent } from './component/national-park/national-park.component';

@NgModule({
  declarations: [
    AppComponent,
    ParkListComponent,
    LoginLogoutComponent,
    NationalParkComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
