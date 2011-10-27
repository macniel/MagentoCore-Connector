/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.Hashtable;
import java.util.Vector;

/**
 * This Class represents a catalog_product resource in Magento
 * @author cbe
 */
public class Product extends Model {

  public Product() {

  }
  
  public String[] getCategoryIds() {
    return model.get("category_ids").split(",");
  }
  
  public String getName() {
    return model.get("name");
  }
  
  public int getProductId() {
    return Integer.parseInt(model.get("product_id"));
  }
  
  public String getType() {
    return model.get("type");
  }
  
  public int getSet() {
    return Integer.parseInt(model.get("set"));
  }
  
  public String getSKU() {
    return model.get("sku");
  }
 
}
