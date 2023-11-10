export interface TequilaPdpModel {
  id: number;
  tequilaBrandType: string;
  tequilaRegionType: string;
  tequilaStyleType: string;

  countryType: string;
  name: string;
  description: string;
  age: number;
  alcohol_by_volume: number;
  price: number;
  images: string[];
}
