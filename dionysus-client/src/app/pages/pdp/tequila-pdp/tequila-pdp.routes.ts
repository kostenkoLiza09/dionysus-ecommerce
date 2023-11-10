import {Routes} from "@angular/router";
import {WinePdpComponent} from "../wine-pdp/wine-pdp.component";
import {TequilaPdpComponent} from "./tequila-pdp.component";

export const TEQUILA_PDP_ROUTES: Routes= [

  {
    path: ':id',
    component: TequilaPdpComponent,

  }
]
