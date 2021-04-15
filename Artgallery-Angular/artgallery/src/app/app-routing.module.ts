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
import { UserListComponent } from './user-list/user-list.component';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { UserResolver } from './resolvers/user.resolver';

const ROUTES: Routes = [
  {
    path: 'auth/login',
    component: LoginComponent
  },
  {
    path: 'auth/register',
    component: RegistroComponent
  },
  {
    path: 'arts',
    component: ArtListComponent
  },
  {
    path: 'arts/add',
    component: ArtAddComponent,
    canActivate: [LoginGuard]
  },
  {
    path: 'arts/:id',
    component: ArtDetailComponent,
    resolve: {
      art: ArtResolver
    }
  },
  {
    path: 'users',
    component: UserListComponent
  },
  {
    path: 'users/:id',
    component: UserDetailComponent,
    resolve: {
      user: UserResolver
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
