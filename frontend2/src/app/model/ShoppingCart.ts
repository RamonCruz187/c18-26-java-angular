import { OrderDetailDto } from "./OrderDetailDto";

export interface ShoppingCart {
    shippingCost: number;
    orderDetailDtos: OrderDetailDto[];
  }