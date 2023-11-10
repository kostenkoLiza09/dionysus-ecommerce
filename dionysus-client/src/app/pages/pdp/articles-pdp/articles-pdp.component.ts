import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PdpService} from "../../../../services/pdp.service";
import {NgForOf, NgIf} from "@angular/common";
import {ArticlesPdpModel} from "../../../models/pdp/articles-pdp.model";

@Component({
  selector: 'app-articles-pdp',
  standalone: true,
  templateUrl: './articles-pdp.component.html',
  imports: [
    NgForOf,
    NgIf
  ],
  styleUrls: ['./articles-pdp.component.scss']
})
export class ArticlesPdpComponent implements OnInit{

  product?: ArticlesPdpModel;
  constructor(private _router: Router, private _pdpService: PdpService) {
  }

  ngOnInit(): void {
    let url: string = this._router.routerState.snapshot.url;
    let productId: string = url.split('/')[2];
    this._pdpService
      .loadArticlesById(productId)
      .subscribe(value => {
        let product: ArticlesPdpModel = value as ArticlesPdpModel;
        console.log('product', product);
        this.product = product;
      });
  }
}
