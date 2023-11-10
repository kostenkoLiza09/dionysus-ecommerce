import {Routes} from "@angular/router";
import {LiqueurPdpComponent} from "./liqueur-pdp.component";

export const LIQUEUR_PDP_ROUTES: Routes= [

  {
    path: ':id',
    component: LiqueurPdpComponent,

  }
]
