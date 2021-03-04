import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {User} from "../model/user";

@Injectable()
export class UserService {

  private usersUrl: string;

  private allUserUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/user/add';
    this.allUserUrl = 'http://localhost:8080/user/all';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.allUserUrl);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }
}
