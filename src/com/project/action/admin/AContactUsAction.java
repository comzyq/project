package com.project.action.admin;

import com.jfinal.core.Controller;
import com.project.model.TContactUs;

public class AContactUsAction extends Controller{

	public void index(){ 
		TContactUs  tcu = new TContactUs();
		
		tcu = new TContactUs().dao().findById("1");
		
		setAttr("tcu", tcu);
				
		renderTemplate("/admin/contact_us_add.html"); 
	}
	
	
	public void save(){
		
		TContactUs tcu = getModel(TContactUs.class,"tcu");
		tcu.update();
		redirect("/admin/contact_us"); 
	}
}
