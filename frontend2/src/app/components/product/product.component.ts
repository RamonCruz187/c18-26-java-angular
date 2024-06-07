import { Component } from '@angular/core';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  private idProduct: number = 6;
  private product: any;

  constructor(private data:HttpServiceService) { }

  ngOnInit(): void {
    this.data.getProduct(this.idProduct).subscribe(data => {
      this.product=data
      console.log(this.product);
  });

}}