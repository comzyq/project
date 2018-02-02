package com.project.DAO;
 
import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Page;
import com.project.model.TInformation;

public class AInformationDAO {

	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TInformation> getTInformationPage(int pageNum, int countNum, String typeCode) {
		Page<TInformation> infPage = null;
		
		String froms = "from t_information where type_code in (select information_code from t_information_type where type = ?)";
       infPage = TInformation.dao.paginate(pageNum, countNum, "select * ", froms, typeCode);
 
		return infPage;
	}
	
	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param countNum
	 * @return
	 */
	public Page<TInformation> getTInformationPageByType(int pageNum, int countNum, String typeCode) {
		Page<TInformation> infPage = null;
		
		String froms = "from t_information where type_code = ?";
       infPage = TInformation.dao.paginate(pageNum, countNum, "select * ", froms, typeCode);
 
		return infPage;
	}
	
	
	
	/**
	 * 根据类型获取第一条数据
	 * @param typeCode
	 * @return
	 */
	public TInformation getTInformationFristByTypeCode(String typeCode){
		TInformation infor = new TInformation();
		
		Page<TInformation> infPage = null;
		String froms = "from t_information where type_code = ?";
		infPage = TInformation.dao.paginate(1, 1, "select * ", froms, typeCode);
		
		List<TInformation> inList =  infPage.getList();
		 
		
		return inList.size() > 0 ? inList.get(0) : null;
	}
}
