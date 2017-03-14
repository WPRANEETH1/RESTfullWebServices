package com.restfulladdbook.dao;

import com.restfulladdbook.model.Contact;
import org.json.JSONArray;

public interface ContactDao {

    public boolean addContacts(Contact contact);

    public boolean updateContact(Contact contact);

    public boolean deleteContact(int contactId);

    public JSONArray getContactById(int cintactId);

    public JSONArray getContactByName(String contactName);

    public JSONArray getAllContact();
}
