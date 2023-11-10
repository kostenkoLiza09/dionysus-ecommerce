import { Component } from '@angular/core';
import {Observable} from "rxjs";
import {CartModel} from "../../models/cart.model";
import {CartService} from "../../../services/cart.service";
import {AsyncPipe, DatePipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-cart',
  standalone: true,
  templateUrl: './cart.component.html',
  imports: [
    AsyncPipe,
    NgIf,
    DatePipe,
    NgForOf
  ],
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {

  cart$: Observable<CartModel> = this._cartService.loadCart();

  constructor(private _cartService: CartService) {
  }
}
