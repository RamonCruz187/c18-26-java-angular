import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/model/cart-item';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cart$ = this.cartService.cart$;
  carrito:any[] =[(this.getCartFromLocalStorage())] ;
  precioTotal:any ;
  
  cartItems: CartItem[] = [];
  
  private getCartFromLocalStorage(): any[] {
    const cart = localStorage.getItem('cart');
    return cart ? JSON.parse(cart) : [];
  }
  
  
  constructor(private cartService: CartService, private router :Router) { }
  
  ngOnInit(): void {
    const items =this.getCartFromLocalStorage();
    this.cartItems=items;


    console.log(this.carrito);
    console.log(this.cartItems);
    console.log(this.getTotalPrice());
  }


  removeFromCart(index: number) {
    this.cartService.removeFromCart(index);
    window.location.reload();
    
  }

  clearCart() {
    this.cartService.clearCart();
  }

  goHome() {
    this.router.navigate(['/']);
    
  }

  getTotalPrice(): number {
    this.precioTotal= this.cartItems.reduce((total, item) => total + item.product.price * item.quantity, 0);
    return this.precioTotal;
  }

  goToPay(){
    this.router.navigate(['/pay']);
  }

  
  }


