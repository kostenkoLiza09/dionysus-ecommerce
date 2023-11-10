export interface ProductResultModel {
  id?: string;
  countryType?: string;
  productBrand?: string;
  name?: string;
  image?: string;
  price?: string;
  quantity?: number;
}

export const defaultProductResultModel = {
  id:undefined,
  countryType: undefined,
  productBrand: undefined,
  name: undefined,
  image: undefined,
  price: undefined,
  quantity: undefined,
};
