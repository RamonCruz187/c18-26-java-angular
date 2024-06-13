import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/model/cart-item';
import { Product } from 'src/app/model/product';
import { CartService } from 'src/app/services/cart.service';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  private idProduct: any;
  product: any;
  cartItems: any;



  constructor(private data:HttpServiceService,private route: ActivatedRoute, private cartService: CartService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMAp => {
      this.idProduct=this.route.snapshot.paramMap.get('id')
      console.log(this.idProduct);
      if (this.idProduct){
        this.data.getProduct(this.idProduct).subscribe(data => {
      this.product=data
      console.log(this.product);
          const cartItem:CartItem ={product:this.product,quantity:1};
          this.cartItems=cartItem;
          console.log(this.cartItems);

  });
  
      }
})}

addToCart(): void {
 this.cartService.addToCart(this.cartItems);
 alert("Producto añadido al carrito!");
}




}