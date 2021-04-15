import {  Component, OnInit } from '@angular/core';
import { Usuario } from '../interfaces/usuario';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})
export class UserListComponent implements OnInit {
  users!: Usuario[];
  search = '';

  constructor(private usersService: UsuarioService) {}

  ngOnInit(): void {
    this.usersService.getAll().subscribe(
      users => this.users = users
    );
  }

  orderDate(): void {
    this.users.sort((e1, e2) => e1.joinDate!.localeCompare(e2.joinDate!));
    this.users = [...this.users];
  }


  orderUsername(): void {
    this.users.sort((e1, e2) => e1.username!.localeCompare(e2.username!));
    this.users = [...this.users];
  }


  searchUser(user: Usuario): void {
    this.users = this.users.filter(e => e !== user);
  }

  addUser(user: Usuario): void {
    this.users = [...this.users, user];
  }
}
