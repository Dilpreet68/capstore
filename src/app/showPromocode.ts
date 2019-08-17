import {AdminService} from './app.adminService';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'show-promocode',
  templateUrl: 'showPromocode.html'
})

export class ShowPromocodeComponent {
    constructor(private service: AdminService, private route:Router) {}




    ngOnInit(): void {

       }
      }
