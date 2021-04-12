import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { Art } from '../interfaces/art';
import { ArtsService } from '../services/arts.service';

@Injectable({
  providedIn: 'root'
})
export class ArtResolver implements Resolve<Art> {
  constructor(private artsService: ArtsService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Art> {
    return this.artsService.get(+route.params.id);
  }
}
