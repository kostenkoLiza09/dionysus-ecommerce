import {Component} from '@angular/core';
import { Router} from "@angular/router";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {SessionService} from "../../../services/session.service";
import {AsyncPipe} from "@angular/common";
import {BackgroundComponent} from "../../components/background/background.component";



@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  imports: [
    ReactiveFormsModule,
    AsyncPipe,
    BackgroundComponent
  ],
  styleUrls: ['./login.component.scss']
})

export class LoginComponent {


  form = this._fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(3)]],
  })


  constructor(
    private _fb: FormBuilder,
    private _registerService: AuthService,
    private _sessionService: SessionService,
    private _router: Router) {
  }

  login(): void {
    let value = this.form.value;
    const email: string = value.email as string;
    const password: string = value.password as string;
    this._registerService.login(email, password).subscribe(res => {
      this._sessionService.addToStorage("token", JSON.stringify(res));
      this._router.navigateByUrl('/about');
    });
  }

}
