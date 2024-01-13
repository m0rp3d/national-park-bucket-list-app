import { Component } from '@angular/core';
import { User } from './common/user';
import { LoginLogoutService } from './services/login-logout.service';
import { Router } from '@angular/router';
import { MessageService } from './services/message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-service';

  // used to reset user
  
  resetUser: User = {
    id: 0,
    userName: '',
    password: '',
    email: ''
  };

  //resetUser = new User();

  mainUser = new User();

  constructor(private loginService: LoginLogoutService, private route: Router, private message: MessageService) { }

  ngOnInit(): void {
    // if account is logged in
    // account data will be subscribed to mainAccount
    //console.log()
    this.loginService.share.subscribe(u => this.mainUser = u);
  }

  logout(userValue: User) {
    this.loginService.updateCurrentUser(userValue);



    // update the message that shows up in the SuccessComponent
    this.message.updateMessage('You are now logged out.');

    // navigate to SuccessComponent
    this.route.navigate(['/success']);
  }


}
