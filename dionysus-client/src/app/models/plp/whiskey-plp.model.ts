export interface WhiskeyPlpModel {
  id: number;
  whiskeyBrandType: string;
  countryType: string;
  name: string;
  image: string;
  price: number;
  whiskeyRegionType: string;
  whiskeyStyleType: string;

  [key: string]: any;
}
