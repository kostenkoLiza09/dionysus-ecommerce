import { Routes } from "@angular/router";

export const APP_ROUTES: Routes = [
  {
    path: '',
    pathMatch: 'full',
    loadChildren: () => import('./pages/home/home.routes').then(m => m.HOME_ROUTES)
  },
  {
    path: 'plp-whiskey',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/plp/whiskey-plp/whiskey-plp.routes').then(m => m.WHISKEYPLP_ROUTES)
  },
  {
    path: 'plp-wine',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/plp/wine-plp/wine-plp.routes').then(m => m.WINEPLP_ROUTES)
  },
  {
    path: 'plp-rum',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/plp/rum-plp/rum-plp.routes').then(m => m.RUMPLP_ROUTES)
  },
  {
    path: 'plp-tequila',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/plp/tequila-plp/tequila-plp.routes').then(m => m.TEQUILAPLP_ROUTES)
  },
  {
    path: 'plp-liqueur',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/plp/liqueur-plp/liqueur-plp.routes').then(m => m.LIQUERPLP_ROUTES)
  },
  {
    path: 'plp-articles',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/plp/articles-plp/articles-plp.routes.').then(m => m.ARTICLESPLP_ROUTES)
  },
  {
    path: 'pdp-wine',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/pdp/wine-pdp/wine-pdp.routes').then(m => m.WINE_PDP_ROUTES)
  },
  {
    path: 'pdp-whiskey',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/pdp/whiskey-pdp/whiskey-pdp.routes').then(m => m.WHISKEY_PDP_ROUTES)
  },
  {
    path: 'pdp-liqueur',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/pdp/liqueur-pdp/liqueur-pdp.routes').then(m => m.LIQUEUR_PDP_ROUTES)
  },
  {
    path: 'pdp-rum',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/pdp/rum-pdp/rum-pdp.routes').then(m => m.RUM_PDP_ROUTES)
  },
  {
    path: 'pdp-tequila',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/pdp/tequila-pdp/tequila-pdp.routes').then(m => m.TEQUILA_PDP_ROUTES)
  },
  {
    path: 'pdp-articles',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/pdp/articles-pdp/articles-pdp.routes').then(m => m.ARTICLES_PDP_ROUTES)
  },
  {
    path: 'brands',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/brands/brands.routes').then(m => m.BRANDS_ROUSTES)
  },
  {
    path: 'contacts',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/contacts/contacts.routes').then(m => m.CONTACTS_ROUTES)
  },
  {
    path: 'about',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/about/about.routes').then(m => m.ABOUT_ROUTES)
  },
  {
    path: 'payments',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/payment/payment.routes').then(m => m.PAYMENT_ROUTES)
  },
  {
    path: 'register',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/register/register.routes').then(m => m.REGISTER_ROUTES)
  },
  {
    path: 'login',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/login/login.routes').then(m => m.LOGIN_ROUTES)
  },
  {
    path: 'cart',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/cart/cart.routes').then(m => m.CART_ROUTES)
  },

];
