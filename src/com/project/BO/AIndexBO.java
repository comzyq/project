package com.project.BO;

import com.jfinal.plugin.activerecord.Page;
import com.project.DAO.AIndexDAO;
import com.project.model.TInformation;

public class AIndexBO {

	/**
	 * 获取分页信息
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TInformation> getTInformationPage(int pageNum,int countNum){
		return new AIndexDAO().getTInformationPage(pageNum, countNum);
	}
}
