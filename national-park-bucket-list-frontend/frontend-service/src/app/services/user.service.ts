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
  getUserByUsernameAndPassword(userName: string, password: string): Observable<User> {
    return this.httpClient.get<User>(`${this.userUrl}/getuser/${userName}/and/${password}`);
  }

  registerUser(user: User): Observable<any> {
    return this.httpClient.post<any>(`${this.userUrl}/user`, user);
  }
}
