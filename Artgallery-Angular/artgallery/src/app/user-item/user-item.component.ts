import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Usuario } from '../interfaces/usuario';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'user-item',
  templateUrl: './user-item.component.html',
  styleUrls: ['./user-item.component.css']
})
export class UserItemComponent implements OnInit {
  @Input() user!: Usuario;
  @Output() deleted = new EventEmitter<void>();

  constructor(private usersService: UsuarioService) { }

  ngOnInit(): void {
  }

}
