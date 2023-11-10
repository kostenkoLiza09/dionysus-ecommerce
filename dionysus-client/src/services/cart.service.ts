import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataContainer} from "../app/models/data.container";
import {CartModel} from "../app/models/cart.model";


@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private _http: HttpClient) {
  }

  loadCart(): Observable<CartModel> {
    return this._http.get('http://localhost:8080/cart')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  addToCart(productId: string, quantity: number): Observable<boolean> {
    return this._http.post('http://localhost:8080/cart', { productId, quantity })
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
