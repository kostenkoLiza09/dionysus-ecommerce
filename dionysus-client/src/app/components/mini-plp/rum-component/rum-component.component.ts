import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {WhiskeyPlpModel} from "../../../models/plp/whiskey-plp.model";
import {PlpService} from "../../../../services/plp.service";
import {RumPlpModel} from "../../../models/plp/rum-plp.model";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-rum-component',
  standalone: true,
  templateUrl: './rum-component.component.html',
  imports: [
    AsyncPipe,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./rum-component.component.scss']
})
export class RumComponentComponent implements OnInit {


  plpList$: Observable<RumPlpModel[]> = this._plpService.loadProductsRum() as Observable<RumPlpModel[]>;


  constructor(private _plpService: PlpService) {
  }

  ngOnInit(): void {

  }
}
