package com.company;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {

	public static void main(String[] args) {
		try {
			HttpServer server = initServer();
			System.out.println("Server is running");
			System.in.read();
			server.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static HttpServer initServer() {
		ResourceConfig config = new ResourceConfig().packages("com.company");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}

}
