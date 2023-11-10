import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {RumPlpModel} from "../../../models/plp/rum-plp.model";
import {PlpService} from "../../../../services/plp.service";
import {TequilaPlpModel} from "../../../models/plp/tequila-plp.model";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-tequila-component',
  standalone: true,
  templateUrl: './tequila-component.component.html',
  imports: [
    AsyncPipe,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./tequila-component.component.scss']
})
export class TequilaComponentComponent implements OnInit {


  plpList$: Observable<TequilaPlpModel[]> = this._plpService.loadProductsTequila() as Observable<TequilaPlpModel[]>;


  constructor(private _plpService: PlpService) {
  }

  ngOnInit(): void {

  }
}
