import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {WinePdpModel} from "../../../models/pdp/wine-pdp.model";
import {Router} from "@angular/router";
import {PdpService} from "../../../../services/pdp.service";
import {WhiskeyPdpModel} from "../../../models/pdp/whiskey-pdp.model";
import {DeliveryComponent} from "../../../components/delivery/delivery.component";
import {WhiskeyComponentComponent} from "../../../components/mini-plp/whiskey-component/whiskey-component.component";
import {BackgroundComponent} from "../../../components/background/background.component";

@Component({
  selector: 'app-whiskey-pdp',
  templateUrl: './whiskey-pdp.component.html',
  standalone: true,
  imports: [
    CommonModule,
    DeliveryComponent,
    WhiskeyComponentComponent,
    BackgroundComponent
  ],
  styleUrls: ['./whiskey-pdp.component.scss']
})
export class WhiskeyPdpComponent implements OnInit{

  product?: WhiskeyPdpModel;
  constructor(private _router: Router, private _pdpService: PdpService) {
  }

  ngOnInit(): void {
    let url: string = this._router.routerState.snapshot.url;
    let productId: string = url.split('/')[2];
    this._pdpService
      .loadProductsWhiskeyById(productId)
      .subscribe(value => {
        let product: WhiskeyPdpModel = value as WhiskeyPdpModel;
        console.log('product', product);
        this.product = product;
      });
  }
}
