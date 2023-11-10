import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {WhiskeyPdpModel} from "../../../models/pdp/whiskey-pdp.model";
import {Router} from "@angular/router";
import {PdpService} from "../../../../services/pdp.service";
import {LiqueurPdpModel} from "../../../models/pdp/liqueur-pdp.model";
import {BackgroundComponent} from "../../../components/background/background.component";
import {DeliveryComponent} from "../../../components/delivery/delivery.component";
import {WhiskeyComponentComponent} from "../../../components/mini-plp/whiskey-component/whiskey-component.component";
import {WineComponentComponent} from "../../../components/mini-plp/wine-component/wine-component.component";
import {LiqueurComponentComponent} from "../../../components/mini-plp/liqueur-component/liqueur-component.component";

@Component({
  selector: 'app-liqueur-pdp',
  templateUrl: './liqueur-pdp.component.html',
  standalone: true,
  imports: [
    CommonModule,
    BackgroundComponent,
    DeliveryComponent,
    WhiskeyComponentComponent,
    WineComponentComponent,
    LiqueurComponentComponent
  ],
  styleUrls: ['./liqueur-pdp.component.scss']
})
export class LiqueurPdpComponent implements OnInit{

  product?: LiqueurPdpModel;
  constructor(private _router: Router, private _pdpService: PdpService) {
  }

  ngOnInit(): void {
    let url: string = this._router.routerState.snapshot.url;
    let productId: string = url.split('/')[2];
    this._pdpService
      .loadProductsLiqueurById(productId)
      .subscribe(value => {
        let product: LiqueurPdpModel = value as LiqueurPdpModel;
        console.log('product', product);
        this.product = product;
      });
  }
}
