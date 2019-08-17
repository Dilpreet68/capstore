package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bean.Promocode;




@Repository
public interface IPromoDao extends JpaRepository<Promocode, Integer>{
	

}
