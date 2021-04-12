import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Art } from '../interfaces/art';
import { ArtResponse, ArtsResponse } from '../interfaces/responses';

@Injectable({
  providedIn: 'root'
})
export class ArtsService {
  constructor(private http: HttpClient) { }

  getAll(): Observable<Art[]> {
    return this.http.get<Art[]>('arts');
  }

  insert(art: Art, id: number): Observable<Art> {
    return this.http.post<Art>(`arts/${id}`, art);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`arts/${id}`);
  }
}
