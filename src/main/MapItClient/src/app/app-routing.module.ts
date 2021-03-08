import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserFormComponent} from "./user-form/user-form.component";
import {UserListComponent} from "./user-list/user-list.component";
import {PostListComponent} from "./post-list/post-list.component";
import {PostFormComponent} from "./post-form/post-form.component";

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'posts', component: PostListComponent },
  { path: 'addpost', component: PostFormComponent}
  ];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    declarations: [],
    exports: [RouterModule]
})
export class AppRoutingModule { }
