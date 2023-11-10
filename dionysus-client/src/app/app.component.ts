import { Component } from '@angular/core';
import {WhiskeyPlpComponent} from "./pages/plp/whiskey-plp/whiskey-plp.component";
import {RouterOutlet} from "@angular/router";
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    WhiskeyPlpComponent,
    RouterOutlet,
    HeaderComponent,
    FooterComponent,
  ],
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'dionysus-client';
}
