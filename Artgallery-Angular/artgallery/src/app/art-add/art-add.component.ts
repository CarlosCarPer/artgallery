import { toBase64String } from '@angular/compiler/src/output/source_map';
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
  tags: string[] = ['etiqueta11','etiqueta2'];
  newArt: Art = {
      title: '',
      description: '',
      url: '',
      tags: '',
      likes: 0
  };
  @Output() added = new EventEmitter<Art>();

  constructor(private artsService: ArtsService) { }

  ngOnInit(): void {
    this.resetForm();
  }

  addArt(): void {
    this.artsService.insert(this.newArt, 1).subscribe(
      art => {
        this.added.emit(art);
        this.resetForm();
      }
    );
    // tags = this.newArt.tags.fore
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
      title: '',
      description: '',
      url: '',
      tags: '',
      likes: 0
    };
    this.nombreImagen = '';
  }
}
