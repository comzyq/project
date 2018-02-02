package com.project.common.route;

import com.jfinal.config.Routes;
import com.project.action.admin.AContactUsAction;
import com.project.action.admin.AIndexAction;
import com.project.action.admin.AInformationAction;
import com.project.action.admin.AProductAction;
import com.project.action.admin.AdminAction;
import com.project.common.interceptor.AdminInterceptor;

public class AdminRoute extends Routes{

	@Override
	public void config() { 
		addInterceptor(new AdminInterceptor());  //添加拦截器 
		add("/admin",AdminAction.class);
		add("/admin/index",AIndexAction.class);  
		add("/admin/infor",AInformationAction.class);
		add("/admin/product",AProductAction.class);
		add("/admin/contact_us",AContactUsAction.class);
	}

}
