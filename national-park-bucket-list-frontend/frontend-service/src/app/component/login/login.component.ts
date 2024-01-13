import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { LoginLogoutService } from 'src/app/services/login-logout.service';
import { MessageService } from 'src/app/services/message.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg = "";

  user = new User();

  updatedUser = new User();

  returnable: boolean = false;

  constructor(private formB: FormBuilder, private route: Router, private loginService: LoginLogoutService,
    private userService: UserService, private message: MessageService) { }

  // validation form for the sign in form with validators
  signInForm = this.formB.group({
    email: ['', [Validators.required, Validators.minLength(12), Validators.email, Validators.maxLength(30)]],
    password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(30)]]
  });


  ngOnInit(): void {
  }

  onSubmit() {
    console.log("email is " + this.user.email + " and password is " + this.user.password);

    // http get request function to get account using email and password
    // used to check if user filled signInForm with valid email and password
    this.userService.getUser(this.user.email, this.user.password).subscribe({
      next: (data) => {
        this.updatedUser = data;

        this.loginService.updateCurrentUser(this.updatedUser);

        this.message.updateMessage('You are now logged in.');
      },
      error: (error) => {
        console.log("exeption occurred");
      },
      complete: () => {
        this.route.navigate(['/success']);
      }

    });
  }

  // click function to login the user
  /*
  onSubmit() {
    //console.log("email is " + this.account.email + " and password is " + this.account.password);

    // http get request function to get account using email and password
    // used to check if user filled signInForm with valid email and password
    this.userService.getUser(this.user.email, this.user.password).subscribe(
      data => {
        //console.log("response recieved");
        
        // subscribe account data to this.updatedAccount
        this.updatedUser = data;
        console.log(data.id);

        // use the loginService to show that user is logged in
        this.loginService.updateCurrentUser(this.updatedUser);

        // update the message that shows up in the SuccessComponent
        //this.passMessage.updateMessage('You are now signed in');

        // navigate to SuccessComponent
        this.route.navigate(['/success']);
      }, // response if there is a login error
      error => {
        console.log("exeption occurred");
        this.msg = "Enter valid password and email";
      }
    )
  }

  */
}
