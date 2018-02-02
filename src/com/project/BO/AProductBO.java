package com.project.BO;

import com.jfinal.plugin.activerecord.Page;
import com.project.DAO.AProductDAO;
import com.project.model.TProducts;

public class AProductBO {

	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TProducts> getTProductsPage(int pageNum, int countNum, String typeCode){
		return new AProductDAO().getTProductsPage(pageNum, countNum, typeCode);
	}
	
	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TProducts> getTProductsPageByProductCode(int pageNum, int countNum, String productCode) {
		return new AProductDAO().getTProductsPageByProductCode(pageNum, countNum, productCode);
	}
}
