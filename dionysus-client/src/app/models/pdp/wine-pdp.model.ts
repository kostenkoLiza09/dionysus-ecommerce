export interface WinePdpModel {
  id: number;
  wineBrandType: string;
  wineRegionType: string;
  wineStyleType: string;
  wineVarietalType: string;

  countryType: string;
  name: string;
  description: string;
  age: number;
  alcohol_by_volume: number;
  price: number;
  images: string[];
}
