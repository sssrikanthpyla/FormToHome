import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'formtohome-fe';
  user = '';

  constructor(private keycloak: KeycloakService) { }

  ngOnInit(): void {
    this.initFunctions();
  }

  initFunctions() {
    this.user = this.keycloak.getUsername();
  }

  logout() {
    this.keycloak.logout('http://localhost:4200');
  }
}
