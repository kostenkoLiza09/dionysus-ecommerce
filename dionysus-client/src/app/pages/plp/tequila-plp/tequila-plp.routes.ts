import {Routes} from "@angular/router";
import {WinePlpComponent} from "../wine-plp/wine-plp.component";
import {TequilaPlpComponent} from "./tequila-plp.component";

export const TEQUILAPLP_ROUTES : Routes = [
  {
    path: '',
    component: TequilaPlpComponent
  }
];
