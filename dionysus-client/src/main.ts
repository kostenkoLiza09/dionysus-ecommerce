import {bootstrapApplication} from "@angular/platform-browser";
import {AppComponent} from "./app/app.component";

import {provideRouter} from "@angular/router";
import {provideHttpClient} from "@angular/common/http";
import {APP_ROUTES} from "./app/app.routes";

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    provideRouter(APP_ROUTES)
  ]
});
