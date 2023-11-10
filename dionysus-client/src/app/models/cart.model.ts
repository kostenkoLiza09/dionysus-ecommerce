import {ProductOrderModel} from "./baseOrder.model";

export interface CartModel {
  created: Date;
  price: string;
  entries: ProductOrderModel[]
}
