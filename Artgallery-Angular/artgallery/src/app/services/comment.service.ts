import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Comment } from '../interfaces/comment';
import { CommentResponse, CommentsResponse } from '../interfaces/responses';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {
  constructor(private http: HttpClient) { }

  getAll(): Observable<Comment[]> {
    return this.http.get<CommentsResponse>('comments').pipe(
      map(resp => resp.comments)
      );
  }

  get(id: number): Observable<Comment> {
    return this.http.get<CommentResponse>('comments/' + id).pipe(
      map(resp => resp.comment)
    );
  }

  insert(comment: Comment, id: number): Observable<Comment> {
    return this.http.post<Comment>(`comments/${id}`, comment);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`comments/${id}`);
  }
}
