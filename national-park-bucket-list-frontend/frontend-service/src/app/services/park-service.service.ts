import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Park } from '../common/park';

@Injectable({
  providedIn: 'root'
})
export class ParkServiceService {

  // for getting all parks
  private parkUrlAll = "http://localhost:8200/getall/parks";
  private parkUrl = "http://localhost:8200/getparkby/id";

  constructor(private httpClient: HttpClient) { }

  getParksList(): Observable<Park[]>{
    return this.httpClient.get<Park[]>(`${this.parkUrlAll}`);
  }

  getNationalPark(id: number): Observable<Park>{
    return this.httpClient.get<Park>(`${this.parkUrl}/${id}`);
  }
}
