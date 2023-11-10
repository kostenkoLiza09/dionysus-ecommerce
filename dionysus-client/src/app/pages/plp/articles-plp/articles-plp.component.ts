import {Component, OnInit} from '@angular/core';
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {Observable} from "rxjs";
import {LiqueurPlpModel} from "../../../models/plp/liqueur-plp.model";
import {PlpService} from "../../../../services/plp.service";
import {Router} from "@angular/router";
import {ArticlesPlpModel} from "../../../models/plp/articles-plp.model";

@Component({
  selector: 'app-articles-plp',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  templateUrl: './articles-plp.component.html',
  styleUrls: ['./articles-plp.component.scss']
})
export class ArticlesPlpComponent implements OnInit {


  ArticlesPlpList$: Observable<ArticlesPlpModel[]> = this._plpService.loadArticles() as Observable<ArticlesPlpModel[]>;
  constructor(private _plpService: PlpService ,  private _router: Router) {
  }
  ngOnInit(): void {

  }

  redirectToArticlesPdp(productId: number): void {
    this._router.navigateByUrl('/pdp-articles/' + productId);
  }
}
