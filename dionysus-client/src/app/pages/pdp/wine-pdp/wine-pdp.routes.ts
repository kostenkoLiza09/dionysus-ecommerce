import {Routes} from "@angular/router";

import {WinePdpComponent} from "./wine-pdp.component";

export const WINE_PDP_ROUTES: Routes= [

  {
    path: ':id',
    component: WinePdpComponent,

  }
]
