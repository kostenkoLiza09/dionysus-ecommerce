import {Routes} from "@angular/router";
import {ArticlesPdpComponent} from "./articles-pdp.component";

export const ARTICLES_PDP_ROUTES: Routes= [

  {
    path: ':id',
    component: ArticlesPdpComponent,

  }
]
