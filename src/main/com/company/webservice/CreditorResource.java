package com.company.webservice;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.company.model.Creditor;
import com.company.service.CreditorService;
import com.thoughtworks.xstream.XStream;

@Path("creditors")
public class CreditorResource {

	private CreditorService creditorService = new CreditorService();

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String findById(@PathParam("id") Integer id) {
		return creditorService.findById(id).toXML();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response insert(String content) {
		Creditor creditor = (Creditor) new XStream().fromXML(content);
		creditorService.insert(creditor);
		URI uri = URI.create("/creditors/" + creditor.getId());
		return Response.created(uri).build();
	}

	@Path("{id}/accountsbank/{accountBankId}")
	@DELETE
	public Response removeAccountBank(@PathParam("id") Integer id, @PathParam("accountBankId") Integer accountBankId) {
		Creditor creditor = creditorService.findById(id);
		creditor.removeAccountBank(accountBankId);
		return Response.ok().build();
	}

	@Path("{id}/name")
	@PUT
	public Response changeName(String content, @PathParam("id") Integer id) {
		Creditor creditorWithNewValues = (Creditor) new XStream().fromXML(content);
		Creditor creditorToChangeName = creditorService.findById(id);
		creditorToChangeName.setName(creditorWithNewValues.getName());
		return Response.ok().build();
	}

}
