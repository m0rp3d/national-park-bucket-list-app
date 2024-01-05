import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/common/user';
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

  constructor(private fb: FormBuilder, private route: Router, private userService: UserService ) { }

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
    this.userService.registerUser(this.user).subscribe(
      data => {
        console.log("response received");

        // update the message that shows up in the SuccessComponent
        //this.passMessage.updateMessage('Account registered successfully');

        // navigate to the 'SuccessComponent'
        this.route.navigate(['/success']);
        
      }, // update this.msg if an error occurs
      error => {
        console.log("exception occured");
        this.msg = "Account already exists";
      }

    )
    // set the disabled of the submit button false
    // so that if register account creation fails
    // user can submit the form again
    submitBtn.disabled = false;
  }

}
