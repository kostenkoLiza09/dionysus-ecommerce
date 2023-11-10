import { Component } from '@angular/core';
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import 'bootstrap/dist/js/bootstrap.min.js';
import {HeaderComponent} from "../../components/header/header.component";
import {WineComponentComponent} from "../../components/mini-plp/wine-component/wine-component.component";
import {WhiskeyComponentComponent} from "../../components/mini-plp/whiskey-component/whiskey-component.component";


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf,
    HeaderComponent,
    WineComponentComponent,
    WhiskeyComponentComponent,
  ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

}
