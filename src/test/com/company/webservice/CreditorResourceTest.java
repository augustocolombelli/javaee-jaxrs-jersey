package com.company.webservice;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.Server;
import com.company.model.Creditor;
import com.thoughtworks.xstream.XStream;

public class CreditorResourceTest {

	private HttpServer server;
	
	@Before
	public void setUp() {
		server = Server.initServer();
	}
	
	@After
	public void after() {
		server.shutdown();
	}
	
	@Test
	public void shouldReturnOneCreditor() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/");
		String content = target.path("creditors").request().get(String.class);
		
		Creditor creditor = (Creditor) new XStream().fromXML(content);
		
		assertEquals("Augusto", creditor.getName());
	}
	
}
