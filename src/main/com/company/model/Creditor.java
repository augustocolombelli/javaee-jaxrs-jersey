package com.company.model;

import java.util.Calendar;

import com.thoughtworks.xstream.XStream;

public class Creditor {

	private Integer id;
	private String name;
	private Calendar birth;
	private Integer documentNumber;

	public Creditor() {
	}

	public Creditor(Integer id, String name, Calendar birth, Integer documentNumber) {
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

	public Calendar getBirth() {
		return birth;
	}

	public void setBirth(Calendar birth) {
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

}
