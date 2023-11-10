import {Injectable} from "@angular/core";
import {map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {DataContainer} from "../app/models/data.container";
import {WinePlpModel} from "../app/models/plp/wine-plp.model";
import {WhiskeyPlpModel} from "../app/models/plp/whiskey-plp.model";
import {RumPlpModel} from "../app/models/plp/rum-plp.model";
import {TequilaPlpModel} from "../app/models/plp/tequila-plp.model";
import {LiqueurPlpModel} from "../app/models/plp/liqueur-plp.model";


@Injectable({
  providedIn: "root"
})
export class PlpService{

  constructor(private _http: HttpClient) {
  }

  loadProductsWine(): Observable<WinePlpModel[]> {
    return this._http.get('http://localhost:8080/products/wine/plp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  filterProductsByWine(products: WinePlpModel[], field: keyof WinePlpModel, value: string): WinePlpModel[] {
    if (!value) {
      return products;
    }
    return products.filter(product => product[field] === value);
  }

  private getUniqueValuesForWine(field: keyof WinePlpModel): Observable<string[]> {
    return this.loadProductsWine().pipe(
      map(products => [...new Set(products.map(product => product[field]))])
    );
  }

  getBrandsWine(): Observable<string[]> {
    return this.getUniqueValuesForWine('wineBrandType');
  }
  getCountriesWine(): Observable<string[]> {
    return this.getUniqueValuesForWine('countryType');
  }
  getRegionsWine(): Observable<string[]> {
    return this.getUniqueValuesForWine('wineRegionType');
  }
  getStylesWine(): Observable<string[]> {
    return this.getUniqueValuesForWine('wineStyleType');
  }
  getVarietalsWine(): Observable<string[]> {
    return this.getUniqueValuesForWine('wineVarietalType');
  }

loadProductsWhiskey(): Observable<WhiskeyPlpModel[]> {
  return this._http.get('http://localhost:8080/products/whiskey/plp')
    .pipe(
      map(res => {
        const data: DataContainer = res as DataContainer;
        return data.data;
      })
    );
}


  filterProductsByWhiskey(products: WhiskeyPlpModel[], field: keyof WhiskeyPlpModel, value: string): WhiskeyPlpModel[] {
    if (!value) {
      return products;
    }
    return products.filter(product => product[field] === value);
  }

  private getUniqueValuesForWhiskey(field: keyof WhiskeyPlpModel): Observable<string[]> {
    return this.loadProductsWhiskey().pipe(
      map(products => [...new Set(products.map(product => product[field]))])
    );
  }

  getBrandsWhiskey(): Observable<string[]> {
    return this.getUniqueValuesForWhiskey('whiskeyBrandType');
  }
  getCountriesWhiskey(): Observable<string[]> {
    return this.getUniqueValuesForWhiskey('countryType');
  }
  getRegionsWhiskey(): Observable<string[]> {
    return this.getUniqueValuesForWhiskey('whiskeyRegionType');
  }
  getStylesWhiskey(): Observable<string[]> {
    return this.getUniqueValuesForWhiskey('whiskeyStyleType');
  }

  loadProductsRum(): Observable<RumPlpModel[]> {
    return this._http.get('http://localhost:8080/products/rum/plp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }


  filterProductsByRum(products: RumPlpModel[], field: keyof RumPlpModel, value: string): RumPlpModel[] {
    if (!value) {
      return products;
    }
    return products.filter(product => product[field] === value);
  }

  private getUniqueValuesForRum(field: keyof RumPlpModel): Observable<string[]> {
    return this.loadProductsRum().pipe(
      map(products => [...new Set(products.map(product => product[field]))])
    );
  }

  getBrandsRum(): Observable<string[]> {
    return this.getUniqueValuesForRum('rumBrandType');
  }
  getCountriesRum(): Observable<string[]> {
    return this.getUniqueValuesForRum('countryType');
  }
  getRegionsRum(): Observable<string[]> {
    return this.getUniqueValuesForRum('rumRegionType');
  }
  getStylesRum(): Observable<string[]> {
    return this.getUniqueValuesForRum('rumStyleType');
  }

  loadProductsTequila(): Observable<TequilaPlpModel[]> {
    return this._http.get('http://localhost:8080/products/tequila/plp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }


  filterProductsByTequila(products: TequilaPlpModel[], field: keyof TequilaPlpModel, value: string): TequilaPlpModel[] {
    if (!value) {
      return products;
    }
    return products.filter(product => product[field] === value);
  }

  private getUniqueValuesForTequila(field: keyof TequilaPlpModel): Observable<string[]> {
    return this.loadProductsTequila().pipe(
      map(products => [...new Set(products.map(product => product[field]))])
    );
  }

  getBrandsTequila(): Observable<string[]> {
    return this.getUniqueValuesForTequila('tequilaBrandType');
  }
  getCountriesTequila(): Observable<string[]> {
    return this.getUniqueValuesForTequila('countryType');
  }
  getRegionsTequila(): Observable<string[]> {
    return this.getUniqueValuesForTequila('tequilaRegionType');
  }
  getStylesTequila(): Observable<string[]> {
    return this.getUniqueValuesForTequila('tequilaStyleType');
  }
  loadProductsLiqueur(): Observable<LiqueurPlpModel[]> {
    return this._http.get('http://localhost:8080/products/liqueur/plp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  filterProductsByLiqueur(products: LiqueurPlpModel[], field: keyof LiqueurPlpModel, value: string): LiqueurPlpModel[] {
    if (!value) {
      return products;
    }
    return products.filter(product => product[field] === value);
  }

  private getUniqueValuesForLiqueur(field: keyof LiqueurPlpModel): Observable<string[]> {
    return this.loadProductsLiqueur().pipe(
      map(products => [...new Set(products.map(product => product[field]))])
    );
  }

  getBrandsLiqueur(): Observable<string[]> {
    return this.getUniqueValuesForLiqueur('liqueurBrandType');
  }
  getCountriesLiqueur(): Observable<string[]> {
    return this.getUniqueValuesForLiqueur('countryType');
  }
  getRegionsLiqueur(): Observable<string[]> {
    return this.getUniqueValuesForLiqueur('liqueurRegionType');
  }
  getStylesLiqueur(): Observable<string[]> {
    return this.getUniqueValuesForLiqueur('liqueurStyleType');
  }
  loadArticles(): Observable<Object> {
    return this._http.get('http://localhost:8080/articles/plp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
