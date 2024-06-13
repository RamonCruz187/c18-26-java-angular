import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderDetailDto } from 'src/app/model/OrderDetailDto';
import { ShoppingCart } from 'src/app/model/ShoppingCart';
import { CartItem } from 'src/app/model/cart-item';
import { CartService } from 'src/app/services/cart.service';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit{
  selectedPaymentMethod: string = '';
  selectedCardType: string = '';
  cardDetails = {
    cardNumber: '',
    cardHolder: '',
    expiryDate: '',
    cvv: '',
    saveCard: false
  };
  savedCards = [
    { icon: 'assets/visa.png', number: 'XXXX-XXXX-XXXX-9010', expiry: '12/28' },
    { icon: 'assets/mastercard.png', number: 'XXXX-XXXX-XXXX-3450', expiry: '11/26' }
  ];
  orderItems = [
    { name: 'Pikachu - Funko x 1', price: 25 },
    { name: 'Caja misteriosa taza x 2', price: 30 },
    { name: 'Envío - Estándar', price: 2 }
  ];

  cart$ = this.cartService.cart$;
  carrito:any[] =[(this.getCartFromLocalStorage())] ;
  precioTotal:any ;
  cartItems: CartItem[] = [];

  private getCartFromLocalStorage(): any[] {
    const cart = localStorage.getItem('cart');
    return cart ? JSON.parse(cart) : [];
  }

  constructor(private cartService: CartService, private router :Router,private httpService: HttpServiceService) { }
  
  ngOnInit(): void {
    const items =this.getCartFromLocalStorage();
    this.cartItems=items;


    console.log(this.carrito);
    console.log(this.cartItems);
    console.log(this.getTotalPrice());
    
    console.log("--------------------------------");
    console.log(this.getCarritoFromLocalStorage())
  }

  getCarritoFromLocalStorage(): ShoppingCart {
    const cart = localStorage.getItem('cart');
    if (cart) {
      const cartItems: CartItem[] = JSON.parse(cart);
  
      const orderDetailDtos: OrderDetailDto[] = cartItems.map(item => ({
        product_id: item.product.id,
        quantity: item.quantity,
        unitPrice: item.product.price
      }));
  
      return {
        shippingCost: 199.99, // Asigna el costo de envío adecuado
        orderDetailDtos: orderDetailDtos
      };
    }
  
    return { shippingCost: 0, orderDetailDtos: [] };
  }

  getTotalPrice(): number {
    this.precioTotal= this.cartItems.reduce((total, item) => total + item.product.price * item.quantity, 0);
    return this.precioTotal;
  }

  sendCartToBackend() {
    const cart = this.getCarritoFromLocalStorage();
       this.httpService.sendCart(cart).subscribe(response => {
      console.log('Carrito enviado con éxito', response);
     
    }, error => {
      console.error('Error al enviar el carrito', error);
      console.log(cart);
    });
  }


  selectPaymentMethod(method: string) {
    this.selectedPaymentMethod = method;
  }

  selectCard(card: any) {
    console.log('Card selected:', card);
  }

  submitCardDetails() {
    // Aquí puedes agregar la lógica para manejar el envío de los detalles de la tarjeta
    console.log(this.cardDetails);
  }

  getTotal() {
    return this.orderItems.reduce((total, item) => total + item.price, 0);
  }
}



  

  

  

  

  

  

  
  


