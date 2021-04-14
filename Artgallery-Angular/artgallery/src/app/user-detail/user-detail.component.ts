import { ClassGetter } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../interfaces/usuario';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css'],
})
export class UserDetailComponent implements OnInit {
  user!: Usuario;
  @Output() deleted = new EventEmitter<void>();

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.data.subscribe(
      data => this.user = data.user
    );
    console.log(this.user.Joindate);
  }

  goBack() {
    this.router.navigate(['/users']);
  }
}

