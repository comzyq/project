package com.project.DAO;


import java.util.List;

import com.jfinal.plugin.activerecord.Page;
import com.project.model.TInformation;

public class ContactUsDAO {

	/**
	 * 获取分页信息
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TInformation> getTInformationPage(int pageNum,int countNum){
		Page<TInformation> infPage = TInformation.dao.paginate(pageNum, countNum, "select * ", "from t_information where type_code=? ","indexPhoto");
		return infPage;
	}
	
	public List<TInformation> getContactUs(){
		List<TInformation> info = TInformation.dao.find("select * from t_information where type_code='contactUs'");
		return info;
	}
	
	
}
