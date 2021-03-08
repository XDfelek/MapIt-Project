import { Component, OnInit } from '@angular/core';
import {Post} from "../model/post";
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../service/post.service";

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent {

  post: Post;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private postService: PostService) {
    this.post = new Post();
  }

  onSubmit() {
    this.postService.save(this.post).subscribe(resoult => this.goToPostList());
  }

  private goToPostList() {
    this.router.navigate(['/posts'])
  }
}
