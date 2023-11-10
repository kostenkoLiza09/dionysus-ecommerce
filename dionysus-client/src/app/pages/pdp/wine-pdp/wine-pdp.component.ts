import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PdpService} from "../../../../services/pdp.service";
import {WinePdpModel} from "../../../models/pdp/wine-pdp.model";
import {CommonModule, NgIf} from "@angular/common";
import {BackgroundComponent} from "../../../components/background/background.component";
import {DeliveryComponent} from "../../../components/delivery/delivery.component";
import {WhiskeyComponentComponent} from "../../../components/mini-plp/whiskey-component/whiskey-component.component";
import {WineComponentComponent} from "../../../components/mini-plp/wine-component/wine-component.component";
import {BehaviorSubject, Observable} from "rxjs";
import {defaultProductResultModel, ProductResultModel} from "../../../models/resultProduct";
import {CartService} from "../../../../services/cart.service";

@Component({
  selector: 'app-wine-pdp',
  standalone: true,
  templateUrl: './wine-pdp.component.html',
  imports: [
    CommonModule,
    BackgroundComponent,
    DeliveryComponent,
    WhiskeyComponentComponent,
    WineComponentComponent
  ],
  styleUrls: ['./wine-pdp.component.scss']
})

export class WinePdpComponent implements OnInit{


  private _productResultSub$: BehaviorSubject<ProductResultModel> = new BehaviorSubject<ProductResultModel>(defaultProductResultModel);
  public readonly productResult$: Observable<ProductResultModel> = this._productResultSub$.asObservable();
  product?: WinePdpModel;
  constructor(private _router: Router, private _pdpService: PdpService, private _cartService: CartService) {
  }
  addToCart(): void {
    let url : string =  this._router.routerState.snapshot.url;
    let productId: string = url.split('/')[2];
    this._cartService.addToCart(productId, 1);
    // this.productResult$
    //   .pipe(
    //     switchMap(res => this._cartService.addToCart(productId, 1),
    //     )
    //   .subscribe((res) => {
    //     this._router.navigateByUrl('/cart')
    //   });
  }

ngOnInit(): void {
    let url : string =  this._router.routerState.snapshot.url;
  let productId: string = url.split('/')[2];
  this._pdpService
    .loadProductsWineById(productId)
    .subscribe(value => {
      let product: WinePdpModel = value as WinePdpModel;
      console.log('product',  product);
      this.product = product;
    });
  }
}
