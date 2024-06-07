import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
coleccionables: any;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  viewDetails(categoria: any) {
    console.log(categoria);
    this.router.navigate(['/catalogo', categoria]);
  }

}
