package com.company.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Creditor {

	private Integer id;
	private String name;
	private Date birth;
	private Integer documentNumber;
	private List<AccountBank> accountsBank;

	public Creditor() {
		this.accountsBank = new ArrayList<AccountBank>();
	}

	public Creditor(Integer id, String name, Date birth, Integer documentNumber) {
		this.accountsBank = new ArrayList<AccountBank>();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.documentNumber = documentNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

	public List<AccountBank> getAccountsBank() {
		return accountsBank;
	}

	public void addAccountBank(AccountBank accountBank) {
		this.accountsBank.add(accountBank);
	}

	public void removeAccountBank(Integer accountId) {
		AccountBank accountBankToRemove = null;
		for (AccountBank accountBank : accountsBank) {
			if (accountBank.getId() == accountId) {
				accountBankToRemove = accountBank;
			}
		}
		this.accountsBank.remove(accountBankToRemove);
	}

}
