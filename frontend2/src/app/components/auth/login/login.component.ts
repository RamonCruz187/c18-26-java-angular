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
  passwordFieldType: string = 'password';

  constructor(private data: HttpServiceService, private fb: FormBuilder) {
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
      }).subscribe(data => {
        console.log(this.loginForm.value);
        console.log("Inicio de sesión exitoso");
        // Aquí puedes manejar la respuesta del servicio (como guardar tokens, redireccionar, etc.)
      });
    } else {
      console.log('El formulario es inválido');
    }
  }

  togglePasswordVisibility() {
    this.passwordFieldType = this.passwordFieldType === 'password' ? 'text' : 'password';
  }

}
