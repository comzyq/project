package com.project.action;

import com.jfinal.core.Controller;
import com.project.BO.AIndexBO;
import com.project.BO.AInformationBO;
import com.project.BO.AProductBO; 

public class IndexAction extends Controller {

	public void index(){
		
		int pageNum = 1;
		int countNum = 5;
		
		AIndexBO aib = new AIndexBO(); 
		
		//焦点图
		setAttr("infPage", aib.getTInformationPage(1, 5));
		 
		AInformationBO aif = new AInformationBO();
 
		//企业介绍
		setAttr("qyjs", aif.getTInformationFristByTypeCode("qyjs"));
		
		//企业新闻
		setAttr("qyxwPage", aif.getTInformationPageByType(pageNum, countNum, "qyxw"));
		
		//行业新闻
		setAttr("hyxwPage", aif.getTInformationPageByType(pageNum, countNum, "hyxw"));
		
		//劳务资讯
		setAttr("lwzxPage", aif.getTInformationPageByType(pageNum, countNum, "lwzx")); 
		
		//派遣知识
		setAttr("pqzsPage", aif.getTInformationPageByType(pageNum, countNum, "pqzs"));
		
		
		//合作企业

		AProductBO apb = new AProductBO(); 
		setAttr("apbPage", apb.getTProductsPageByProductCode(pageNum, countNum, "hzqy"));
		
		setAttr("selHw",1);
		renderTemplate("index.html");
	}
}
