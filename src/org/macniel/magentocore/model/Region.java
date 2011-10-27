/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

/**
 * This Class represents a directory_region resource in Magento
 * @author cbe
 */
public class Region extends Model {
  
  public String getCode() {
    return model.get("code");
  }
  
  public int getRegionId() {
    return Integer.parseInt(model.get("region_id"));
  }
  
  public String getName() {
    return model.get("name");
  }
  
}
