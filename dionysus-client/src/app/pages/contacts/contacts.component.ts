import { Component } from '@angular/core';
import {BackgroundComponent} from "../../components/background/background.component";

@Component({
  selector: 'app-contacts',
  standalone: true,
  templateUrl: './contacts.component.html',
  imports: [
    BackgroundComponent
  ],
  styleUrls: ['./contacts.component.scss']
})
export class ContactsComponent {

}
