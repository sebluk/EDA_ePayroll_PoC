import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute } from '@angular/router';

@Component({
  templateUrl: './employerview.component.html',
  styleUrls: ['./employerview.component.css']
})
export class EmployerviewComponent implements OnInit {

  employers!: any[]
  searchBN:any;
  
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.employers = this.route.snapshot.data['employers'];
  }

}
