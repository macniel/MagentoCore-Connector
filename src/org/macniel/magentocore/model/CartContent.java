/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

/**
 * This Class represents the content of a cart resource in Magento
 * @author cbe
 */
public class CartContent extends Model {
  
  public CartContent() {
    
  }
  
  public String getType() {
    return model.get("type");
  }
  
  public String[] getWebsites() {
    return model.get("websites").split(",");
  }
  
  public String[] getCategories() {
    return model.get("categories").split(",");
  }
  
  public String getSKU() {
    return model.get("sku");
  }
  
  public int getProductId() {
    return Integer.parseInt(model.get("product_id"));
  }
  
}
