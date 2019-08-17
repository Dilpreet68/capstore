package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bean.Discount;
import com.cg.bean.Merchant;
import com.cg.bean.Product;

import com.cg.bean.Promocode;
import com.cg.bean.User1;

import com.cg.service.AdminServices;

@CrossOrigin()
@RestController
@RequestMapping("/admin")
public class AdminActionController {
	
	

	@Autowired
	private AdminServices adminService;
	
		
	

  // ------------------------------------------------Discount----------------------------------------------------------------------------------- 
	/*
	 * Discount given by admin on particular product
	 * 
	 */
	
	@GetMapping(value = "/AllDiscounts")
	public List<Discount> AllDiscounts() {
     
      return adminService.AllDiscounts();
	}
	
	@GetMapping(value = "/findDiscount/{discountId}")
	public Discount findDiscount(@PathVariable("discountId") int discountId) {
     
      return adminService.findDiscount(discountId);
	}
	
	
	@PostMapping(value = "/addDiscount",consumes= {"application/json"})
	public String addDiscount(@RequestBody Discount discount) {
     
        
		adminService.addDiscount(discount);
		return "Discount Added";
	}
	
	@PutMapping(value = "/updateDiscount",consumes= {"application/json"})
	public String updateDiscount(@RequestBody Discount discount) {
     
        
		adminService.updateDiscount(discount);
		return "Discount updated";
	}

	@DeleteMapping("/deleteDiscount/{discountId}")
	public String removeDiscount(@PathVariable("discountId") int discountId) {
		adminService.removeDiscount(discountId);
		return "Discount deleted";
	}
	
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------

	
	
	//--------------------------------------------User---------------------------------------------------------------------------------
	@GetMapping(value = "/AllUsers")
	public List<User1> AllUsers() {
		// to view all the available customers
		
		return adminService.AllUsers();
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String removeUser(@PathVariable("userId") int userId) {
		adminService.removeUser(userId);
		return "User deleted";
	}

	//---------------------------------------------------------------------------------------------------------------------------------------
	
	
	//----------------------------------------------------------Merchant-------------------------------------------------------------------
	@GetMapping(value = "/AllMerchants")
	public List<Merchant> AllMerchants() {
		// to view all the available customers
		
		return adminService.AllMerchants();
	}
	
	@DeleteMapping("/deleteMerchant/{merchantId}")
	public String removeMerchant(@PathVariable("merchantId") int merchantId) {
		adminService.removeMerchant(merchantId);
		return "Merchant deleted";
	}

	
	//----------------------------------------------------------------------------------------------------------------------------------------
	
	
	//-----------------------------------------------------------------Product---------------------------------------------------------------
	@GetMapping(value = "/AllProducts")
	public List<Product> AllProducts() {
		// to view all the available customers
		
		return adminService.AllProducts();
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String removeProduct(@PathVariable("productId") int productId) {
		adminService.removeProduct(productId);
		return "Product deleted";
	}
	
	@GetMapping(value = "/findProduct/{productId}")
	public Product findProduct(@PathVariable("productId") int productId) {
     
      return adminService.findProduct(productId);
	}
	

    //----------------------------------------------------------------------------------------------------------------------------------------------


  //---------------------------------------------------------------------------PromoCode-----------------------------------------------------------
	@GetMapping("/AllPromocodes") // Get mapping for getting list of sessions
	public List<Promocode>  getAllPromos() {
		return adminService. getAllPromos();
	}
	
	@PostMapping(value = "/addPromocode", consumes = { "application/json" }) // to add session into the database
	public String save(@RequestBody Promocode p) {
		adminService.addPromo(p);
		return "Promo added!";
	}
	
	@DeleteMapping(value = "/deletePromoCode/{id}") // to delete session from database using id
	public String deleteUser(@PathVariable int id) {
		adminService.deletePromo(id);
		return "Promo deleted";
	}

	
	//-------------------------------------------------------------------------------------------------------------------------------------



}
