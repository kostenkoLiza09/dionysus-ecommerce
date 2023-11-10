export interface LiqueurPlpModel {
  id: number;
  liqueurBrandType: string;
  countryType: string;
  name: string;
  image: string;
  price: number;

  liqueurRegionType: string;
  liqueurStyleType: string;
  [key: string]: any;
}
