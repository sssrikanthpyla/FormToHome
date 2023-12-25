import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-home-container',
  templateUrl: './home-container.component.html',
  styleUrls: ['./home-container.component.scss']
})
export class HomeContainerComponent implements OnInit{

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
