/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * This Class represents a List of customer resources in Magento
 * @author cbe
 */
public class Customers implements Iterable<Customer> {

  private ArrayList<Customer> customers;
  
  public int getLength() {
    return customers.size();
  }
  
  public Customers(Vector<String> execute) {
    customers = new ArrayList<Customer>();
    String malformedJSONString = execute.toString();
    Customer currentItem = new Customer();
	String[] pairs = malformedJSONString.split(",");
        for ( int i = 0; i < pairs.length; ++i ) {
			String pair = pairs[i];
			String k = "";
			String v = "";
			if( pair.indexOf("{") != -1 ) {
      		  	currentItem = new Customer();
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
                customers.add(currentItem);
                } catch ( NullPointerException e ) {}
			}
        }
        
	}

  @Override
  public Iterator<Customer> iterator() {
    return customers.iterator();
  }
    
}
