export interface RumPlpModel {
  id: number;
  rumBrandType: string;
  countryType: string;
  name: string;
  image: string;
  price: number;

  rumRegionType: string;
  rumStyleType: string;
  [key: string]: any;
}
