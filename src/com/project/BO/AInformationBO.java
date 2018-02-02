package com.project.BO;

import com.jfinal.plugin.activerecord.Page;
import com.project.DAO.AInformationDAO;
import com.project.model.TInformation;

public class AInformationBO {

	/**
	 * 获取分页信息
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TInformation> getTInformationPage(int pageNum,int countNum,String typeCode){
		return new AInformationDAO().getTInformationPage(pageNum, countNum, typeCode);
	}
	
	
	/**
	 * 获取分页信息
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TInformation> getTInformationPageByType(int pageNum,int countNum,String typeCode){
		return new AInformationDAO().getTInformationPageByType(pageNum, countNum, typeCode);
	}
	
	
	/**
	 * 根据类型获取第一条数据
	 * @param typeCode
	 * @return
	 */
	public TInformation getTInformationFristByTypeCode(String typeCode){
		return new AInformationDAO().getTInformationFristByTypeCode(typeCode);
	}
	 
}
