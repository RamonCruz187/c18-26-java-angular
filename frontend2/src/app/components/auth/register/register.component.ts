import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from 'src/app/services/http-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registroForm: FormGroup;

  constructor(private data:HttpServiceService, private fb: FormBuilder) { 
    this.registroForm = this.fb.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  ngOnInit(): void {
  }
  onSubmit() {
    if (this.registroForm.valid) {
      this.data.newUser({
        "name":this.registroForm.value.name,
        "lastName": this.registroForm.value.lastName,
        "email": this.registroForm.value.email,
        "password": this.registroForm.value.password
      }
       
      ).subscribe(data => {
        console.log(this.registroForm.value);
        console.log("registro exitoso");
      })
      //console.log(this.registroForm.value);
    } else {
      console.log('El formulario es inválido');
    }
  }

  

}
