package com.company.service;

import java.util.List;

import com.company.dao.CreditorDao;
import com.company.model.Creditor;

public class CreditorService {

	private CreditorDao dao = new CreditorDao();
	
	public List<Creditor> getAll(){
		return dao.getAll();
	}
	
	public Creditor findById(Integer id) {
		return dao.findById(id);
	}
	
}
