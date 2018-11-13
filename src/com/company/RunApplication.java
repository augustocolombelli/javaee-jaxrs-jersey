package com.company;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RunApplication {

	public static void main(String[] args) {
		try {
			ResourceConfig config = new ResourceConfig().packages("com.company");
			URI uri = URI.create("http://localhost:8080/");
			HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
			System.out.println("Server is running");
			System.in.read();
			server.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	public static void t(String[] args) {
//		CreditorService creditorService = new CreditorService();
//
//		for (Creditor creditor : creditorService.getAll()) {
//			System.out.println("============================================");
//			System.out.println("Id: " + creditor.getId());
//			System.out.println("Name: " + creditor.getName());
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//			System.out.println("Birth: " + simpleDateFormat.format(creditor.getBirth().getTime()));
//			System.out.println("Document Number:" + creditor.getDocumentNumber());
//		}
//
//	}

}
