package com.project.BO;

import java.util.List;

import com.project.DAO.ContactUsDAO;
import com.project.model.TInformation;

public class ContactUsBO {

	public List<TInformation> getContactUs(){
		return new ContactUsDAO().getContactUs();
	}
	
	
}
