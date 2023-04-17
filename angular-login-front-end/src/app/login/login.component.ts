import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  valueReturn:any;

  constructor(private http: HttpClient, private header:Headers) {}

  ngOnInit(): void {
  }

  onLogin() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(this.username+':'+this.password)
      })
    };

    
    // http://localhost:8080/auth/create
    this.http.get("http://localhost:8080/auth/login", httpOptions).subscribe(data => {
      this.valueReturn = data;
    });
  }

  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password);
  }

}
