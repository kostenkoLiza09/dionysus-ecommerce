import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {PlpService} from "../../../../services/plp.service";
import {WinePlpModel} from "../../../models/plp/wine-plp.model";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-wine-component',
  standalone: true,
  templateUrl: './wine-component.component.html',
  imports: [
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./wine-component.component.scss']
})
export class WineComponentComponent  implements OnInit {


  winePlpList$: Observable<WinePlpModel[]> = this._plpService.loadProductsWine() as Observable<WinePlpModel[]>;


  constructor(private _plpService: PlpService) {
  }

  ngOnInit(): void {

  }
}
