import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class LoginLogoutService {
  // app will check currentUser to see if id > 0 which means logged in
  private currentUser = new BehaviorSubject<User>({
    id: 0,
    userName: '',
    password: '',
    email: ''
  });

  public share = this.currentUser.asObservable();

  constructor() { }

  updateCurrentUser(user: User) {
    this.currentUser.next(user);
  }
}
