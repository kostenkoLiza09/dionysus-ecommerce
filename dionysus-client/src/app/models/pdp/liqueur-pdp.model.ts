export interface LiqueurPdpModel {
  id: number;
  liqueurBrandType: string;
  liqueurRegionType: string;
  liqueurStyleType: string;

  countryType: string;
  name: string;
  description: string;
  age: number;
  alcohol_by_volume: number;
  price: number;
  images: string[];
}
