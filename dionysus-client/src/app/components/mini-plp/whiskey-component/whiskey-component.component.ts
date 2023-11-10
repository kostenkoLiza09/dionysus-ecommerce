import {Component, OnInit} from '@angular/core';
import {async, Observable} from "rxjs";
import {WhiskeyPlpModel} from "../../../models/plp/whiskey-plp.model";
import {PlpService} from "../../../../services/plp.service";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-whiskey-component',
  standalone: true,
  templateUrl: './whiskey-component.component.html',
  imports: [
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./whiskey-component.component.scss']
})
export class WhiskeyComponentComponent implements OnInit {


  plpList$: Observable<WhiskeyPlpModel[]> = this._plpService.loadProductsWhiskey() as Observable<WhiskeyPlpModel[]>;


  constructor(private _plpService: PlpService) {
  }

  ngOnInit(): void {

  }

}
