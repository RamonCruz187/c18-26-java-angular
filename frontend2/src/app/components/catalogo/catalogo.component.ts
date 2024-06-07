import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent {
  product: any;

  constructor(private route: ActivatedRoute, private data:HttpServiceService) { }

  ngOnInit(): void {
    // Recuperar el ID del producto de la ruta
    const categoria = this.route.snapshot.paramMap.get('categoria');
    console.log(categoria);
    this.data.getCategory(categoria).subscribe(data => {
      console.log(data);
  });
  }
}
