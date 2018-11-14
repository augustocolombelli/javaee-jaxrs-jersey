package com.company.webservice;

import static junit.framework.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.Server;
import com.company.model.Creditor;
import com.thoughtworks.xstream.XStream;

import junit.framework.Assert;

public class CreditorResourceTest {

	private HttpServer server;
	private Client client;
	
	@Before
	public void setUp() {
		server = Server.initServer();
		ClientConfig config= new ClientConfig();
		config.register(new LoggingFilter());
		client = ClientBuilder.newClient(config);
	}
	
	@After
	public void after() {
		server.shutdown();
	}
	
	@Test
	public void shouldReturnOneCreditor() {
		WebTarget target = client.target("http://localhost:8080/");
		String content = target.path("creditors/1").request().get(String.class);
		Creditor creditor = (Creditor) new XStream().fromXML(content);
		assertEquals("Augusto", creditor.getName());
	}
	
	@Test
	public void shouldInsertOneCreditor() throws ParseException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/");
		
		Creditor creditor = new Creditor();
		creditor.setId(new Random().nextInt());
		creditor.setName("Insert test");
		creditor.setDocumentNumber(new Random().nextInt());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		creditor.setBirth(sdf.parse("12/01/2018"));
		
		String creditorXML = creditor.toXML();
		
		Entity<String> entity = Entity.entity(creditorXML, MediaType.APPLICATION_XML);
		
		// Insere a nova entidade
		Response response = target.path("creditors").request().post(entity);
		
		// Faz uma nova busca com o link que ele retorna
		String location = response.getHeaderString("Location");
		String content = client.target(location).request().get(String.class);

		Assert.assertEquals(201, response.getStatus());
		Assert.assertTrue(content.contains("Insert test"));
	}
	
}
