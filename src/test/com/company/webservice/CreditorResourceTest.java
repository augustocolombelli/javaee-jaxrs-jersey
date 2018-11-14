package com.company.webservice;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static junit.framework.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.GrizzlyServer;
import com.company.model.Creditor;

public class CreditorResourceTest {

	private static final String PATH = "creditors";
	private static final String URI = "http://localhost:8080/";
	private HttpServer server;
	private Client client;
	private WebTarget target;

	@Before
	public void setUp() {
		startServer();
	}

	@After
	public void after() {
		server.shutdown();
	}

	@Test
	public void shouldReturnOneCreditor() {
		Creditor creditor = target.path(PATH + "/1").request().get(Creditor.class);
		assertEquals("Augusto", creditor.getName());
	}

	@Test
	public void shouldInsertOneCreditor() throws ParseException {
		Creditor creditor = new Creditor();
		creditor.setId(50);
		creditor.setName("Marcio");
		creditor.setDocumentNumber(6545);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		creditor.setBirth(sdf.parse("12/01/2018"));

		Entity<Creditor> entity = Entity.entity(creditor, APPLICATION_XML);

		Response response = target.path(PATH).request().post(entity);

		String location = response.getHeaderString("Location");
		Creditor insertedCreditor = client.target(location).request().get(Creditor.class);

		assertEquals(201, response.getStatus());
		assertEquals("Marcio", insertedCreditor.getName());
	}

	private void startServer() {
		server = GrizzlyServer.initServer();
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		client = ClientBuilder.newClient(config);
		target = client.target(URI);
	}

}
