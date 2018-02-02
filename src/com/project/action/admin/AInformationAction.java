package com.project.action.admin;

import java.util.Date;

import com.jfinal.core.Controller;
import com.project.BO.AInformationBO;
import com.project.model.TInformation;
import com.project.model.TUser;

public class AInformationAction extends Controller{

	public void index(){
		 
		String typeCode = getPara("typeCode");
		String typeJump = getPara("typeJump");
		 
		int countNum = 10;
		AInformationBO aib = new AInformationBO(); 
		
		int pageNum =  getParaToInt("pageNum",1);
		
		setAttr("typeCode", typeCode);
		
		setAttr("infPage", aib.getTInformationPage(pageNum, countNum, typeCode));
		
		renderTemplate("/admin/"+typeJump+".html"); 
		
	}
	
	
	public void get_object(){
		
		String id = getPara("id","");   
		String typeJump = getPara("typeJump"); 
		String typeCode = getPara("typeCode");
		
		TInformation infor = new TInformation().dao().findById(id);
		

		setAttr("typeCode", typeCode);
		setAttr("typeJump", typeJump);
		setAttr("infor", infor);
		
		renderTemplate("/admin/"+typeJump+".html"); 
	}
	
	public void save(){
		

		TUser user = getSessionAttr("loginUser");
		
		String typeJump = getPara("typeJump");
		String typeCode = getPara("typeCode");
		 
		TInformation infor = getModel(TInformation.class,"infor");
		
		if(infor.getId() != null && !infor.getId().equals("")){
			infor.setModifyDate(new Date());
			infor.setModifyUse(user.getUsername());
			infor.update();
		}else{
			infor.setCreateDate(new Date());
			infor.setCreateUse(user.getUsername());
			infor.save();
		} 
		

	   setAttr("typeCode", typeCode); 
	   redirect("/admin/infor?typeCode="+ typeCode + "&typeJump=" + typeJump); 
	}
	
	public void delObject(){

		String typeJump = getPara("typeJump");
		String typeCode = getPara("typeCode");
		
		int id = getParaToInt("id",0); 
	    new TInformation().dao().deleteById(id);
		 
	    setAttr("typeCode", typeCode); 
	    redirect("/admin/infor?typeCode="+ typeCode + "&typeJump=" + typeJump);
	}
	
}
