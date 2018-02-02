package com.project.DAO;

import com.jfinal.plugin.activerecord.Page;
import com.project.model.TProducts;

public class AProductDAO {
	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TProducts> getTProductsPage(int pageNum, int countNum, String typeCode) {
		Page<TProducts> productPage = null;
		
		String froms = "from t_products where product_code in (select type_code from t_products_type where type = ?)";
		productPage = TProducts.dao.paginate(pageNum, countNum, "select * ", froms, typeCode);
 
		return productPage;
	}
	
	
	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TProducts> getTProductsPageByProductCode(int pageNum, int countNum, String productCode) {
		Page<TProducts> productPage = null;
		
		String froms = "from t_products where product_code = ?";
		productPage = TProducts.dao.paginate(pageNum, countNum, "select * ", froms, productCode);
 
		return productPage;
	}
}
