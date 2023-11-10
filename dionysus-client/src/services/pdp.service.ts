import {Injectable} from "@angular/core";
import {map, Observable} from "rxjs";
import {DataContainer} from "../app/models/data.container";
import {HttpClient} from "@angular/common/http";
import {ProductOrderModel} from "../app/models/baseOrder.model";

@Injectable({
    providedIn: 'root'
  }
)
export class PdpService {

  constructor(private _http: HttpClient) {
  }


  loadProductsWineById(productId: string): Observable<any> {
    return this._http.get('http://localhost:8080/products/wine/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }


  loadProductsLiqueurById(productId: string): Observable<any> {
    return this._http.get('http://localhost:8080/products/liqueur/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
  loadProductsRumById(productId: string): Observable<any> {
    return this._http.get('http://localhost:8080/products/rum/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
  loadProductsTequilaById(productId: string): Observable<any> {
    return this._http.get('http://localhost:8080/products/tequila/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
  loadProductsWhiskeyById(productId: string): Observable<any> {
    return this._http.get('http://localhost:8080/products/whiskey/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
  loadArticlesById(productId: string): Observable<any> {
    return this._http.get('http://localhost:8080/articles/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

}

