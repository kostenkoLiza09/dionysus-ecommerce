import {Component, OnInit} from '@angular/core';
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {combineLatest, Observable, of} from "rxjs";
import {PlpService} from "../../../../services/plp.service";
import {RumPlpModel} from "../../../models/plp/rum-plp.model";
import {WinePlpComponent} from "../wine-plp/wine-plp.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-rum-plp',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf,
    WinePlpComponent
  ],
  templateUrl: './rum-plp.component.html',
  styleUrls: ['./rum-plp.component.scss']
})
export class RumPlpComponent implements OnInit {


  uniqueBrands$: Observable<string[]> = new Observable<string[]>();
  uniqueCountries$: Observable<string[]> = new Observable<string[]>();
  uniqueRegions$: Observable<string[]> = new Observable<string[]>();
  uniqueStyles$: Observable<string[]> = new Observable<string[]>();


  selectedBrand: string = '';
  selectedCountry: string = '';
  selectedRegion: string = '';
  selectedStyle: string = '';


  rumPlpList$: Observable<RumPlpModel[]> = this._plpService.loadProductsRum() as Observable<RumPlpModel[]>;


  constructor(private _plpService: PlpService,  private _router: Router) {
  }


  ngOnInit(): void {
    this.uniqueBrands$ = this._plpService.getBrandsRum();
    this.uniqueCountries$ = this._plpService.getCountriesRum();
    this.uniqueRegions$ = this._plpService.getRegionsRum();
    this.uniqueStyles$ = this._plpService.getStylesRum();
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
      this._plpService.loadProductsRum(),
      this._plpService.getBrandsRum(),
      this._plpService.getCountriesRum(),
      this._plpService.getRegionsRum(),
      this._plpService.getStylesRum(),
    ]).subscribe(([products, brands, countries, regions, styles, ]) => {
      let filteredProducts = products;
      filteredProducts = this._plpService.filterProductsByRum(filteredProducts, 'tequilaBrandType', this.selectedBrand);
      filteredProducts = this._plpService.filterProductsByRum(filteredProducts, 'countryType', this.selectedCountry);
      filteredProducts = this._plpService.filterProductsByRum(filteredProducts, 'tequilaRegionType', this.selectedRegion);
      filteredProducts = this._plpService.filterProductsByRum(filteredProducts, 'tequilaStyleType', this.selectedStyle);

      this.rumPlpList$ = of(filteredProducts);
    });
  }

  redirectToRumPdp(productId: number): void {
    this._router.navigateByUrl('/pdp-rum/' + productId);
  }
}
