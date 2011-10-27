/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

/**
 * This Class represents a list of catalog_product resources in Magento
 * @author cbe
 */
public class Products implements Iterable<Product> {
  
  protected ArrayList<Product> products;
  
  public Products(Vector<Hashtable<String, ?>> execute) {   
    products = new ArrayList<Product>(); 
    for ( Hashtable<String, ?> h : execute) {
      Product currentItem = new Product();
       for ( String s : h.keySet() ) {
        currentItem.model.put(s, h.get(s).toString().replace("[", "").replace("]", ""));
         
      }
      products.add(currentItem);
    }
  }

  @Override
  public Iterator<Product> iterator() {
    return products.iterator();
            
  }
  
  
  
}
