import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'angular-arts';
  logged = (localStorage.getItem('token') == null)? false : true;
  id!:number;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.authService.logged$.subscribe(
      logged => this.logged = logged
    );
    if (this.logged==true)
      this.id= JSON.parse(atob(localStorage.getItem('token')!.split('.')[1])).userid;
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/arts']);
  }
}
