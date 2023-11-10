import {Component, OnInit} from '@angular/core';
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {ProductSearchService} from "../../../services/product-search.service";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {BehaviorSubject, Observable, take} from "rxjs";
import {ProductInfoModel} from "../../models/product-info.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search-component',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf,
    ReactiveFormsModule
  ],
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit{

  private productsSub$ = new BehaviorSubject<ProductInfoModel[]>([]);
  products$: Observable<ProductInfoModel[]> = this.productsSub$.asObservable();

  constructor(private _searchService: ProductSearchService , private _router: Router) {}

  ngOnInit(): void {
    this.queryForm.valueChanges
      .subscribe(value => {
          this._searchService
          .searchProduct(value.query)
          .pipe(
            take(1),
          )
          .subscribe(res => {
            let productInfoModelList: ProductInfoModel[] = res as ProductInfoModel[];
            this.productsSub$.next(productInfoModelList);
          });
      });
  }

  queryForm : FormGroup = new FormGroup( {
    "query": new FormControl()
  })

  navigateToPdp(id: number): void {
    this._router.navigateByUrl('/pdp-wine/' + id);
  }


}
