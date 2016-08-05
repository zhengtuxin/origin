package com.winxuan.console.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.winxuan.console.model.ProductSale;

/**
 * @ClassName:ProductRepository.java 
 * @Description: 
 * @author: wangpanyong
 * @date: 2015年12月14日
 */
public interface ProductSaleRepository extends JpaRepository<ProductSale, Long>{
	@Modifying
	@Query("update ProductSale set updatetime=now(), salePrice=basicPrice where id in :ids")
	void priceRecover(@Param("ids") List<Long> ids);
}
