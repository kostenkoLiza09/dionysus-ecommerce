import { Component } from '@angular/core';
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {SearchComponent} from "../search/search.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf,
    SearchComponent
  ],
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {


}
