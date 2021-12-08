import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  templateUrl: './errorview.component.html',
  styleUrls: ['./errorview.component.css'],
})
export class ErrorViewComponent implements OnInit {
  errors!: any[];

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.errors = this.route.snapshot.data['errors'];

    const JSON_STRING_MAX_LENGTH = 90;

    this.errors.forEach((error) => {
      let jsonRecord = Object.assign({}, error.json);

      delete jsonRecord.errorNumber;
      delete jsonRecord.errorDescription;

      error.jsonString = JSON.stringify(jsonRecord);

      if (error.jsonString.length > JSON_STRING_MAX_LENGTH) {
        error.jsonString =
          error.jsonString.substring(0, JSON_STRING_MAX_LENGTH) + ' ...';
      }
    });
  }
}
