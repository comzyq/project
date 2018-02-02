package com.project.action;

import com.jfinal.core.Controller;
import com.project.BO.AProductBO;
import com.project.model.TProducts;

public class RecruitmentAction extends Controller {
	public void index() {

		String productCode = getPara("productCode");

		int countNum = 500;
		AProductBO apb = new AProductBO();

		int pageNum = getParaToInt("pageNum", 1);

		setAttr("selHw", 5);

		setAttr("apbPage", apb.getTProductsPageByProductCode(pageNum, countNum, productCode));

		renderTemplate("recruit.html");
	}

	public void info() {

		String id = getPara("id", "");
		String typeJump = getPara("typeJump");
		String typeCode = getPara("typeCode");

		TProducts product = new TProducts().dao().findById(id);

		setAttr("typeCode", typeCode);
		setAttr("typeJump", typeJump);
		setAttr("product", product);

		renderTemplate("collaboration-inform.html");
	}

}
