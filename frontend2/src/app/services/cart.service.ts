import { Injectable } from '@angular/core';
import { CartItem } from '../model/cart-item';
import { BehaviorSubject } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cart = new BehaviorSubject<any[]>(this.getCartFromLocalStorage());
  cart$ = this.cart.asObservable();

  private getCartFromLocalStorage(): any[] {
    const cart = localStorage.getItem('cart');
    return cart ? JSON.parse(cart) : [];
  }

  private saveCartToLocalStorage(cart: any[]) {
    localStorage.setItem('cart', JSON.stringify(cart));
  }

  addToCart(cartItem: CartItem){
    const currentCart = this.cart.value;
    currentCart.push(cartItem);
    this.cart.next(currentCart);
    this.saveCartToLocalStorage(currentCart);
    console.log(currentCart);
  }

  removeFromCart(index: number) {
    const currentCart = this.cart.value;
    currentCart.splice(index, 1);
    this.cart.next(currentCart);
    this.saveCartToLocalStorage(currentCart);
  }

  clearCart() {
    this.cart.next([]);
    localStorage.removeItem('cart');
  }

  

}
