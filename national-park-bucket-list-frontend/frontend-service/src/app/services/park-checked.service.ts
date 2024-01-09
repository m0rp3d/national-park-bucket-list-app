import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Parkchecked } from '../common/parkchecked';

@Injectable({
  providedIn: 'root'
})
export class ParkCheckedService {

  private parkCheckedUrl = "http://localhost:8100";

  constructor(private httpClient: HttpClient) { }

  empty!: Parkchecked;

  // post requires a body object, even an empty one
  postParksChecked(id: number): Observable<any>{
    return this.httpClient.post<any>(`${this.parkCheckedUrl}/parkschecked/id/${id}`, this.empty);
  }

  getParksChecked(id: number): Observable<Parkchecked[]> {
    return this.httpClient.get<Parkchecked[]>(`${this.parkCheckedUrl}/userId/${id}`);
  }

  putParkChecked(traveled: string, parkchecked: Parkchecked): Observable<Parkchecked[]> {
    return this.httpClient.put<Parkchecked[]>(`${this.parkCheckedUrl}/update/${traveled}`, parkchecked);
  }
  
}
