package com.project.common.route;

import com.jfinal.config.Routes;
import com.project.action.CollaborationAction;
import com.project.action.CompanyProfileAction;
import com.project.action.ContactUsAction;
import com.project.action.FlashAction;
import com.project.action.IndexAction;
import com.project.action.NewsAction;
import com.project.action.RecruitmentAction;

public class IndexRoute extends Routes{

	@Override
	public void config() {
		// TODO Auto-generated method stub 
		add("/",FlashAction.class,"/project"); 
		add("/index",IndexAction.class,"/project"); 
		add("/contactUS",ContactUsAction.class,"/project"); 
		add("/companyProfile",CompanyProfileAction.class,"/project");
		add("/news",NewsAction.class,"/project"); 
		add("/collaboration",CollaborationAction.class,"/project");
		add("/recruitment",RecruitmentAction.class,"/project");
		
	}

}
