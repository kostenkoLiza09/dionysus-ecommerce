import { Component } from '@angular/core';
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./footer.component.scss']

})
export class FooterComponent {

}
