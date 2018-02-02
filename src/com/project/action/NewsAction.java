package com.project.action;

import com.jfinal.core.Controller;
import com.project.BO.AInformationBO;
import com.project.model.TInformation;

public class NewsAction extends Controller {

	public void index() {

		String typeCode = getPara("typeCode");
		String typeJump = getPara("typeJump");
		
		Integer selHw = getParaToInt("selHw",0);

		int countNum = 10;
		AInformationBO aib = new AInformationBO();

		int pageNum = getParaToInt("pageNum", 1);

		setAttr("typeCode", typeCode);
		

		setAttr("selHw",selHw); 

		setAttr("infPage", aib.getTInformationPageByType(pageNum, countNum, typeCode));

		renderTemplate(typeJump + ".html");

	}
	
	
	public void list() {

		String typeCode = getPara("typeCode");
		String typeJump = getPara("typeJump");
		
		Integer selHw = getParaToInt("selHw",0);

		int countNum = 10;
		AInformationBO aib = new AInformationBO();

		int pageNum = getParaToInt("pageNum", 1);

		setAttr("typeCode", typeCode);
		

		setAttr("selHw",selHw); 

		setAttr("infPage", aib.getTInformationPageByType(pageNum, countNum, typeCode));
		setAttr("infPage", aib.getTInformationPageByType(pageNum, countNum, typeCode));
		setAttr("infPage", aib.getTInformationPageByType(pageNum, countNum, typeCode)); 

		renderTemplate(typeJump + ".html");

	}

	public void getNews() {

		String id = getPara("id", "");
		String typeJump = getPara("typeJump");
		String typeCode = getPara("typeCode");
		Integer selHw = getParaToInt("selHw",0);

		TInformation infor = new TInformation().dao().findById(id);
		
		Integer s = infor.getBrowseNum();
		
		if(s == null){
			s = 1;
		}
		
		infor.setBrowseNum(s+1);
		infor.update();

		setAttr("typeCode", typeCode);
		setAttr("typeJump", typeJump);
		setAttr("infor", infor); 
		setAttr("selHw",selHw); 

		renderTemplate( typeJump + ".html");
	}
}
