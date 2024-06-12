import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  items: any[] = []; // Array para almacenar todos los elementos
  paginatedItems: any[] = []; // Array para almacenar los elementos de la página actual
  pageIndex: number = 0; // Índice de la página actual
  pageSize: number = 3; // Tamaño de la página (número de elementos por página)
  selectedIndex: number = 1; // Índice del elemento seleccionado dentro de la página

  constructor(private data: HttpServiceService) { }

  ngOnInit(): void {
    this.data.getData().subscribe(data => {
      this.items = data;
      this.updatePaginatedItems();
      console.log(data);
    });
  }

  updatePaginatedItems(): void {
    const start = this.pageIndex * this.pageSize;
    const end = start + this.pageSize;
    this.paginatedItems = this.items.slice(start, end);
    this.selectedIndex = Math.min(this.selectedIndex, this.paginatedItems.length - 1);
  }

  prevItem(): void {
    if (this.selectedIndex > 0) {
      this.selectedIndex--;
    } else if (this.pageIndex > 0) {
      this.pageIndex--;
      this.updatePaginatedItems();
      this.selectedIndex = this.pageSize - 1; // Selecciona el último elemento de la nueva página
    } else {
      this.pageIndex = Math.ceil(this.items.length / this.pageSize) - 1;
      this.updatePaginatedItems();
      this.selectedIndex = this.paginatedItems.length - 1; // Selecciona el último elemento de la última página
    }
  }

  nextItem(): void {
    if (this.selectedIndex < this.paginatedItems.length - 1) {
      this.selectedIndex++;
    } else if (this.pageIndex < Math.ceil(this.items.length / this.pageSize) - 1) {
      this.pageIndex++;
      this.updatePaginatedItems();
      this.selectedIndex = 0; // Selecciona el primer elemento de la nueva página
    } else {
      this.pageIndex = 0;
      this.updatePaginatedItems();
      this.selectedIndex = 0; // Selecciona el primer elemento de la primera página
    }
  }

  selectItem(index: number): void {
    this.selectedIndex = index;
  }
}
