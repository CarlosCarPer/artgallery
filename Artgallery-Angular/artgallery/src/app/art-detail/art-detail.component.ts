import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Art } from '../interfaces/art';

@Component({
  selector: 'art-detail',
  templateUrl: './art-detail.component.html',
  styleUrls: ['./art-detail.component.css'],
})
export class ArtDetailComponent implements OnInit {
  art!: Art;

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.route.data.subscribe(
      data => this.art = data.art
    );
  }

  goBack() {
    this.router.navigate(['/arts']);
  }
}
