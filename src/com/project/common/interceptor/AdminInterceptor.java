package com.project.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class AdminInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("--拦截器-");

		// 登录不拦截
		if (inv.getMethod().getName().equals("login")) {
			inv.invoke(); // 拦截器继续执行
		} else {

			Controller controller = inv.getController();
			Object loginUser = controller.getSessionAttr("loginUser");
			
			if (loginUser != null ) {
				inv.invoke(); 
			} else {
				controller.render("/admin/login.html"); 
			}
		}

	}

}
