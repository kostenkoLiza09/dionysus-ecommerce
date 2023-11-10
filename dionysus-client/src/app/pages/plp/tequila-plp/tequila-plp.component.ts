import {Component, OnInit} from '@angular/core';
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {combineLatest, Observable, of} from "rxjs";
import {WinePlpModel} from "../../../models/plp/wine-plp.model";
import {PlpService} from "../../../../services/plp.service";
import {TequilaPlpModel} from "../../../models/plp/tequila-plp.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-tequila-plp',
  templateUrl: './tequila-plp.component.html',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./tequila-plp.component.scss']
})
export class TequilaPlpComponent implements OnInit {

  uniqueBrands$: Observable<string[]> = new Observable<string[]>();
  uniqueCountries$: Observable<string[]> = new Observable<string[]>();
  uniqueRegions$: Observable<string[]> = new Observable<string[]>();
  uniqueStyles$: Observable<string[]> = new Observable<string[]>();


  selectedBrand: string = '';
  selectedCountry: string = '';
  selectedRegion: string = '';
  selectedStyle: string = '';

  tequilaPlpList$: Observable<TequilaPlpModel[]> = this._plpService.loadProductsTequila() as Observable<TequilaPlpModel[]>;

  constructor(private _plpService: PlpService , private _router: Router) {}


  ngOnInit(): void {
    this.uniqueBrands$ = this._plpService.getBrandsTequila();
    this.uniqueCountries$ = this._plpService.getCountriesTequila();
    this.uniqueRegions$ = this._plpService.getRegionsTequila();
    this.uniqueStyles$ = this._plpService.getStylesTequila();
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
      this._plpService.loadProductsTequila(),
      this._plpService.getBrandsTequila(),
      this._plpService.getCountriesTequila(),
      this._plpService.getRegionsTequila(),
      this._plpService.getStylesTequila(),
    ]).subscribe(([products, brands, countries, regions, styles, ]) => {
      let filteredProducts = products;
      filteredProducts = this._plpService.filterProductsByTequila(filteredProducts, 'tequilaBrandType', this.selectedBrand);
      filteredProducts = this._plpService.filterProductsByTequila(filteredProducts, 'countryType', this.selectedCountry);
      filteredProducts = this._plpService.filterProductsByTequila(filteredProducts, 'tequilaRegionType', this.selectedRegion);
      filteredProducts = this._plpService.filterProductsByTequila(filteredProducts, 'tequilaStyleType', this.selectedStyle);

      this.tequilaPlpList$ = of(filteredProducts);
    });
  }

  redirectToTequilaPdp(productId: number): void {
    this._router.navigateByUrl('/pdp-tequila/' + productId);
  }

}
