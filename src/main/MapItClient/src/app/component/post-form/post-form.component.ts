import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../../service/post.service";
import {Post} from "../../model/post";

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent {

  post: Post = new Post();

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
