import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ParkListComponent } from './component/park-list/park-list.component';
import { NationalParkComponent } from './component/national-park/national-park.component';
import { LoginComponent } from './component/login/login.component';
import { LogoutComponent } from './component/logout/logout.component';
import { RegisterComponent } from './component/register/register.component';
import { SuccessComponent } from './component/success/success.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ParkCheckedListComponent } from './component/park-checked-list/park-checked-list.component';
import { NotFoundComponent } from './component/not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    ParkListComponent,
    NationalParkComponent,
    LoginComponent,
    LogoutComponent,
    RegisterComponent,
    SuccessComponent,
    ParkCheckedListComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
