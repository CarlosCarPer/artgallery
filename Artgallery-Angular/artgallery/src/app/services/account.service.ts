import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Account } from '../interfaces/account';
import { AccountResponse, AccountsResponse } from '../interfaces/responses';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  constructor(private http: HttpClient) { }

  getAll(): Observable<Account[]> {
    return this.http.get<Account[]>('accounts');
  }

  get(id: number): Observable<Account> {
    return this.http.get<Account>('accounts/' + id);
  }

  insert(account: Account, id: number): Observable<Account> {
    return this.http.post<Account>(`accounts/${id}`, account);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`accounts/${id}`);
  }
}
