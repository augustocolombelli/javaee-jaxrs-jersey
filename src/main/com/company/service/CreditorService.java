package com.company.service;

import com.company.dao.CreditorDao;
import com.company.model.Creditor;

public class CreditorService {

	private CreditorDao dao = new CreditorDao();
	
	public Creditor findById(Integer id) {
		return dao.findById(id);
	}
	
}
