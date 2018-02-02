package com.project.action;

import com.jfinal.core.Controller;
import com.project.BO.AInformationBO;

public class CompanyProfileAction  extends Controller {

	public void index(){
		AInformationBO aif = new AInformationBO();
		 
		setAttr("qyjs", aif.getTInformationFristByTypeCode("qyjs"));
		
		setAttr("qyzz", aif.getTInformationFristByTypeCode("qyzz"));
		

		setAttr("selHw",2);
		renderTemplate("company_profile.html");
	}
}
