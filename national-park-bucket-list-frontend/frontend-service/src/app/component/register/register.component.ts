import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { LoginLogoutService } from 'src/app/services/login-logout.service';
import { MessageService } from 'src/app/services/message.service';
import { ParkCheckedService } from 'src/app/services/park-checked.service';
import { UserService } from 'src/app/services/user.service';
import { nameValidator } from 'src/app/shared/check-special-charactar-validator';
import { passwordValidator } from 'src/app/shared/password-validator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  user = new User();
  msg = ''; 
  // store id of user that is created
  tempId = 0;

  constructor(private fb: FormBuilder, private route: Router, private userService: UserService, private parkCheckedService: ParkCheckedService,
    private loginService: LoginLogoutService, private message: MessageService ) { }

  // validation form for the registration form with their validators
  registrationForm = this.fb.group({
    userName: ['', [Validators.required, Validators.maxLength(30), Validators.minLength(6), nameValidator]],
    password: ['', [Validators.required, Validators.maxLength(30), Validators.minLength(8)]],
    cpassword: ['', [Validators.required, Validators.maxLength(30), Validators.minLength(8)]],
    email: ['', [Validators.required, Validators.email, Validators.maxLength(30), Validators.minLength(12)]]
  }, { validator: passwordValidator});

  ngOnInit(): void {
    this.msg = '';
  }

  // function to register the 'registrationForm' as an account
  // to the database
  registerUser(submitBtn: HTMLButtonElement) {

    // prevents double submitting
    submitBtn.disabled = true;

    // checks if username exists
    //console.log("this username is " + this.account);

    this.userService.registerUser(this.user).subscribe({
      next: (data) => {
        this.tempId = data.id;
        // login the user after creating the user account
        this.loginService.updateCurrentUser(data); 

        this.message.updateMessage('You are now registered.');
      },
      error: (error) => {
        console.log("exeption occurred");
        this.msg = "Account already exists";
      },
      complete: () => {
        //console.log("response received");
        //console.log("tempId is " + this.tempId);
        this.parkCheckedService.postParksChecked(this.tempId).subscribe({
          next: (data) => {
            
          },
          error: (error) => {
            console.log("couldn't post parks checked with user");
            //this.msg = "Account already exists";
          },
          complete: () => {
            
            this.route.navigate(['/success']);
          }
    
        });
        
      }

    });

    // set the disabled of the submit button false
    // so that if register account creation fails
    // user can submit the form again
    submitBtn.disabled = false;
  }

}
