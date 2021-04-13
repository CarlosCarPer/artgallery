import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ArtListComponent } from './art-list/art-list.component';
import { ArtAddComponent } from './art-add/art-add.component';
import { ArtDetailComponent } from './art-detail/art-detail.component';
import { ArtResolver } from './resolvers/art.resolver';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { LoginGuard } from './guards/login.guard';

const ROUTES: Routes = [
  {
    path: 'auth/login',
    component: LoginComponent
  },
  {
    path: 'auth/registro',
    component: RegistroComponent
  },
  {
    path: 'arts',
    component: ArtListComponent,
    canActivate: [LoginGuard]
  },
  {
    path: 'arts/add',
    component: ArtAddComponent,
    canActivate: [LoginGuard]
  },
  {
    path: 'arts/:id',
    component: ArtDetailComponent,
    canActivate: [LoginGuard],
    resolve: {
      art: ArtResolver
    }
  },
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/arts'
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: '/arts'
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(ROUTES)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
