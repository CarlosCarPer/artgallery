import { ClassGetter } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit, EventEmitter, Output} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Art } from '../interfaces/art';
import { ArtsService } from '../services/arts.service';

@Component({
  selector: 'art-detail',
  templateUrl: './art-detail.component.html',
  styleUrls: ['./art-detail.component.css'],
})
export class ArtDetailComponent implements OnInit {
  art!: Art;
  @Output() deleted = new EventEmitter<void>();

  constructor(private route: ActivatedRoute, private router: Router, private artsService: ArtsService) {}

  ngOnInit(): void {
    this.route.data.subscribe(
      data => this.art = data.art
    );
  }


  goBack() {
    this.router.navigate(['/arts']);
  }


  deleteArt(): void {
    this.artsService.delete(this.art.artId as number).subscribe(
      () => this.deleted.emit()
    );
  }
}
