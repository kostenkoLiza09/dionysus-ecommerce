import {Component, OnInit} from '@angular/core';
import {PlpService} from "../../../../services/plp.service";
import {WhiskeyPlpModel} from "../../../models/plp/whiskey-plp.model";
import {AsyncPipe, JsonPipe, NgForOf, NgIf, NgOptimizedImage} from "@angular/common";
import {combineLatest, Observable, of} from "rxjs";
import {Router} from "@angular/router";



@Component({
  selector: 'app-plp',
  standalone: true,
  templateUrl: './whiskey-plp.component.html',
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./whiskey-plp.component.scss']
})

export class WhiskeyPlpComponent implements OnInit {

  uniqueBrands$: Observable<string[]> = new Observable<string[]>();
  uniqueCountries$: Observable<string[]> = new Observable<string[]>();
  uniqueRegions$: Observable<string[]> = new Observable<string[]>();
  uniqueStyles$: Observable<string[]> = new Observable<string[]>();


  selectedBrand: string = '';
  selectedCountry: string = '';
  selectedRegion: string = '';
  selectedStyle: string = '';



  whiskeyPlpList$: Observable<WhiskeyPlpModel[]> = this._plpService.loadProductsWhiskey() as Observable<WhiskeyPlpModel[]>;


  constructor(private _plpService: PlpService , private _router: Router) {
  }



  ngOnInit(): void {
    this.uniqueBrands$ = this._plpService.getBrandsWhiskey();
    this.uniqueCountries$ = this._plpService.getCountriesWhiskey();
    this.uniqueRegions$ = this._plpService.getRegionsWhiskey();
    this.uniqueStyles$ = this._plpService.getStylesWhiskey();
  }

  onFilterChange(filter: string, value: string): void {
    console.log('Filter:', filter);
    console.log('Value:', value);
    switch (filter) {
      case 'brand':
        this.selectedBrand = this.selectedBrand === value ? '' : value;
        break;
      case 'country':
        this.selectedCountry = this.selectedCountry === value ? '' : value;
        break;
      case 'region':
        this.selectedRegion = this.selectedRegion === value ? '' : value;
        break;
      case 'style':
        this.selectedStyle = this.selectedStyle === value ? '' : value;
        break;
      default:
        break;
    }
    this.filterProducts();
  }
  filterProducts(): void {
    combineLatest([
      this._plpService.loadProductsWhiskey(),
      this._plpService.getBrandsWhiskey(),
      this._plpService.getCountriesWhiskey(),
      this._plpService.getRegionsWhiskey(),
      this._plpService.getStylesWhiskey(),
    ]).subscribe(([products, brands, countries, regions, styles, ]) => {
      let filteredProducts = products;
      filteredProducts = this._plpService.filterProductsByWhiskey(filteredProducts, 'whiskeyBrandType', this.selectedBrand);
      filteredProducts = this._plpService.filterProductsByWhiskey(filteredProducts, 'countryType', this.selectedCountry);
      filteredProducts = this._plpService.filterProductsByWhiskey(filteredProducts, 'whiskeyRegionType', this.selectedRegion);
      filteredProducts = this._plpService.filterProductsByWhiskey(filteredProducts, 'whiskeyStyleType', this.selectedStyle);

      this.whiskeyPlpList$ = of(filteredProducts);
    });
  }
  redirectToWhiskeyPdp(productId: number): void {
    this._router.navigateByUrl('/pdp-whiskey/' + productId);
  }
}
