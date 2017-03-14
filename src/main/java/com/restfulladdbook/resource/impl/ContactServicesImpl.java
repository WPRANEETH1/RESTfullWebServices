package com.restfulladdbook.resource.impl;

import com.restfulladdbook.dao.impl.ContactDaoImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restfulladdbook.model.Contact;
import com.restfulladdbook.resource.ContactServices;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/services")
public class ContactServicesImpl implements ContactServices {

    public ContactDaoImpl contactdaoimpl = new ContactDaoImpl();

    @Override
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addcontact")
    public Response addContacts(Contact contact) {
        boolean val = contactdaoimpl.addContacts(contact);
        if (val = true) {
            return Response.ok(Response.Status.CREATED).build();
        }
        return Response.ok(Response.Status.NOT_IMPLEMENTED).build();
    }

    @Override
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/updatecontact")
    public Response updateContact(Contact contact) {
        boolean val = contactdaoimpl.updateContact(contact);
        if (val = true) {
            return Response.ok(Response.Status.OK).build();
        }
        return Response.ok(Response.Status.NOT_MODIFIED).build();
    }

    @Override
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/deletecontact/{id}")
    public Response deleteContact(@PathParam("id") int cintactId) {
        boolean val = contactdaoimpl.deleteContact(cintactId);
        if (val = true) {
            return Response.ok(Response.Status.OK).build();
        }
        return Response.ok(Response.Status.NOT_ACCEPTABLE).build();
    }

    @Path("/getbyid/{id}")
    @GET
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getContactById(@PathParam("id") int cintactId) {
        return Response.ok(contactdaoimpl.getContactById(cintactId).toString()).build();
    }

    @Override
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getbyname/{name}")
    public Response getContactByName(@PathParam("name") String contactName) {
        return Response.ok(contactdaoimpl.getContactByName(contactName).toString()).build();
    }

    @Path("/getall")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public Response getAllContact() {
        return Response.ok(contactdaoimpl.getAllContact().toString()).build();
    }

}
