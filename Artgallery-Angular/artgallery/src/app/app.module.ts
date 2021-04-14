import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ArtListComponent } from './art-list/art-list.component';
import { FormsModule } from '@angular/forms';
import { ArtFilterPipe } from './pipes/art-filter.pipe';
import { ArtItemComponent } from './art-item/art-item.component';
import { ArtAddComponent } from './art-add/art-add.component';
import { BaseUrlInterceptor } from './interceptors/base-url.interceptor';
import { AppRoutingModule } from './app-routing.module';
import { ArtDetailComponent } from './art-detail/art-detail.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { AuthTokenInterceptor } from './interceptors/auth-token.interceptor';
import { UserListComponent } from './user-list/user-list.component';
import { UserItemComponent } from './user-item/user-item.component';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { UserFilterPipe } from './pipes/user-filter.pipe';
import { UserEditComponent } from './user-edit/user-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ArtListComponent,
    ArtFilterPipe,
    ArtItemComponent,
    ArtAddComponent,
    ArtDetailComponent,
    LoginComponent,
    RegistroComponent,
    UserListComponent,
    UserItemComponent,
    UserDetailComponent,
    UserFilterPipe,
    UserEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BaseUrlInterceptor,
      multi: true,
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthTokenInterceptor,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
