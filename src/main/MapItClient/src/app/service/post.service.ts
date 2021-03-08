import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "../model/post";

@Injectable()
export class PostService {

  private postURL: string;
  private allpostURL: string;

  constructor(private http: HttpClient) {
    this.postURL = 'http://localhost:8080/addpost';
    this.allpostURL = 'http://localhost:8080/posts';
  }

  findAll(): Observable<Post[]> {
  return this.http.get<Post[]>(this.allpostURL);
  }

  public save(post: Post) {
    return this.http.post<Post>(this.postURL, post);
  }
}
