import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Park } from 'src/app/common/park';
import { ParkServiceService } from 'src/app/services/park-service.service';

@Component({
  selector: 'app-national-park',
  templateUrl: './national-park.component.html',
  styleUrls: ['./national-park.component.css']
})
export class NationalParkComponent implements OnInit {
  id!: number;
  park: Park = new Park();
  constructor(private route: ActivatedRoute, private parkService: ParkServiceService) { }
  

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.parkService.getNationalPark(this.id).subscribe(nationalParkData => {
      this.park = nationalParkData;
    })

  }

}
