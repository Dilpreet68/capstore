import {AdminService} from './app.adminService';
import { Component } from '@angular/core';
import {Product} from './models/Product';
import { Router } from '@angular/router';

@Component({
    // tslint:disable-next-line: component-selector
    selector: 'show-product',
    templateUrl: 'showProduct.html'
})

export class ShowProductComponent {
    constructor(private service: AdminService, private route:Router) {}

    search:any;
    
    product: Product[] = [];
    productId: number;
    // tslint:disable-next-line: use-life-cycle-interface
    ngOnInit(): void {
        this.service.getProduct().subscribe(
            res => {
               this.product = res;

            },
            err => {
                alert('an error has occurred');
            }
        );
        this.productId = 0;
       }

       deleteProduct(data: number): any {
        this.productId =  this.product[data].productID;
       if (this.service.deleteProduct(this.productId).subscribe( data => {console.log(data);
       },
       error => console.log(error)

       ))
       {
         if (confirm('Are you Sure You Want To Delete')) {
           this.product.splice(data, 1);
         }
       }
      }

      backtoadmin()
{
  this.route.navigate(['admin']);

}

      }

