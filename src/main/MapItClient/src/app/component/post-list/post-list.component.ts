import { Component, OnInit } from '@angular/core';
import {Post} from "../../model/post";
import {PostService} from "../../service/post.service";
import {Observable} from "rxjs";
import {UploadFileService} from "../../service/upload-file.service";


@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  posts: Post[];
  fileInfos: Observable<any>;

  constructor(private postService: PostService, private uploadService: UploadFileService) { }

  ngOnInit() {
    this.postService.findAll().subscribe(data => {
      this.posts = data;
    });
    this.fileInfos = this.uploadService.getFiles();
  }


}
