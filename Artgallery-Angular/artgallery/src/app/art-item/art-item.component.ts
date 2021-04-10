import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Art } from '../interfaces/art';
import { ArtsService } from '../services/arts.service';

@Component({
  selector: 'art-item',
  templateUrl: './art-item.component.html',
  styleUrls: ['./art-item.component.css']
})
export class ArtItemComponent implements OnInit {
  @Input() art!: Art;
  @Output() deleted = new EventEmitter<void>();

  constructor(private artsService: ArtsService) { }

  ngOnInit(): void {
  }

  deleteArt(): void {
    this.artsService.delete(this.art.artid as number).subscribe(
      () => this.deleted.emit()
    );
  }
}
