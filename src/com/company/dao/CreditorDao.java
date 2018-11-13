package com.company.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.company.model.Creditor;

public class CreditorDao {

	private static List<Creditor> creditorsDataBase = new ArrayList<Creditor>();

	{
		creditorsDataBase.add(new Creditor(1, "Augusto", Calendar.getInstance(), 12346));
		creditorsDataBase.add(new Creditor(2, "Heitor", Calendar.getInstance(), 64654));
		creditorsDataBase.add(new Creditor(3, "Jessica", Calendar.getInstance(), 654645));
	}

	public List<Creditor> getAll() {
		return creditorsDataBase;
	}
}
