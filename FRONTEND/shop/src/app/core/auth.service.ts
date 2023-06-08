import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  isLoginPage: boolean = true;

  constructor() {}
}
