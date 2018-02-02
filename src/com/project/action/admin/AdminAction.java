package com.project.action.admin;


import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.project.model.TUser;
import com.project.model.base.BaseTUser;

public class AdminAction extends Controller {
 
	 
	public void index(){ 
		 renderTemplate("/admin/login.html");
	}
	 
	public void login(){
		 
		 
		
		//给一个别名, 这个别名需要个前端的 name 名字大小写都一样 .
		TUser pageUser = getModel(TUser.class,"tuser");
		
		
		
//		Record user = Db.findById("t_user", "username", pageUser.getUsername());
		
		TUser user =  new TUser().dao().findFirst(" select * from t_user where username = ?",pageUser.getUsername());
		
		//设置SESSION 
		setSessionAttr("loginUser", user);  
		 
		 
		 if(user == null){
			 renderTemplate("/admin/login.html"); 
		 }else{
			 if(user.getStr("password").equals(pageUser.getPassword())){
				 forwardAction("/admin/index");
			 }else{
				 renderTemplate("/admin/login.html");
			 }
				 
		 }
		 
		
	}
	
	 
	
	
}
