package com.cg.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.cg.dao.DiscountDAO;
import com.cg.dao.IPromoDao;
import com.cg.dao.MerchantDAO;
import com.cg.dao.ProductDAO;
import com.cg.dao.User1DAO;
import com.cg.exception.ApplicationException;
import com.cg.bean.Discount;
import com.cg.bean.Merchant;
import com.cg.bean.Product;

import com.cg.bean.Promocode;
import com.cg.bean.User1;





@Service
@Transactional
public class AdminServicesImpl implements AdminServices {
	


//---------------------------------------------------------------------Discount----------------------------------------------------------------------------------------------------------------	
	@Autowired
	private DiscountDAO discountDAO;

	
	@Override
	@Transactional
	public Discount addDiscount(Discount discount) {
		
		return discountDAO.save(discount);
	}
	
	
	@Override
	@Transactional
	public void removeDiscount(int discountId) {
		 discountDAO.deleteById(discountId);
		}
	
	@Override
	@Transactional
	public List<Discount> AllDiscounts() {
		return discountDAO.findAll();
	}

	
	@Override
	public Discount findDiscount(int discountId) {
		Discount d=discountDAO.findById(discountId).get();
		if(d==null)
		{
			throw new ApplicationException ("Discount not Found");
		}
		else {
			  return d ;
		   }
		
	}

	@Override
	public void updateDiscount(Discount discount) {
		// TODO Auto-generated method stub
		
		
		this.removeDiscount(discount.getDiscountId());
		this.addDiscount(discount);
	
		
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Autowired
	private User1DAO userDAO;

	@Override
	public List<User1> AllUsers() {
		// TODO Auto-generated method stub
		
		return userDAO.findAll() ;
	}
	
	@Override
	@Transactional
	public void removeUser(int userId) {
		
		 userDAO.deleteById(userId);
	}
	
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Autowired
	private MerchantDAO merchantDAO;
	//Method to display the customer details

		

		@Override
		public List<Merchant> AllMerchants() {
			// TODO Auto-generated method stub
		return merchantDAO.findAll();
		}
		
		
		@Override
		@Transactional
		public void removeMerchant(int merchantId) {
			
			merchantDAO.deleteById(merchantId);
			
		}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		@Autowired
		private ProductDAO productDAO;
		@Override
		public List<Product> AllProducts() {
			// TODO Auto-generated method stub
			
			return productDAO.findAll();
		}

		
		@Override
		@Transactional
		public void removeProduct(int productId) {
			productDAO.deleteById(productId);
			
		}

		@Override
		public Product findProduct(int productId) {
			// TODO Auto-generated method stub
			return productDAO.findById(productId).get();
		}

		
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	

	
//--------------------------------------------------------------------------------------------Promocode--------------------------------------------------------
		@Autowired
		IPromoDao promoDao;
		
		@Override
		public void addPromo(Promocode promo) {
			// TODO Auto-generated method stub
			promoDao.save(promo);	
			
		}

		@Override
		public List<Promocode> getAllPromos() {
			// TODO Auto-generated method stub
			return promoDao.findAll();
		}


		@Transactional(propagation = Propagation.REQUIRED)
		public void deletePromo(int id) {
			// TODO Auto-generated method stub
			if (promoDao.existsById(id)) {
		         promoDao.deleteById(id);
			} else {
				System.out.println("Id not found");
			}
		}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	

	
}
