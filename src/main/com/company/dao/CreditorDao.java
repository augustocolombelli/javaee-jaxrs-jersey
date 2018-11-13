package com.company.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.company.model.Creditor;

public class CreditorDao {

	private static Map<Integer, Creditor> creditorsDataBase = new HashMap<Integer, Creditor>();
	
	static {
		creditorsDataBase.put(1, new Creditor(1, "Augusto", Calendar.getInstance(), 12346));
		creditorsDataBase.put(2, new Creditor(2, "Heitor", Calendar.getInstance(), 64654));
		creditorsDataBase.put(3, new Creditor(3, "Jessica", Calendar.getInstance(), 654645));
	}

	public Creditor findById(Integer id) {
		return creditorsDataBase.get(id);
	}
	
	public void insert(Creditor creditor) {
		creditorsDataBase.put(creditor.getId(), creditor);
	}
	
	public void remove(Creditor creditor) {
		creditorsDataBase.remove(creditor.getId());
	}
}
