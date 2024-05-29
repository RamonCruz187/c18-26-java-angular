import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsRoutingModule } from './products-routing.module';
import { ProductDescriptionComponent } from './components/product-description/product-description.component';
import { ProductOverviewPageComponent } from './pages/product-overview-page/product-overview-page.component';


@NgModule({
  declarations: [
    ProductDescriptionComponent,
    ProductOverviewPageComponent
  ],
  imports: [
    CommonModule,
    ProductsRoutingModule
  ]
})
export class ProductsModule { }
