import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  
  constructor(private data:HttpServiceService) { }

  ngOnInit(): void {
    this.data.getData().subscribe(data => {
      console.log(data);
  });

}}
