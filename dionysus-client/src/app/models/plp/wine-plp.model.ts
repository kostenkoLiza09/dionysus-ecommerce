export interface WinePlpModel {
  id: number;
  wineBrandType: string;
  countryType: string;
  name: string;
  image: string;
  price: number;

  wineRegionType: string;
  wineStyleType: string;
  wineVarietalType: string;
  [key: string]: any;
}
