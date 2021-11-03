import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';

@Component({
  templateUrl: './errorview.component.html',
  styleUrls: ['./errorview.component.css']
})
export class ErrorViewComponent implements OnInit {

  errors!:any[];

  constructor(private route: ActivatedRoute) {
    
  }
 
  ngOnInit(): void {
    this.errors = this.route.snapshot.data['errors'];
  }


}
