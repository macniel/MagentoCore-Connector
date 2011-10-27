/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

/**
 * This Class represents a cart resource in Magento
 * @author cbe
 */
public class Cart implements Iterable<CartContent> {

  private ArrayList<CartContent> content;
  
  public int getProductId(int i) {
    return content.get(i).getProductId();
  }
  
  
  
  public Cart(Vector<Hashtable<String, Vector<String>>> vector) {
    content = new ArrayList<CartContent>();
    for ( Hashtable<String, ?> m: vector) {
      CartContent cc = new CartContent();
      for ( String s : m.keySet() ) {
        cc.model.put( s, m.get(s).toString().replace("[", "").replace("]", ""));
      }
      content.add(cc);
    }
    
  }

  @Override
  public Iterator<CartContent> iterator() {
    return content.iterator();
  }
    
  
  
  
}
