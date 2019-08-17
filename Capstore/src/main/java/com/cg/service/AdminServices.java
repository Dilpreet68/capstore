package com.cg.service;



import java.util.List;

import com.cg.bean.Discount;
import com.cg.bean.Merchant;
import com.cg.bean.Product;

import com.cg.bean.Promocode;
import com.cg.bean.User1;







public interface AdminServices {
	
	//---------------------------------------------Discount-----------------------------------------------------
	public Discount addDiscount(Discount discount); 
	public void removeDiscount(int discountId);
	public Discount findDiscount(int discountId);
	public List<Discount> AllDiscounts();
	public void updateDiscount(Discount discount);
	//-----------------------------------------------------------------------------------------------------------
	
	//-----------------------------------User------------------------------------------------------------------------
	public List<User1> AllUsers();
	public void removeUser(int userId);
	//-----------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------Merchant----------------------------------------------------------
	public List<Merchant> AllMerchants();
	public void removeMerchant(int merchantId);
	//-----------------------------------------------------------------------------------------------------------
		
		
	//----------------------------------------------------Product-------------------------------------------------------
	public List<Product> AllProducts();
	public void removeProduct(int productId);
	public Product findProduct(int productId);
	//-----------------------------------------------------------------------------------------------------------
		
	//-----------------------------------------------------PromoCode---------------------------------------------
	
	public void addPromo(Promocode promo);
	public void deletePromo(int id);
	public List<Promocode> getAllPromos();

	//------------------------------------------------------------------------------------
	
}
