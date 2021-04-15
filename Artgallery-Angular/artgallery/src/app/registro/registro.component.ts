import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../interfaces/usuario';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  newUser: Usuario = {
    username: '',
    pass: '',
    avatar: ''
  };

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  changeImage(fileInput: HTMLInputElement): void {
    if (!fileInput.files || fileInput.files.length === 0) {
      return;
    }
    const reader: FileReader = new FileReader();
    reader.readAsDataURL(fileInput.files[0]);
    reader.addEventListener('loadend', (e) => {
    this.newUser.avatar = reader.result as string;
    });

  }

  registrarse() { console.log(this.newUser);
    this.authService.registro(this.newUser).subscribe(
      () => this.router.navigate(['/auth', 'login']),
      error => console.log(error)
    );
  }
}
