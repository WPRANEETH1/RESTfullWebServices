package com.restfulladdbook.dao.impl;

import com.restfulladdbook.dao.ContactDao;
import com.restfulladdbook.model.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

public class ContactDaoImpl implements ContactDao {

    @Override
    public boolean addContacts(Contact contact) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:demodb1", "system", "root");
            try {
                String sqldrop = "INSERT INTO CONTACT"
                        + "(ID, FIRSTNAME, MIDDLENAME, LASTNAME, DOB, HOMEADDRESS, WORKADDRESS, HOMEPHONE, WORKPHONE, CELLPHONE, FAX, EMAIL) " + "VALUES"
                        + "(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement mypstmt = con.prepareStatement(sqldrop);
                mypstmt.setInt(1, contact.getId());
                mypstmt.setString(2, contact.getFirstName());
                mypstmt.setString(3, contact.getMiddleName());
                mypstmt.setString(4, contact.getLastName());
                mypstmt.setString(5, contact.getDob());
                mypstmt.setString(6, contact.getHomeAddress());
                mypstmt.setString(7, contact.getWorkAddress());
                mypstmt.setString(8, contact.getHomePhone());
                mypstmt.setString(9, contact.getWorkPhone());
                mypstmt.setString(10, contact.getCellPhone());
                mypstmt.setString(11, contact.getFax());
                mypstmt.setString(12, contact.getEmail());
                mypstmt.execute();
                con.close();
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean updateContact(Contact contact) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:demodb1", "system", "root");
            try {
                String sqldrop = "UPDATE CONTACT SET "
                        + "FIRSTNAME = ?, MIDDLENAME =?, LASTNAME = ?, DOB = ?, HOMEADDRESS = ?, WORKADDRESS = ?, HOMEPHONE = ?, WORKPHONE = ?, CELLPHONE = ?, FAX = ?, EMAIL = ?"
                        + " WHERE ID = ?";
                PreparedStatement mypstmt = con.prepareStatement(sqldrop);
                mypstmt.setString(1, contact.getFirstName());
                mypstmt.setString(2, contact.getMiddleName());
                mypstmt.setString(3, contact.getLastName());
                mypstmt.setString(4, contact.getDob());
                mypstmt.setString(5, contact.getHomeAddress());
                mypstmt.setString(6, contact.getWorkAddress());
                mypstmt.setString(7, contact.getHomePhone());
                mypstmt.setString(8, contact.getWorkPhone());
                mypstmt.setString(9, contact.getCellPhone());
                mypstmt.setString(10, contact.getFax());
                mypstmt.setString(11, contact.getEmail());
                mypstmt.setInt(12, contact.getId());
                mypstmt.execute();
                con.close();
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean deleteContact(int contactId) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:demodb1", "system", "root");
            try {
                String sqldrop = "delete from contact where id = ?";
                PreparedStatement mypstmt = con.prepareStatement(sqldrop);
                mypstmt.setInt(1, contactId);
                System.out.println(sqldrop);
                mypstmt.execute();
                con.close();
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public JSONArray getContactById(int cintactId) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:demodb1", "system", "root");
            con.setAutoCommit(false);
            PreparedStatement pstm = null;
            Statement stmt = null;
            try {
                String sqldrop = "SELECT * FROM contact where id ='" + cintactId + "'";
                PreparedStatement mypstmt = con.prepareStatement(sqldrop);
                ResultSet resultSet = mypstmt.executeQuery();
                JSONArray jsonArray = new JSONArray();
                while (resultSet.next()) {
                    int total_rows = resultSet.getMetaData().getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i = 0; i < total_rows; i++) {
                        String columnName = resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase().replaceAll("_", " ");
                        Object columnValue = resultSet.getObject(i + 1);
                        if (columnValue == null) {
                            columnValue = "null";
                        }
                        if (obj.has(columnName)) {
                            columnName += "1";
                        }
                        obj.put(columnName, columnValue);
                    }
                    jsonArray.put(obj);
                }
                mypstmt.close();
                con.commit();
                return jsonArray;
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public JSONArray getContactByName(String contactName) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:demodb1", "system", "root");
            con.setAutoCommit(false);
            PreparedStatement pstm = null;
            Statement stmt = null;
            try {
                String sqldrop = "SELECT * FROM contact where firstName ='" + contactName + "'";
                PreparedStatement mypstmt = con.prepareStatement(sqldrop);
                ResultSet resultSet = mypstmt.executeQuery();
                JSONArray jsonArray = new JSONArray();
                while (resultSet.next()) {
                    int total_rows = resultSet.getMetaData().getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i = 0; i < total_rows; i++) {
                        String columnName = resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase().replaceAll("_", " ");
                        Object columnValue = resultSet.getObject(i + 1);
                        if (columnValue == null) {
                            columnValue = "null";
                        }
                        if (obj.has(columnName)) {
                            columnName += "1";
                        }
                        obj.put(columnName, columnValue);
                    }
                    jsonArray.put(obj);
                }
                mypstmt.close();
                con.commit();
                return jsonArray;
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public JSONArray getAllContact() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:demodb1", "system", "root");
            con.setAutoCommit(false);
            PreparedStatement pstm = null;
            Statement stmt = null;

            try {
                String sqldrop = "SELECT * FROM contact";
                PreparedStatement mypstmt = con.prepareStatement(sqldrop);
                ResultSet resultSet = mypstmt.executeQuery();
                JSONArray jsonArray = new JSONArray();
                while (resultSet.next()) {
                    int total_rows = resultSet.getMetaData().getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i = 0; i < total_rows; i++) {
                        String columnName = resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase().replaceAll("_", " ");
                        Object columnValue = resultSet.getObject(i + 1);
                        if (columnValue == null) {
                            columnValue = "null";
                        }
                        if (obj.has(columnName)) {
                            columnName += "1";
                        }
                        obj.put(columnName, columnValue);
                    }
                    jsonArray.put(obj);
                }
                mypstmt.close();
                con.commit();
                return jsonArray;
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
