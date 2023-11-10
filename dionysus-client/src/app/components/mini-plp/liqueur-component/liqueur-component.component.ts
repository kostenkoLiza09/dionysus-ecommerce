import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {RumPlpModel} from "../../../models/plp/rum-plp.model";
import {PlpService} from "../../../../services/plp.service";
import {LiqueurPlpModel} from "../../../models/plp/liqueur-plp.model";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-liqueur-component',
  standalone: true,
  templateUrl: './liqueur-component.component.html',
  imports: [
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./liqueur-component.component.scss']
})
export class LiqueurComponentComponent implements OnInit {


  plpList$: Observable<LiqueurPlpModel[]> = this._plpService.loadProductsLiqueur() as Observable<LiqueurPlpModel[]>;


  constructor(private _plpService: PlpService) {
  }

  ngOnInit(): void {

  }
}
