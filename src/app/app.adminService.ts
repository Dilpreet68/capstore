import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, from} from 'rxjs';

import { Discount } from './models/Discount';
import { Injectable } from '@angular/core';
import { Merchant } from './models/Merchant';
import { Product } from './models/Product';
import {Promo} from './models/Promo';
import { User } from './models/User';

// tslint:disable-next-line: prefer-const
let baseUrl = 'http://localhost:3000/admin';

@Injectable({
    providedIn: 'root'
})

export class AdminService {
    constructor(private http: HttpClient) {}



    getUser() {
          return this.http.get<User[]>(baseUrl + '/AllUsers');
    }

    deleteUser(userId: number ) {
      return this.http.delete(`${baseUrl}/deleteUser/${userId}`);
    }
//-------------------------------------------------------------------------------------------------------------------------
    getMerchant() {
          return this.http.get<Merchant[]>(baseUrl + '/AllMerchants');
    }
    deleteMerchant(merchantId: number ) {
      return this.http.delete(`${baseUrl}/deleteMerchant/${merchantId}`);
    }


//--------------------------------------------------------------------Product------------------------------------------------
    getProduct() {
    return this.http.get<Product[]>(baseUrl + "/AllProducts");
    }

    deleteProduct(productId: number ) {
      return this.http.delete(`${baseUrl}/deleteProduct/${productId}`);
    }

    findProduct(productId: number ) : Observable<any> {
      return this.http.get(`${baseUrl}/findProduct/${productId}`);
    }

    //---------------------------------------Discount----------------------------------------------------

    getDiscount() {
      return this.http.get<Discount[]>(baseUrl + "/AllDiscounts");
      }

    deleteDiscount(discountId: number ) {
     return this.http.delete(`${baseUrl}/deleteDiscount/${discountId}`);
   }

   addDiscount(discount2: Discount): Observable<Object> {
    return this.http.post(`${baseUrl}/addDiscount`, discount2);
  }

  updateDiscount(discount2: Discount): Observable<Object> {
    return this.http.put(`${baseUrl}/updateDiscount`, discount2);
  }

   //------------------------------------------------------------------------------------------------------------


//---------------------------------------------------------PromoCodes-------------------------------------------

acc:Promo;
    addPromocode(pro: Promo) :Observable<Promo>
    {

         return this.http.post<Promo>(baseUrl+ "/addPromocode",pro);
    }

    getPromocodes()
    {
          return this.http.get<Promo[]>(baseUrl+"/AllPromocodes");
    }

    deletePromocode(promocodeId:number)
    {

        return this.http.delete<Promo>(baseUrl+"/deletePromocode/"+promocodeId);

    }
    //--------------------------------------------------------------------------------------------

}

