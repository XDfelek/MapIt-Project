import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../../service/post.service";
import {Post} from "../../model/post";
import {UploadFileService} from "../../service/upload-file.service";
import {Observable} from "rxjs";
import {HttpEventType, HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent{
  selectedFiles: FileList | undefined;
  currentFile: File | undefined;
  progress: number = 0;
  message: string = '';

  post: Post;
  fileInfos: Observable<any>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private postService: PostService,
    private uploadService: UploadFileService) {
    this.post = new Post();
  }

  onSubmit() {
    this.postService.save(this.post).subscribe(resoult => this.goToPostList());
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
    this.post.imagePath = event.target.files.url;
  }

  upload(post: Post) {
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.uploadService.upload(this.currentFile, post).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
          this.fileInfos = this.uploadService.getFiles();
        }
      },
      error => {
        this.progress = 0;
        this.message = 'Nie można było załadować pliku!';
        this.currentFile = undefined;
      });
    this.selectedFiles = undefined;
  }

  private goToPostList() {
    this.router.navigate(['/posts'])
  }
}
