import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../common/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  private userUrl = "http://localhost:8000";

  // get the user using username and password
  getUser(email: string, password: string): Observable<any> {
    return this.httpClient.get<any>(`${this.userUrl}/getuser/${email}/and/${password}`);
  }

  registerUser(user: User): Observable<any> {
    return this.httpClient.post<any>(`${this.userUrl}/user`, user);
  }
}
