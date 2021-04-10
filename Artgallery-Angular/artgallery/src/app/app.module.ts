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

@NgModule({
  declarations: [
    AppComponent,
    ArtListComponent,
    ArtFilterPipe,
    ArtItemComponent,
    ArtAddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BaseUrlInterceptor,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
