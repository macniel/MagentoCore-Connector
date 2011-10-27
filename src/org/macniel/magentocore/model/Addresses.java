/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * This Class represents a List of customer_address ressources in Magento
 * @author cbe
 */
public class Addresses implements Iterable<Address> {
  
  private ArrayList<Address> addresses;
  
  public int getLength() {
    return addresses.size();
  }
  
  public Addresses(Vector<String> execute) {
    addresses = new ArrayList<Address>();
    String malformedJSONString = execute.toString();
    Address currentItem = new Address();
	String[] pairs = malformedJSONString.split(",");
        for ( int i = 0; i < pairs.length; ++i ) {
			String pair = pairs[i];
			String k = "";
			String v = "";
			if( pair.indexOf("{") != -1 ) {
      		  	currentItem = new Address();
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
                addresses.add(currentItem);
                } catch ( NullPointerException e ) {}
			}
        }
        
	}

  @Override
  public Iterator<Address> iterator() {
    return addresses.iterator();
  }
    
}
