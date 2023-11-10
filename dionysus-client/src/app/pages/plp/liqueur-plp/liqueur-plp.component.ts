import {Component, OnInit} from '@angular/core';
import {combineLatest, Observable, of} from "rxjs";
import {RumPlpModel} from "../../../models/plp/rum-plp.model";
import {PlpService} from "../../../../services/plp.service";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {LiqueurPlpModel} from "../../../models/plp/liqueur-plp.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-liqueur-plp',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  templateUrl: './liqueur-plp.component.html',
  styleUrls: ['./liqueur-plp.component.scss']
})
export class LiqueurPlpComponent implements OnInit {

  uniqueBrands$: Observable<string[]> = new Observable<string[]>();
  uniqueCountries$: Observable<string[]> = new Observable<string[]>();
  uniqueRegions$: Observable<string[]> = new Observable<string[]>();
  uniqueStyles$: Observable<string[]> = new Observable<string[]>();


  selectedBrand: string = '';
  selectedCountry: string = '';
  selectedRegion: string = '';
  selectedStyle: string = '';


  liqueurPlpList$: Observable<LiqueurPlpModel[]> = this._plpService.loadProductsLiqueur() as Observable<LiqueurPlpModel[]>;
  constructor(private _plpService: PlpService ,  private _router: Router) {
  }

  ngOnInit(): void {
    this.uniqueBrands$ = this._plpService.getBrandsLiqueur();
    this.uniqueCountries$ = this._plpService.getCountriesLiqueur();
    this.uniqueRegions$ = this._plpService.getRegionsLiqueur();
    this.uniqueStyles$ = this._plpService.getStylesLiqueur();
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
      this._plpService.loadProductsLiqueur(),
      this._plpService.getBrandsLiqueur(),
      this._plpService.getCountriesLiqueur(),
      this._plpService.getRegionsLiqueur(),
      this._plpService.getStylesLiqueur(),
    ]).subscribe(([products, brands, countries, regions, styles, ]) => {
      let filteredProducts = products;
      filteredProducts = this._plpService.filterProductsByLiqueur(filteredProducts, 'liqueurBrandType', this.selectedBrand);
      filteredProducts = this._plpService.filterProductsByLiqueur(filteredProducts, 'countryType', this.selectedCountry);
      filteredProducts = this._plpService.filterProductsByLiqueur(filteredProducts, 'liqueurBrandType', this.selectedRegion);
      filteredProducts = this._plpService.filterProductsByLiqueur(filteredProducts, 'liqueurBrandType', this.selectedStyle);

      this.liqueurPlpList$ = of(filteredProducts);
    });
  }

  redirectToLiqueurPdp(productId: number): void {
    this._router.navigateByUrl('/pdp-liqueur/' + productId);
  }
}
