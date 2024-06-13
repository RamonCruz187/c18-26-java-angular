/*import { Component } from '@angular/core';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent {

}*/
import { Component } from '@angular/core';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent {
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

