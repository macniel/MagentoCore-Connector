/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * This Class represents the directory_country resource in Magento
 * @author cbe
 */
public class Countries implements Iterable<Country> {
  
  private ArrayList<Country> countries;
  
  public int getLength() {
    return countries.size();
  }
  
  public Country getCountryByIso2(String iso2) {
    for ( Country c : countries )
      if ( c.getIso2().equalsIgnoreCase(iso2)) 
        return c;
    return null;
  }
  
  public Country getCountryByIso3(String iso3) {
    for ( Country c : countries )
      if ( c.getIso3().equalsIgnoreCase(iso3)) 
        return c;
    return null;
  }
  
  public Country getCountryByName(String name) {
    for ( Country c : countries )
      if ( c.getName().equalsIgnoreCase(name)) 
        return c;
    return null;
  }
  public Country getCountryByCountryId(String countryId) {
    for ( Country c : countries )
      if ( c.getCountryId().equalsIgnoreCase(countryId)) 
        return c;
    return null;
  }
  
  public Countries(Vector<String> execute) {
    countries = new ArrayList<Country>();
    String malformedJSONString = execute.toString();
    Country currentItem = new Country();
	String[] pairs = malformedJSONString.split(",");
        for ( int i = 0; i < pairs.length; ++i ) {
			String pair = pairs[i];
			String k = "";
			String v = "";
			if( pair.indexOf("{") != -1 ) {
      		  	currentItem = new Country();
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
                countries.add(currentItem);
                } catch ( NullPointerException e ) {}
			}
        }
  }

  @Override
  public Iterator<Country> iterator() {
    return countries.iterator();
  }
  
  
  
}
