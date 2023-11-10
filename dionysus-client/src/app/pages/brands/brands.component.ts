import { Component } from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-brands',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './brands.component.html',
  styleUrls: ['./brands.component.scss']
})
export class BrandsComponent {
  photos = [
    { url: 'assets/brands/Brand1.png', name: '...' },
    { url: 'assets/brands/Brand2.png', name: '...' },
    { url: 'assets/brands/Brand3.png', name: '...' },
    { url: 'assets/brands/Brand4.png', name: '...' },
    { url: 'assets/brands/Brand5.png', name: '...' },
    { url: 'assets/brands/Brand6.png', name: '...' },
    { url: 'assets/brands/Brand7.png', name: '...' },
    { url: 'assets/brands/Brand8.png', name: '...' },
    { url: 'assets/brands/Brand9.png', name: '...' },
    { url: 'assets/brands/Brand10.png', name: '...' },
    { url: 'assets/brands/Brand11.png', name: '...' },
    { url: 'assets/brands/Brand12.png', name: '...' },
    { url: 'assets/brands/Brand13.png', name: '...' },
    { url: 'assets/brands/Brand14.png', name: '...' },
    { url: 'assets/brands/Brand15.png', name: '...' },
    { url: 'assets/brands/Brand16.png', name: '...' },
    { url: 'assets/brands/Brand17.png', name: '...' },
    { url: 'assets/brands/Brand18.png', name: '...' },
    { url: 'assets/brands/Brand19.png', name: '...' },
    { url: 'assets/brands/Brand20.png', name: '...' },
    { url: 'assets/brands/Brand21.png', name: '...' },
    { url: 'assets/brands/Brand22.png', name: '...' },
    { url: 'assets/brands/Brand23.png', name: '...' },
    { url: 'assets/brands/Brand24.png', name: '...' },
    { url: 'assets/brands/Brand25.png', name: '...' },
    { url: 'assets/brands/Brand26.png', name: '...' },
    { url: 'assets/brands/Brand27.png', name: '...' },
    { url: 'assets/brands/Brand28.png', name: '...' },
    { url: 'assets/brands/Brand29.png', name: '...' },
    { url: 'assets/brands/Brand30.png', name: '...' },
    { url: 'assets/brands/Brand31.png', name: '...' },
    { url: 'assets/brands/Brand32.png', name: '...' },
    { url: 'assets/brands/Brand33.png', name: '...' },
    { url: 'assets/brands/Brand34.png', name: '...' },
  ];
}

