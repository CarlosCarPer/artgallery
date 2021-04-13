import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Usuario } from '../interfaces/usuario';
import { UsuarioResponse, UsuariosResponse} from '../interfaces/responses';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>('usuers');
  }

  get(id: number): Observable<Usuario> {
    return this.http.get<Usuario>('users/' + id);
  }

  insert(usuario: Usuario, id: number): Observable<Usuario> {
    return this.http.post<Usuario>(`usuarios/${id}`, usuario);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`usuarios/${id}`);
  }
}

