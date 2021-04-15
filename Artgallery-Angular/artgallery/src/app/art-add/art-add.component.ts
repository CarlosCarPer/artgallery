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
  newArt!: Art;
  @Output() added = new EventEmitter<Art>();

  constructor(private artsService: ArtsService, private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.resetForm();
  }

  addArt(): void {
    this.artsService.insert(this.newArt,this.getUserId()).subscribe(
      art => this.router.navigate(['/arts'])
      );
    // tags = this.newArt.tags.fore
  }

  getUserId() {
    return JSON.parse(atob(localStorage.getItem('token')!.split('.')[1])).userid;
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
    this.newArt ={
      title: '',
      description: '',
      url: '',
      tags: '',
      likes: 0,
      comments: []
    };
    this.nombreImagen;
  }
}
