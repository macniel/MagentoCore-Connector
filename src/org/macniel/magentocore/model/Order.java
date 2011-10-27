/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macniel.magentocore.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

/**
 * This Class represents a sales_order resource in Magento
 * @author cbe
 */
public class Order extends Model {

  public Order() {
  }
  
  public Order(Hashtable<String, String> vector) {
    model.putAll(vector);
  }
  
  public boolean isShippingCancled() {
    return Boolean.parseBoolean(model.get("shipping_canceled"));
  }
  
  public boolean isAdjustmentPositive() {
    return Boolean.parseBoolean(model.get("adjustment_positive"));
  }
  
  public int getRelationParentRealId() {
    return Integer.parseInt(model.get("relation_parent_real_id"));
  }
  
  public String getTelephone() {
    return model.get("telephone");
  }
  
  public int getTotalInvoiced() {
    return Integer.parseInt(model.get("total_invoiced"));
  }
  
  public boolean isDiscountCanceled() {
    return Boolean.parseBoolean(model.get("discount_canceled"));
  }
  
  public String getShippingDescription() {
    return model.get("shipping_description");
  }
  
  public float getShippingInclTax() {
    return Float.parseFloat(model.get("shipping_incl_tax"));
  }
  
  public int getRelationChildId() {
    return Integer.parseInt(model.get("relation_child_id"));
  }
  
  public float getBaseHiddenTaxRefunded() {
    return Float.parseFloat(model.get("base_hidden_tax_refunded"));
  }
  
  public boolean getBaseTaxCanceled() {
    return Boolean.parseBoolean(model.get("base_tax_canceled"));
  }
  
  public float getTotalDue() {
    try {
      return Float.parseFloat(model.get("total_due"));
    } catch ( Exception e ) {
      return 0;
    }
  }
  
  public float getSubtotalInvoiced() {
    try {
      return Float.parseFloat(model.get("subtotal_invoiced"));
    } catch ( Exception e ) {
      return 0;
    }
  }
  
  public String getShippingMethod() {
    return model.get("shipping_method");
  }
  
  public int getIncrementId() {
    return Integer.parseInt(model.get("increment_id"));
  }
  
  public float getHiddenTaxAmount() {
    return Float.parseFloat(model.get("hidden_tax_amount"));
  }
  
  public int getBaseTotalQtyOrdered() {
    return Integer.parseInt(model.get("base_total_qty_ordered"));
  }
  
  public String getStatus() {
    return model.get("status");
  }
  
  public String getHoldBeforeState() {
    return model.get("hold_before_state");
  }
  
  public String getBaseSubtotalCanceled() {
    return model.get("base_subtotal_canceled");
  }
  
  public String getBillingName() {
    return model.get("billing_name");
  }
  
  public String getCustomerSuffix() {
    return model.get("customer_suffix");
  }
  
  public String getShippingLastname() {
    return model.get("shipping_lastname");
  }
  
  public Float getBaseShippingTaxRefunded() {
    return Float.parseFloat(model.get("base_shipping_tax_refunded"));
  }
  
  public Float getBaseTotalOnlineRefunded() {
    return Float.parseFloat(model.get("base_total_online_refunded"));
  }
  
  public String getCouponCode() {
    return model.get("coupon_code");
  }
  
  public Float getBaseToOrderRate() {
    return Float.parseFloat(model.get("base_to_order_rate"));
  }
  
  public Date getPaymentAuthorizationExpiration() {
    try {
      return new SimpleDateFormat("y-M-d k:m:s").parse(model.get("payment_authorization_expiration"));
    } catch ( ParseException e ) {
      return null;
    }
  }
  
  public Float getShippingAmount() {
    return Float.parseFloat(model.get("shipping_amount"));
  }
  
  public Float getBaseSubtotalInclTax() {
    return Float.parseFloat(model.get("base_subtotal_incl_tax"));
  }
  
  public Float getTotalDiscountAmount() {
    return Float.parseFloat(model.get("base_discount_amount"));
  }
  
  public Float getGrandTotal() {
    return Float.parseFloat(model.get("base_grand_total"));
  }
  
  public boolean isVirtual() {
    return Integer.parseInt(model.get("is_virtual")) == 1 || Boolean.parseBoolean(model.get("is_virtual"));
  }
  
  public String getShippingName() {
    return model.get("shipping_name");
  }
  
  public Float getTaxRefunded() {
    return Float.parseFloat(model.get("total_tax_refunded"));
  }
  
  public int getStoreId() {
    return Integer.parseInt(model.get("store_id"));
  }
  
  public int getRelationChildRealId() {
    return Integer.parseInt(model.get("relation_child_real_id"));
  }
  
  public String getQuoteAddressId() {
    return model.get("quote_address_id");
  }
  
  public int getQuoteId() {
    return Integer.parseInt(model.get("quote_id"));
  }
  
  public int getCustomerId() {
    return Integer.parseInt(model.get("customer_id"));
  }
  
  public String getCurrencyCode() {
    return model.get("order_currency_code");
  }
  
  public int getItemCount() {
    return Integer.parseInt(model.get("total_item_count"));
  }
  
  public boolean isEmailSent() {
    return Integer.parseInt(model.get("email_sent")) == 1 || Boolean.parseBoolean(model.get("email_sent"));
  }
  
  public String getRemoteAddr() {
    return model.get("remote_ip");
  }
  
  public int getOrderId() {
    return Integer.parseInt(model.get("order_id"));
  }
  
  public String getBillingAddressId() {
    return model.get("billing_address_id");
  }
  
  public String getShippingAddressId() {
    return model.get("shipping_address_id");
  }
  
  public Date getCreatedAt() {
    try {
      return new SimpleDateFormat("y-M-d k:m:s").parse(model.get("created_at"));
    } catch ( ParseException e ) {
      return null;
    }    
  }
  
  public String getState() {
    return model.get("state");
  }
  
}

