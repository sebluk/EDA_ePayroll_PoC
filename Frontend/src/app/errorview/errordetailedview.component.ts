import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ErrorsService } from './errorview.service';

@Component({
  templateUrl: './errordetailedview.component.html',
  styleUrls: ['./errordetailedview.component.css'],
})
export class ErrorDetailedViewComponent implements OnInit {
  error!: any;
  jsonRecord!: any;
  constructor(
    private errorService: ErrorsService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.error = this.errorService.getError(
      this.activatedRoute.snapshot.params['id']
    );

    let jsonRecord = Object.assign({}, this.error.json);

    delete jsonRecord.errorNumber;
    delete jsonRecord.errorDescription;

    this.jsonRecord = jsonRecord;
  }
}
