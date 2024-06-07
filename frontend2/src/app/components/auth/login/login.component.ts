import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  token: any;
  user: any;

  constructor(private data:HttpServiceService, private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });

   }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.loginForm.valid) {
      this.data.login({
        "email": this.loginForm.value.email,
        "password": this.loginForm.value.password
      }
       
      ).subscribe(data => {
        this.token=data.jwt;
        this.user=data.user;
        console.log(this.loginForm.value);
        console.log(this.token);
        console.log(this.user);
        console.log("registro exitoso");
      })
      //console.log(this.loginForm.value);  // Aquí obtenemos solo los valores del formulario
    } else {
      console.log('El formulario es inválido');
    }
  }

}
