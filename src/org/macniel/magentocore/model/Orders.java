/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * This Class represents a List of sales_order resources in Magento
 * @author cbe
 */
public class Orders implements Iterable<Order> {
  
  private ArrayList<Order> orders;
  
  public int getLength() {
    return orders.size();
  }
  
  public void filterByCustomerId(int id) {
    ArrayList<Order> filtered = new ArrayList<Order>();
    for ( Order o : orders ) {
      if ( o.getCustomerId() == id )
        filtered.add(o);
    }
    orders = filtered;
  }
  
  public Orders(Vector<String> execute) {
    orders = new ArrayList<Order>();
    String malformedJSONString = execute.toString();
    Order currentItem = new Order();
	String[] pairs = malformedJSONString.split(",");
        for ( int i = 0; i < pairs.length; ++i ) {
			String pair = pairs[i];
			String k = "";
			String v = "";
			if( pair.indexOf("{") != -1 ) {
      		  	currentItem = new Order();
      		} 
            String[] keyValue = pair.split("=");
			if ( keyValue.length >= 1 ) 
				k = keyValue[0].replace("{", "").replace("[", "").trim();
			if ( keyValue.length == 2 )
				v = keyValue[1].replace("}", "").replace("]", "").trim();
			if ( keyValue.length == 2 ) {
                currentItem.setProperty(k, v);
            } else if ( keyValue.length == 1 ) {
				currentItem.setProperty(k, "");
            }
            if ( pair.indexOf("}") != -1 ) {
              	try {
                orders.add(currentItem);
                } catch ( NullPointerException e ) {}
			}
        }
        
	}

  @Override
  public Iterator<Order> iterator() {
    return orders.iterator();
  }
  
  
  
}
