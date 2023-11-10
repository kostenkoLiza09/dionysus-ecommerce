import { Component, OnInit } from '@angular/core';
import { map, Observable } from 'rxjs';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { AuthService } from '../../../services/auth.service';
import { SessionService } from '../../../services/session.service';
import { Router } from '@angular/router';
import {AsyncPipe} from "@angular/common";
import {BackgroundComponent} from "../../components/background/background.component";

@Component({
  selector: 'app-register',
  standalone: true,
  templateUrl: './register.component.html',
  imports: [
    AsyncPipe,
    ReactiveFormsModule,
    BackgroundComponent
  ],
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;

  isSubmit: Observable<boolean>;

  constructor(
    private _fb: FormBuilder,
    private _registerService: AuthService,
    private _sessionService: SessionService,
    private _router: Router
  ) {
    this.form = this._fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(3)]],
    });

    this.isSubmit = this.form.statusChanges.pipe(
      map(status => status === 'VALID')
    );
  }

  ngOnInit(): void {
    this.form.statusChanges.subscribe(value => {
      console.log(value);
    });
  }

  register(): void {
    if (this.form.valid) {
      let value = this.form.value;
      const email: string = value.email as string;
      const name: string = value.name as string;
      const password: string = value.password as string;
      this._registerService.register(name, email, password).subscribe(res => {
        this._sessionService.addToStorage('token', JSON.stringify(res));
        this._router.navigateByUrl('/about');
      }, error => {
        console.error('Error', error);
      });
    }
  }

}
