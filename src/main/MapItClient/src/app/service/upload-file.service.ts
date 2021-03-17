import { Injectable } from '@angular/core';
import {HttpClient, HttpRequest, HttpHeaders, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "../model/post";

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  private baseURL = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  upload(file: File, post: Post): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file',file);
    formData.append('title',post.title);
    formData.append('description',post.description);



    const req = new HttpRequest('POST', `${this.baseURL}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    return this.http.get(`${this.baseURL}/files`);
  }
}
