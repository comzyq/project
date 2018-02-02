package com.project.action;
 

import com.jfinal.core.Controller;
import com.project.model.TContactUs; 

public class ContactUsAction extends Controller {

	public void index(){
		   
		TContactUs  tcu = new TContactUs();
		
		tcu = new TContactUs().dao().findById("1");
		
		setAttr("tcu", tcu);
		setAttr("selHw",8);
	    
		renderTemplate("contact_us.html");
	}
}
