package com.winxuan.console.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 销售商品
 * 
 * @ClassName:ProductSale.java
 * @Description:
 * @author: wangpanyong
 * @date: 2015年11月27日
 */
@Entity
@Table(name = "product_sale")
public class ProductSale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "saleprice")
	private BigDecimal salePrice;

	@Column(name = "basicprice")
	private BigDecimal basicPrice;
	
	@Column(name = "sellname")
	private String sellName;

	@Column
	private String subheading;

	@Column(name = "stockquantity")
	private int stockQuantity;

	@Column(name = "salequantity")
	private int saleQuantity;

	@Column(name = "outerid")
	private String outerId;

	/**
	 * 供应商
	 */
	@Column(name = "vendor")
	private String vendor;

	/**
	 * 促销中单个用户可购买量
	 */
	@Column(name = "restrictquantity")
	private int restrictQuantity;

	@Column(name = "promotionprice")
	private BigDecimal promotionPrice;

	/**
	 * 促销总量
	 */
	@Column(name = "promotionstotal")
	private int promotionsTotal;

	@Column(name = "promstarttime")
	private Date promotionStartTime;

	@Column(name = "promendtime")
	private Date promotionEndTime;

	@Column(name = "hasshopcategory")
	private int hasShopCategory;

	@Column(name = "updatetime")
	private Date updateTime;

	@Column(name = "promvalue")
	private String promValue;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getSellName() {
		return sellName;
	}

	public void setSellName(String sellName) {
		this.sellName = sellName;
	}

	public String getSubheading() {
		return subheading;
	}

	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}

	public BigDecimal getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(BigDecimal basicPrice) {
		this.basicPrice = basicPrice;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getSaleQuantity() {
		return saleQuantity;
	}

	public void setSaleQuantity(int saleQuantity) {
		this.saleQuantity = saleQuantity;
	}

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public int getRestrictQuantity() {
		return restrictQuantity;
	}

	public void setRestrictQuantity(int restrictQuantity) {
		this.restrictQuantity = restrictQuantity;
	}

	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public int getPromotionsTotal() {
		return promotionsTotal;
	}

	public void setPromotionsTotal(int promotionsTotal) {
		this.promotionsTotal = promotionsTotal;
	}

	public Date getPromotionStartTime() {
		return promotionStartTime;
	}

	public void setPromotionStartTime(Date promotionStartTime) {
		this.promotionStartTime = promotionStartTime;
	}

	public Date getPromotionEndTime() {
		return promotionEndTime;
	}

	public void setPromotionEndTime(Date promotionEndTime) {
		this.promotionEndTime = promotionEndTime;
	}

	public int getHasShopCategory() {
		return hasShopCategory;
	}

	public void setHasShopCategory(int hasShopCategory) {
		this.hasShopCategory = hasShopCategory;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPromValue() {
		return promValue;
	}

	public void setPromValue(String promValue) {
		this.promValue = promValue;
	}

}
