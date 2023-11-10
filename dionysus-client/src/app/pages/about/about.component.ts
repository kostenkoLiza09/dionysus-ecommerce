import { Component } from '@angular/core';
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-about',
  standalone: true,
  templateUrl: './about.component.html',
  imports: [
    NgForOf
  ],
  styleUrls: ['./about.component.scss']
})
export class AboutComponent {
  galleryImages: any[] = [
    { src: 'assets/about/img1.jpg', caption: 'Image 1' },
    { src: 'assets/about/img2.jpg', caption: 'Image 2' },
    { src: 'assets/about/img3.jpg', caption: 'Image 3' },
    { src: 'assets/about/img4.jpg', caption: 'Image 4' },
    { src: 'assets/about/img5.jpg', caption: 'Image 5' },
    { src: 'assets/about/img6.jpg', caption: 'Image 6' },
    { src: 'assets/about/img7.jpg', caption: 'Image 7' },
    { src: 'assets/about/img8.jpg', caption: 'Image 8' },
    { src: 'assets/about/img9.jpg', caption: 'Image 8' },
    { src: 'assets/about/img10.jpg', caption: 'Image 8' },
    { src: 'assets/about/img11.jpg', caption: 'Image 8' },


  ];

  sliderTransform: string = 'translateX(0)';

  openImageModal(image: any) {
    // Implement lightbox/modal functionality here (optional)
    console.log('Clicked on image:', image);
  }
}
