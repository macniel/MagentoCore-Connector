/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

/**
 * This Class represents a single entry of a directory_contry resource in Magento
 * @author cbe
 */
public class Country extends Model {

  public Country() {
  }
  
  public String getIso2() {
    return model.get("iso2_code");
  }
  
  public String getIso3() {
    return model.get("iso3_code");
  }
  
  public String getCountryId() {
    return model.get("country_id");
  }
  
  public String getName() {
    return model.get("name");
  }
  
}
