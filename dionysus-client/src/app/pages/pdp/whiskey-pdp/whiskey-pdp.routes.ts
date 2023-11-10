import {Routes} from "@angular/router";
import {WhiskeyPlpComponent} from "../../plp/whiskey-plp/whiskey-plp.component";
import {WhiskeyPdpComponent} from "./whiskey-pdp.component";

export const WHISKEY_PDP_ROUTES: Routes= [

  {
    path: ':id',
    component: WhiskeyPdpComponent,

  }
]
