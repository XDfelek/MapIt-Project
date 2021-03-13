import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {UserListComponent} from './component/user-list/user-list.component';
import {UserFormComponent} from './component/user-form/user-form.component';
import {FormsModule} from '@angular/forms';
import {UserService} from "./service/user.service";
import {PostListComponent} from "./component/post-list/post-list.component";
import {PostFormComponent} from "./component/post-form/post-form.component";
import {PostService} from "./service/post.service";
import { UploadFilesComponent } from './component/upload-files/upload-files.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    PostListComponent,
    PostFormComponent,
    UploadFilesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [UserService, PostService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
