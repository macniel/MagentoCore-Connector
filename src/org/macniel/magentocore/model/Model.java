/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.util.HashMap;
import java.util.Iterator;

/**
 * This abstract class is the base of every resource 
 * @author cbe
 */
public abstract class Model {
  
  protected HashMap<String, String> model;
  public Model() {
    model = new HashMap<String, String>();
  }
  public  void setProperty(String propertyName, String propertyValue) {
    model.put(propertyName, propertyValue);
    
  }
  
}
