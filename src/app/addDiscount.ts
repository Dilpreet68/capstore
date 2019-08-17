import {AdminService} from './app.adminService';
import { Component } from '@angular/core';
import {Discount} from './models/Discount';
import {Product} from './models/Product';
import { Router } from '@angular/router';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'add-discount',
  templateUrl: 'addDiscount.html'
})
export class AddDiscountComponent {

  discount1: Discount = new Discount();
  hidden = false;
  productId: number;
  products: Product;

    constructor(private service: AdminService, private route:Router) {}




    // tslint:disable-next-line: use-life-cycle-interface
    ngOnInit(): void {
       this.discount1.discountId = 0;
       this.productId = 0;

       }

       newDiscount(): void {

        window.location.reload();

      }

      save() {

this.service
         .findProduct(this.productId)
         .subscribe(products => {
           this.products = products;
          console.log(this.products);
          this.discount1.product = this.products;

         this.service.addDiscount(this.discount1)
           .subscribe(data => console.log(data), error => console.log(error));
        });
      }

      onSubmit() {
        this.hidden = true;
        this.save();
      }

      backtodiscount()
  {
  this.route.navigate(['showDiscount']);

  }



}
