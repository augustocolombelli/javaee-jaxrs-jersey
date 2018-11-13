package com.company;

import java.text.SimpleDateFormat;

import com.company.model.Creditor;
import com.company.service.CreditorService;

public class RunApplication {

	public static void main(String[] args) {
		CreditorService creditorService = new CreditorService();

		for (Creditor creditor : creditorService.getAll()) {
			System.out.println("============================================");
			System.out.println("Id: " + creditor.getId());
			System.out.println("Name: " + creditor.getName());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Birth: " + simpleDateFormat.format(creditor.getBirth().getTime()));
			System.out.println("Document Number:" + creditor.getDocumentNumber());
		}

	}

}
