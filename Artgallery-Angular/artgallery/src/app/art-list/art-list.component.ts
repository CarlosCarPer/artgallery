import {  Component, OnInit } from '@angular/core';
import { Art } from '../interfaces/art';
import { ArtsService } from '../services/arts.service';

@Component({
  selector: 'art-list',
  templateUrl: './art-list.component.html',
  styleUrls: ['./art-list.component.css'],
})
export class ArtListComponent implements OnInit {
  arts!: Art[];
  search = '';

  constructor(private artsService: ArtsService) {}

  ngOnInit(): void {
    this.artsService.getAll().subscribe(
      arts => this.arts = arts
    );
  }

  orderDate(): void {
    this.arts.sort((e1, e2) => e1.artdate!.localeCompare(e2.artdate!));
    this.arts = [...this.arts];
  }

  orderLikes(): void {
    this.arts.sort((e1, e2) => e2.likes - e1.likes);
    this.arts = [...this.arts];
  }

  deleteArt(art: Art): void {
    this.arts = this.arts.filter(e => e !== art);
  }

  addArt(art: Art): void {
    this.arts = [...this.arts, art];
  }
}
