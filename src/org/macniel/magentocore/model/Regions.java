/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * This Class represents a List of directory_region resources in Magento
 * @author cbe
 */
public class Regions implements Iterable<Region> {
  
  ArrayList<Region> regions;

  public Region getRegionByCode(String code) {
    for ( Region r : regions )
      if ( r.getCode().equalsIgnoreCase(code))
        return r;
    return null;
  }
  
  public Region getRegionByRegionId(int id) {
    for ( Region r : regions )
      if ( r.getRegionId() == id)
        return r;
    return null;
  }
  
  public Region getRegionByName(String name) {
    for ( Region r : regions )
      if ( r.getName().equalsIgnoreCase(name))
        return r;
    return null;
  }
  
  public Regions(Vector<String> execute) {
    regions = new ArrayList<Region>();
    String malformedJSONString = execute.toString();
    Region currentItem = new Region();
	String[] pairs = malformedJSONString.split(",");
        for ( int i = 0; i < pairs.length; ++i ) {
			String pair = pairs[i];
			String k = "";
			String v = "";
			if( pair.indexOf("{") != -1 ) {
      		  	currentItem = new Region();
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
                regions.add(currentItem);
                } catch ( NullPointerException e ) {}
			}
        }
  }
  
  @Override
  public Iterator<Region> iterator() {
    return regions.iterator();
  }
  
  
  
  
}
