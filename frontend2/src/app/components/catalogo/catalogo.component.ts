
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartItem } from 'src/app/model/cart-item';
import { CartService } from 'src/app/services/cart.service';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent {
  categoria: any;
  productos: any[] = [];
  producto: any;
  cartItems: any;

  constructor(private route: ActivatedRoute, private data:HttpServiceService, private router: Router, private cartService: CartService) { }

  ngOnInit(): void {
    // Recuperar el ID del producto de la ruta
    this.route.paramMap.subscribe(paramMAp => {
    this.categoria = this.route.snapshot.paramMap.get('categoria');
    console.log(this.categoria);
    if (this.categoria){

      this.data.getCategory(this.categoria).subscribe(data => {
        this.productos=data;
      console.log(data);
    
  });
  }
});
  }
  goToProduct(id: any) {
    console.log(id);
    this.router.navigate(['/product', id]);
    
  }

  addToCart(id:number): void {
    this.producto= this.productos.find(p => p.id===id);
    console.log(this.producto);
    const cartItem:CartItem ={product:this.producto,quantity:1};
          this.cartItems=cartItem;
    this.cartService.addToCart(this.cartItems);
    alert("Producto añadido al carrito!");
   }

}
