/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This Class Represents an customer_address resource in Magento
 * @author cbe
 */
public class Address extends Model {
  
  public String getSuffix() {
    return model.get("suffix");
  }
  
  public String getRegion() {
    return model.get("region");
  }
  
  public String getCompany() {
    return model.get("company");
  }
  
  public String getLastname() {
    return model.get("lastname");
  }
  
  public String getStreet() {
    return model.get("street");
  }
  
  public int getRegionId() {
    return Integer.parseInt(model.get("region_id"));
  }
  
  public boolean isDefaultBilling() {
    return Boolean.parseBoolean(model.get("is_default_billing"));
  }
  
  public int getIncrementId() {
    return Integer.parseInt(model.get("increment_id"));
  }
  
  public String getMiddlename() {
    return model.get("middlename");
  }
  
  public String getPrefix() {
    return model.get("prefix");
  }
  
  public String getCity() {
    return model.get("city");
  }
  
  public String getFirstname() {
    return model.get("firstname");
  }
  
  public int getCustomerAddressId() {
    return Integer.parseInt(model.get("customer_address_id"));
  }
  
  public boolean isDefaultShipping() {
    return Boolean.parseBoolean(model.get("is_default_shipping"));
  }
  
  public String getTelephone() {
    return model.get("telephone");
  }
  
  public String getFax() {
    return model.get("fax");
  }
  
  public Date getUpdatedAt() {
    try {
      return new SimpleDateFormat("y-M-d k:m:s").parse(model.get("updated_at"));
    } catch ( ParseException e ) {
      return null;
    }
  }
  
  public String getPostcode() {
    return model.get("postcode");
  }
  
  public String getCountryId() {
    return model.get("country_id");
  }
  
}
