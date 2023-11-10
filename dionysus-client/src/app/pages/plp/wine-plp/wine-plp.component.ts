import {Component, OnInit} from '@angular/core';
import {combineLatest, map, Observable, of} from "rxjs";
import {PlpService} from "../../../../services/plp.service";
import {WinePlpModel} from "../../../models/plp/wine-plp.model";
import {Router} from "@angular/router";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";


@Component({

  selector: 'app-wine-plp',
  templateUrl: './wine-plp.component.html',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./wine-plp.component.scss']
})

export class WinePlpComponent implements OnInit {

  winePlpList$: Observable<WinePlpModel[]> = this._plpService.loadProductsWine() as Observable<WinePlpModel[]>;


  uniqueBrands$: Observable<string[]> = new Observable<string[]>();
  uniqueCountries$: Observable<string[]> = new Observable<string[]>();
  uniqueRegions$: Observable<string[]> = new Observable<string[]>();
  uniqueStyles$: Observable<string[]> = new Observable<string[]>();
  uniqueVarietals$: Observable<string[]> = new Observable<string[]>();

  selectedBrand: string = '';
  selectedCountry: string = '';
  selectedRegion: string = '';
  selectedStyle: string = '';
  selectedVarietal: string = '';

  constructor(private _plpService: PlpService, private _router: Router) {}


  ngOnInit(): void {
    this.uniqueBrands$ = this._plpService.getBrandsWine();
    this.uniqueCountries$ = this._plpService.getCountriesWine();
    this.uniqueRegions$ = this._plpService.getRegionsWine();
    this.uniqueStyles$ = this._plpService.getStylesWine();
    this.uniqueVarietals$ = this._plpService.getVarietalsWine();
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
      case 'varietal':
        this.selectedVarietal = this.selectedVarietal === value ? '' : value;
        break;
      default:
        break;
    }
    this.filterProducts();
  }

  filterProducts(): void {
    combineLatest([
      this._plpService.loadProductsWine(),
      this._plpService.getBrandsWine(),
      this._plpService.getCountriesWine(),
      this._plpService.getRegionsWine(),
      this._plpService.getStylesWine(),
      this._plpService.getVarietalsWine(),
    ]).subscribe(([products, brands, countries, regions, styles, varietals]) => {
      let filteredProducts = products;
      filteredProducts = this._plpService.filterProductsByWine(filteredProducts, 'wineBrandType', this.selectedBrand);
      filteredProducts = this._plpService.filterProductsByWine(filteredProducts, 'countryType', this.selectedCountry);
      filteredProducts = this._plpService.filterProductsByWine(filteredProducts, 'wineRegionType', this.selectedRegion);
      filteredProducts = this._plpService.filterProductsByWine(filteredProducts, 'wineStyleType', this.selectedStyle);
      filteredProducts = this._plpService.filterProductsByWine(filteredProducts, 'wineVarietalType', this.selectedVarietal);

      this.winePlpList$ = of(filteredProducts);
    });
  }

  redirectToWinePdp(productId: number): void {
    this._router.navigateByUrl('/pdp-wine/' + productId);
  }
}
