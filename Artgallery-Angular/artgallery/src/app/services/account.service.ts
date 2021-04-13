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

  getAll(): Observable<AccountsResponse> {
    return this.http.get<AccountsResponse>('accounts');
  }

  get(id: number): Observable<Account> {
    return this.http.get<AccountResponse>('accounts/' + id).pipe(
      map(resp => resp.account)
    );
  }

  insert(account: Account, id: number): Observable<Account> {
    return this.http.post<Account>(`accounts/${id}`, account);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`accounts/${id}`);
  }
}
