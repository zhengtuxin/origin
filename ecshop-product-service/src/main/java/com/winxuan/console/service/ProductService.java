package com.winxuan.console.service;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.winxuan.console.model.ProductSale;
import com.winxuan.console.repository.ProductSaleRepository;
import com.winxuan.console.util.FileUtil;

/**
 * @ClassName:ProductService.java 
 * @Description: 
 * @author: wangpanyong
 * @date: 2015年12月14日
 */
@Service("productService")
@Transactional(rollbackFor = Exception.class)
public class ProductService {

	@Autowired
	ProductSaleRepository productSaleRepository;
	
	public void priceRecover(String ids) throws Exception{
		List<String> idList = Arrays.asList(StringUtils.split(ids, "\n"));
		valiAndUpdate(idList);
	}

	public void priceRecover(File destinationFile) throws Exception{
		List<String> idList = FileUtil.readFileForList(destinationFile);
		valiAndUpdate(idList);
	}
	
	private void valiAndUpdate(List<String> idList) throws Exception{
		//验证上传的id是否全部是数值
		for (int i = 0; i < idList.size(); i++) {
			if(!NumberUtils.isDigits(idList.get(i))){
				throw new Exception("第"+ (i+1) +"行不是数值 ：" + idList.get(i));
			}
		}
		List<Long> listBatch = Lists.newArrayList();
		//批量处理
		for (int i = 0; i < idList.size(); i++) {
			listBatch.add(Long.valueOf(idList.get(i)));
			if((i+1)%200 == 0){
				productSaleRepository.priceRecover(listBatch);
				listBatch.clear();
			}
		}
		if(!listBatch.isEmpty())
			productSaleRepository.priceRecover(listBatch);
	}
}
