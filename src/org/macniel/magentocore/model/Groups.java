/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

/**
 * This Class represents all defined group resources in Magento
 * @author cbe
 */
public class Groups {
  
  HashMap<Integer, String> groups;
  
  public String get(Integer id) {
    return groups.get(id);
  }
  
  public Groups(Vector<String> execute) {
    groups = new HashMap<Integer, String>();
    String malformedJSONString = execute.toString();
    Integer id = 0;
    String code = "";
    String k = "";
    String v = "";
    String[] pairs = malformedJSONString.split(",");
        for ( int i = 0; i < pairs.length; ++i ) {
			String pair = pairs[i];
			if( pair.indexOf("{") != -1 ) {
      		  	id = 0;
                code = "";
                k = "";
                v = "";
      		} 
            String[] keyValue = pair.split("=");
			if ( keyValue.length >= 1 ) 
				k = keyValue[0].replace("{", "").replace("[", "").trim();
			if ( keyValue.length == 2 )
				v = keyValue[1].replace("}", "").replace("]", "").trim();
			
            
            if ( k.equals("customer_group_code") ) {
              code = v;
            }
            if ( k.equals("customer_group_id") ) {
              id = Integer.parseInt(v);
            }
			if ( pair.indexOf("}") != -1 ) {
				try {
                  groups.put(id, code);
                } catch ( NullPointerException e ) {}
			}
        }
        
  }
  
}
