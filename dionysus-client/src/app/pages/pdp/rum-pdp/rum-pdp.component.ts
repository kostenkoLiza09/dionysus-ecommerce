import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {WhiskeyPdpModel} from "../../../models/pdp/whiskey-pdp.model";
import {Router} from "@angular/router";
import {PdpService} from "../../../../services/pdp.service";
import {RumPdpModel} from "../../../models/pdp/rum-pdp.model";
import {BackgroundComponent} from "../../../components/background/background.component";
import {DeliveryComponent} from "../../../components/delivery/delivery.component";
import {WhiskeyComponentComponent} from "../../../components/mini-plp/whiskey-component/whiskey-component.component";
import {RumComponentComponent} from "../../../components/mini-plp/rum-component/rum-component.component";

@Component({
  selector: 'app-rum-pdp',
  templateUrl: './rum-pdp.component.html',
  standalone: true,
  imports: [
    CommonModule,
    BackgroundComponent,
    DeliveryComponent,
    WhiskeyComponentComponent,
    RumComponentComponent
  ],
  styleUrls: ['./rum-pdp.component.scss']
})
export class RumPdpComponent implements OnInit{

  product?: RumPdpModel;
  constructor(private _router: Router, private _pdpService: PdpService) {
  }

  ngOnInit(): void {
    let url: string = this._router.routerState.snapshot.url;
    let productId: string = url.split('/')[2];
    this._pdpService
      .loadProductsRumById(productId)
      .subscribe(value => {
        let product: RumPdpModel = value as RumPdpModel;
        console.log('product', product);
        this.product = product;
      });
  }
}
