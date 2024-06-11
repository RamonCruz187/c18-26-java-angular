import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  private dataUrl = 'assets/data.json';

  constructor(private http: HttpClient) { }

  getData(): Observable<any> {
    console.log("elservicio funciona");
    return this.http.get('https://energetic-hope-production.up.railway.app/products/all');
    //return this.http.get(this.dataUrl);

  }

  getCategory(category: any): Observable<any> {
    console.log("elservicio funciona");
    return this.http.get('https://energetic-hope-production.up.railway.app/products/categoria/'+category);
    //return this.http.get(this.dataUrl);

  }

  getProduct(id: number): Observable<any> {
    console.log("Producto funciona");
    return this.http.get('https://energetic-hope-production.up.railway.app/products/'+id);
    //return this.http.get(this.dataUrl);
  }

  newUser(body: any): Observable<any> {
    console.log("Registro funciona");
    return this.http.post('https://energetic-hope-production.up.railway.app/auth/register',body);
    //return this.http.get(this.dataUrl);
  }

  login(body: any): Observable<any> {
    console.log("Login funciona");
    return this.http.post('https://energetic-hope-production.up.railway.app/auth/login',body);
    //return this.http.get(this.dataUrl);
  }

}
