package com.company.dao;

import com.company.model.Creditor;

public class CreditorDao {

	private static DataBase dataBase = new DataBase();
	
	public Creditor findById(Integer id) {
		return dataBase.getCreditorsDataBase().get(id);
	}

	public Creditor insert(Creditor creditor) {
		dataBase.getCreditorsDataBase().put(creditor.getId(), creditor);
		return creditor;
	}

	public void remove(Creditor creditor) {
		dataBase.getCreditorsDataBase().remove(creditor.getId());
	}
}
