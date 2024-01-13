import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../common/user';
import { LoginLogoutService } from './login-logout.service';

@Injectable({
  providedIn: 'root'
})
export class LoginGuardService implements CanActivate {

  checkUser!: User;
  
  constructor(private router: Router, private loginService: LoginLogoutService) { }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    // subscribe account data into this.checkUser
    this.loginService.share.subscribe(data => this.checkUser = data);
    console.log("checkAccount id is " + this.checkUser.id);
    if (this.checkUser.id > 0) {
      // if this.checkUser.id is greater than zero
      // it means the user is logged in
      return true;
    } else {
      // if user is not logged in navigate to 'NotFoundComponent'
      this.router.navigate(['not-found']);
      return false;
    }
  }
}
