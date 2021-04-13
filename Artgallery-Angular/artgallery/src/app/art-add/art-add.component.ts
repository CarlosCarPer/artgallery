import { toBase64String } from '@angular/compiler/src/output/source_map';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Art } from '../interfaces/art';
import { Router } from '@angular/router';
import { ArtsService } from '../services/arts.service';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'art-add',
  templateUrl: './art-add.component.html',
  styleUrls: ['./art-add.component.css']
})
export class ArtAddComponent implements OnInit {
  nombreImagen = '';
  tags: string[] = [];
  newArt: Art = {
      title: '',
      description: '',
      url: '',
      tags: '',
      likes: 0
  };
  userid=1;
  @Output() added = new EventEmitter<Art>();

  constructor(private artsService: ArtsService, private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.resetForm();
  }

  addArt(): void {
    this.usuarioService.get(this.userid).subscribe(
      user=>this.newArt.user=user
    );
    this.artsService.insert(this.newArt, 1).subscribe(
      art => this.router.navigate(['/artes'])
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
