package com.project.action;

import com.jfinal.core.Controller;

public class FlashAction  extends Controller{

	public void index(){
		renderTemplate("flash.html");
	}
}
