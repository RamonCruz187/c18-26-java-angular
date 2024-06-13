import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ShoppingCart } from '../model/ShoppingCart';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  private deployUrl = 'https://energetic-hope-production.up.railway.app';
  //private deployUrl = 'http://localhost:8080'

  constructor(private http: HttpClient) { }

  getData(): Observable<any> {
    console.log("elservicio funciona");
    return this.http.get(this.deployUrl+'/products/all');
    

  }

  getCategory(category: any): Observable<any> {
    console.log("elservicio funciona");
    return this.http.get(this.deployUrl+'/products/categoria/'+category);
    

  }

  getProduct(id: number): Observable<any> {
    console.log("Producto funciona");
    return this.http.get(this.deployUrl+'/products/'+id);
    
  }

  newUser(body: any): Observable<any> {
    console.log("Registro funciona");
    return this.http.post(this.deployUrl+'/auth/register',body);
    
  }

  login(body: any): Observable<any> {
    console.log("Login funciona");
    return this.http.post(this.deployUrl+'/auth/login',body);
    
  }

  sendCart(cart: ShoppingCart): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log("Pago funciona");
    return this.http.post(this.deployUrl+'/cart/2',cart, { headers });
    
  }

}
