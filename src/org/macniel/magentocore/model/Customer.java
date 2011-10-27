/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
/**
 * This Class represents a customer resource in Magento
 * @author cbe
 */
public class Customer extends Model {

  public Customer(Hashtable<String, String> vector) {
    model.putAll(vector);
  }

  public Customer() {
  }
  
  
  public Date getDateOfBirth() {
    try {
      return new SimpleDateFormat("y-M-d k:m:s").parse(model.get("dob"));
    } catch ( ParseException e ) {
      return null;
    }
  }
  
  public int getStoreId() {
    return Integer.parseInt(model.get("store_id"));
  }
  
  public int getDefaultBilling() {
    return Integer.parseInt(model.get("default_billing"));
  }
  
  public String getLastname() {
    return model.get("lastname");
  }
  
  public String getMiddlename() {
    return model.get("middlename");
  }
  
  public String getEmail() {
    return model.get("email");
  }
  
  public int getGroupId() {
    return Integer.parseInt(model.get("group_id"));
  }
  
  public String getPrefix() {
    return model.get("prefix");
  }
  
  public String getFirstname() {
    return model.get("firstname");
  }
  
  public int getCustomerId() {
    return Integer.parseInt(model.get("customer_id"));
  }
  
  public String getCreatedIn() {
    return model.get("created_in");
  }
  
  public Date getUpdatedAt() {
    try {
      return new SimpleDateFormat("y-M-d k:m:s").parse(model.get("updated_at"));
    } catch ( ParseException e ) {
      return null;
    }
  }
  
  public int getDefaultShipping() {
    return Integer.parseInt(model.get("default_shipping"));
  }
  
  public String getSuffix() {
    return model.get("suffix");
  }
  
  public Date getCreatedAt() {
    try {
      return new SimpleDateFormat("y-M-d k:m:s").parse(model.get("created_at"));
    } catch ( ParseException e ) {
      return null;
    }
  }

  
  
}
