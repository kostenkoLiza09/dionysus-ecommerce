import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import {SessionService} from "./session.service";
import {AuthData} from "../app/models/auth.data";
import {AuthRequest} from "../app/models/plp/AuthRequest";

@Injectable({
  providedIn: 'root'
})
export class AuthService {



  constructor(private _http: HttpClient, private _sessionService: SessionService) {
  }

  login(email: string, password: string): Observable<any> {
    return this.process2(email, password, 'http://localhost:8080/auth/login');
  }

  register(name: string, email: string, password: string): Observable<any> {
    const data: AuthRequest = {name, email, password};
    return this.process1(data, 'http://localhost:8080/auth/register');
  }


  isLoggedIn(): Observable<boolean> {
    return this._sessionService.fromStorage("token")
      .pipe(
        map(token => {
          return !!token;
        })
      );
  }


  private process1(data: AuthRequest, url: string): Observable<any> {
    return this._http.post(url, data)
      .pipe(
        map(res => {
          return res as AuthData;
        })
      );
  }

  private process2(email: string, password: string, url: string): Observable<any> {
    const register = {
      email: email,
      password: password,
    };
    return this._http.post(url, register)
      .pipe(
        map(res => {
          return res as AuthData;
        })
      );
  }
}
