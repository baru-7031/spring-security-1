import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'login';

  username:string = ''
  password:string = ''
  valueReturn:any;

  constructor(private http:HttpClient) {

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
      console.log(data)
    });
  }
}
