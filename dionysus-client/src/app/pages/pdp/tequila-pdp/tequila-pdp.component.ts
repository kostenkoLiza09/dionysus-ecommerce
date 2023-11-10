import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {WhiskeyPdpModel} from "../../../models/pdp/whiskey-pdp.model";
import {Router} from "@angular/router";
import {PdpService} from "../../../../services/pdp.service";
import {TequilaPdpModel} from "../../../models/pdp/tequila-pdp.model";
import {DeliveryComponent} from "../../../components/delivery/delivery.component";
import {WhiskeyComponentComponent} from "../../../components/mini-plp/whiskey-component/whiskey-component.component";
import {BackgroundComponent} from "../../../components/background/background.component";
import {TequilaComponentComponent} from "../../../components/mini-plp/tequila-component/tequila-component.component";

@Component({
  selector: 'app-tequila-pdp',
  templateUrl: './tequila-pdp.component.html',
  standalone: true,
  imports: [
    CommonModule,
    DeliveryComponent,
    WhiskeyComponentComponent,
    BackgroundComponent,
    TequilaComponentComponent
  ],
  styleUrls: ['./tequila-pdp.component.scss']
})
export class TequilaPdpComponent implements OnInit{

  product?: TequilaPdpModel;
  constructor(private _router: Router, private _pdpService: PdpService) {
  }

  ngOnInit(): void {
    let url: string = this._router.routerState.snapshot.url;
    let productId: string = url.split('/')[2];
    this._pdpService
      .loadProductsTequilaById(productId)
      .subscribe(value => {
        let product: TequilaPdpModel = value as TequilaPdpModel;
        console.log('product', product);
        this.product = product;
      });
  }
}
