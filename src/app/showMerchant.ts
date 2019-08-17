import {AdminService} from './app.adminService';
import { Component } from '@angular/core';
import { Merchant } from './models/Merchant';
import { Router } from '@angular/router';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'show-merchant',
  templateUrl: 'showMerchant.html'

})
export class ShowMerchantComponent {
    constructor(private service: AdminService, private route:Router) {}
    merchant: Merchant[] = [];
merchantId: number;
    // tslint:disable-next-line: use-life-cycle-interface
    ngOnInit(): void {
        this.service.getMerchant().subscribe(
            res => {
               this.merchant = res;

            },
            err => {
                alert('an error has occurred');
            }
        );
        this.merchantId = 0 ;
       }

       deleteMerchant(data: number): any {
        this.merchantId =  this.merchant[data].merchantId;
       if (this.service.deleteMerchant(this.merchantId).subscribe( data => {console.log(data);
       },
       error => console.log(error)

       ))
       {
         if (confirm('Are you Sure You Want To Delete')) {
           this.merchant.splice(data, 1);
         }
       }
      }
      backtoadmin()
      {
        this.route.navigate(['admin']);

      }


}
