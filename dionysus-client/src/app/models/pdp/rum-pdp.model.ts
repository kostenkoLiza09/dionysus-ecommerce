export interface RumPdpModel {
  id: number;
  rumBrandType: string;
  rumRegionType: string;
  rumStyleType: string;

  countryType: string;
  name: string;
  description: string;
  age: number;
  alcohol_by_volume: number;
  price: number;
  images: string[];
}
