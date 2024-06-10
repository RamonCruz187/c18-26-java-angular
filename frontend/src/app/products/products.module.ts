import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsRoutingModule } from './products-routing.module';
import { ProductDescriptionComponent } from './components/product-description/product-description.component';
import { ProductOverviewPageComponent } from './pages/product-overview-page/product-overview-page.component';
import { ProductReviewComponent } from './components/product-review/product-review.component';
import { ProductGalleryComponent } from './components/product-gallery/product-gallery.component';


@NgModule({
  declarations: [
    ProductDescriptionComponent,
    ProductOverviewPageComponent,
    ProductReviewComponent,
    ProductGalleryComponent
  ],
  imports: [
    CommonModule,
    ProductsRoutingModule
  ]
})
export class ProductsModule { }
