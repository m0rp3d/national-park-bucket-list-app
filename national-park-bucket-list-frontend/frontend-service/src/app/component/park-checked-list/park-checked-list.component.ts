import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Park } from 'src/app/common/park';
import { Parkchecked } from 'src/app/common/parkchecked';
import { LoginLogoutService } from 'src/app/services/login-logout.service';
import { ParkCheckedService } from 'src/app/services/park-checked.service';

@Component({
  selector: 'app-park-checked-list',
  templateUrl: './park-checked-list.component.html',
  styleUrls: ['./park-checked-list.component.css']
})
export class ParkCheckedListComponent implements OnInit {

  id!: number;

  // create array/list of parkchecked returned using id
  parksChecked: Parkchecked[] = [];

  constructor(private parkCheckedService: ParkCheckedService, private loginService: LoginLogoutService,
    private route: Router) { }

  ngOnInit(): void {
    //getTheId of the signed in account
    this.loginService.share.subscribe(u => this.id = u.id);

    this.parkCheckedService.getParksChecked(this.id).subscribe(data => {
      this.parksChecked = data;
    })
  }

  showPark(id: number) {
    this.route.navigate(['national-park', id]);
  }

  /*
  onSubmit(park: Parkchecked, parkTraveled: string) {
    
    this.parkCheckedService.putParkChecked(parkTraveled, park).subscribe(data => {
      
    });
  }

  */
  
  handle(park: Parkchecked, parkTraveled: string) {
    
    this.parkCheckedService.putParkChecked(parkTraveled, park).subscribe(data => {
      
    });
    //console.log(park.traveled);
  }



}
