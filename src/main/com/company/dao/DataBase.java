package com.company.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.company.model.AccountBank;
import com.company.model.Creditor;

public class DataBase {

	private Map<Integer, Creditor> creditorsDataBase;

	public DataBase() {
		creditorsDataBase = new HashMap<Integer, Creditor>();

		try {
			AccountBank santander = new AccountBank();
			santander.setId(1);
			santander.setAccount(12344);
			santander.setAgency(522);

			AccountBank itau = new AccountBank();
			itau.setId(2);
			itau.setAccount(8585);
			itau.setAgency(122);

			SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

			Creditor creditor1 = new Creditor(1, "Augusto", sfd.parse("20/10/1987"), 12);
			creditor1.addAccountBank(itau);
			creditor1.addAccountBank(santander);

			Creditor creditor2 = new Creditor(2, "Heitor", sfd.parse("20/10/1991"), 23);
			Creditor creditor3 = new Creditor(3, "Jessica", sfd.parse("20/10/2018"), 34);

			creditorsDataBase.put(1, creditor1);
			creditorsDataBase.put(2, creditor2);
			creditorsDataBase.put(3, creditor3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Map<Integer, Creditor> getCreditorsDataBase() {
		return creditorsDataBase;
	}
}
