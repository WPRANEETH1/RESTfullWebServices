package com.restfulladdbook.resource;

import com.restfulladdbook.model.Contact;
import javax.ws.rs.core.Response;

public interface ContactServices {

    public Response addContacts(Contact contact);

    public Response updateContact(Contact contact);

    public Response deleteContact(int contactId);

    public Response getContactById(int cintactId);

    public Response getContactByName(String contactName);

    public Response getAllContact();
}
