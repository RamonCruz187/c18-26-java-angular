/*
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent {
  categoria: any;
  productos: any[] = [];

  constructor(private route: ActivatedRoute, private data:HttpServiceService) { }

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
  }}
*/
import { Component } from '@angular/core';

@Component({
    selector: 'app-catalogo-componente',
    templateUrl: './catalogo.component.html',
    styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent {

    productos: any[] = []; // Asumiendo que tienes una lista de productos en este componente

    comprarProducto(producto: any) {
        // Aquí puedes agregar la lógica para comprar el producto
        console.log('Comprando producto:', producto);
        // Por ejemplo, podrías enviar una solicitud HTTP para realizar la compra
    }
     // Método para verificar si no hay productos disponibles
     noHayProductos(): boolean {
      return this.productos.length === 0;
  }

}