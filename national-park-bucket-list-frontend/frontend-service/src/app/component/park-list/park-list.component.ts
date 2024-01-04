import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Park } from 'src/app/common/park';
import { ParkServiceService } from 'src/app/services/park-service.service';

@Component({
  selector: 'app-park-list',
  templateUrl: './park-list.component.html',
  styleUrls: ['./park-list.component.css']
})
export class ParkListComponent implements OnInit {

  parks: Park[] = [];
  
  constructor(private parkService: ParkServiceService, private route: Router) { }

  ngOnInit(): void {
    this.getParks();
  }

  private getParks() {
    this.parkService.getParksList().subscribe(parksData => {
      this.parks = parksData;
    });
  }

  showPark(id: number) {
    this.route.navigate(['national-park', id]);
  }

}
