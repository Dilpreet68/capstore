import {Router, RouterModule, Routes} from '@angular/router'

import { AddDiscountComponent } from './addDiscount';
import {Admin} from './admin.component';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { NgModule } from '@angular/core';
import {ShowDiscountComponent} from './showDiscount';
import {ShowMerchantComponent} from './showMerchant';
import {ShowProductComponent} from './showProduct';
import { ShowPromocodeComponent } from './showPromocode';
import {ShowUserComponent} from './showUser';

const routes:Routes=[{path:'',redirectTo:'admin',pathMatch:'full'},
  {path:'showUser',component:ShowUserComponent},
{path:'admin',component:Admin},
{path:'showMerchant',component:ShowMerchantComponent},
{path:'showProduct',component:ShowProductComponent},
{path:'showDiscount',component:ShowDiscountComponent},
{path:'addDiscount',component:AddDiscountComponent},
{path:'showPromocode',component:ShowPromocodeComponent}


];
@NgModule({
    imports: [
        BrowserModule,RouterModule.forRoot(routes),
        FormsModule,HttpClientModule

    ],
    declarations: [
        AppComponent, ShowUserComponent, ShowMerchantComponent, ShowProductComponent, ShowDiscountComponent, AddDiscountComponent, ShowPromocodeComponent, Admin],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }
