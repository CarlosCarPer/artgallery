import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Art } from '../interfaces/art';
import { ArtsService } from '../services/arts.service';

@Component({
  selector: 'art-add',
  templateUrl: './art-add.component.html',
  styleUrls: ['./art-add.component.css']
})
export class ArtAddComponent implements OnInit {
  nombreImagen = '';
  newArt!: Art;
  @Output() added = new EventEmitter<Art>();

  constructor(private artsService: ArtsService) { }

  ngOnInit(): void {
    this.resetForm();
  }

  addArt(): void {
    this.artsService.insert(this.newArt).subscribe(
      art => {
        this.added.emit(art);
        this.resetForm();
      }
    );
  }

  changeImage(fileInput: HTMLInputElement): void {
    if (!fileInput.files || fileInput.files.length === 0) {
      return;
    }
    const reader: FileReader = new FileReader();
    reader.readAsDataURL(fileInput.files[0]);
    reader.addEventListener('loadend', (e) => {
      this.newArt.url = reader.result as string;
    });
  }

  resetForm(): void {
    this.newArt = {
      artid: 0,
      title: '',
      description: '',
      author: '',
      url: '',
      tags: [''],
      likes:0,
      artdate: '',
      userid: 0
    };
    this.nombreImagen = '';
  }
}
