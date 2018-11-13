package com.company.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.company.service.CreditorService;

@Path("creditors")
public class CreditorResource {
	
	private CreditorService creditorService = new CreditorService();
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String findById(@PathParam("id") Integer id) {
		return creditorService.findById(id).toXML();
	}

}
