export interface WhiskeyPdpModel {
  id: number;
  whiskeyBrandType: string;
  whiskeyRegionType: string;
  whiskeyStyleType: string;

  countryType: string;
  name: string;
  description: string;
  age: number;
  alcohol_by_volume: number;
  price: number;
  images: string[];
}
