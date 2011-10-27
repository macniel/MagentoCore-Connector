package org.macniel.magentocore;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.macniel.magentocore.model.Address;
import org.macniel.magentocore.model.Addresses;
import org.macniel.magentocore.model.Cart;
import org.macniel.magentocore.model.CartContent;
import org.macniel.magentocore.model.Countries;
import org.macniel.magentocore.model.Customer;
import org.macniel.magentocore.model.Groups;
import org.macniel.magentocore.model.Order;
import org.macniel.magentocore.model.Orders;
import org.macniel.magentocore.model.Product;
import org.macniel.magentocore.model.Products;
import org.macniel.magentocore.model.Regions;
import org.apache.xmlrpc.XmlRpcClient;

public class MagentoCore {

  private TrustManager[] trustAllCerts;
  private XmlRpcClient client;
  private String sessionId;
  
  /**
   * Connect to a XMLRPC Instance of Magento located at url
   * @param url
   * @return 
   */
  public MagentoCore connect(URL url) {
    client = new XmlRpcClient(url);
    return this;
  }
  
  /**
   * Connect to a XMLRPC Instance of Magento located at url
   * @param url
   * @return
   * @throws MalformedURLException 
   */
  public MagentoCore connect(String url) throws MalformedURLException {
    client = new XmlRpcClient(url);
    return this;
  }
  
  /**
   * Get All Products which are assigned to given productId
   * @param productId
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Products getProducts(int productId) throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("catalog_product.list");
    Vector arguments = new Vector();
    arguments.add(productId);
    parameters.add(arguments);
    return new org.macniel.magentocore.model.Products((Vector<Hashtable<String, ?>>)client.execute("call", parameters));
  }
  
  /**
   * Get a Cart with given quoteId
   * @param quoteId
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Cart getCart(int quoteId) throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("cart_product.list");
    Vector arguments = new Vector();
    arguments.add(quoteId);
    parameters.add(arguments);
    return new org.macniel.magentocore.model.Cart((Vector<Hashtable<String, Vector<String>>>)client.execute("call", parameters));
  }
  
  /**
   * Fetch one Customer with given customerId
   * @param id
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Customer getCustomer(int customerId) throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("customer.info");
    Vector arguments = new Vector();
    arguments.add(customerId);
    parameters.add(arguments);
    return new org.macniel.magentocore.model.Customer((Hashtable<String, String>)client.execute("call", parameters));
  }
  
  /**
   * Fetch all Customers
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Customers getCustomers() throws Exception {
    Vector<String> parameters = new Vector<String>();
    parameters.add(sessionId);
    parameters.add("customer.list");
    
    return new org.macniel.magentocore.model.Customers((Vector<String>)client.execute("call", parameters));
  }
  
  /**
   * Get all Addresses from Customer with given customerId
   * @param customerId
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Addresses getAddresses(int customerId) throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("customer_address.list");
    Vector arguments = new Vector();
    arguments.add(customerId);
    parameters.add(arguments);
    return new org.macniel.magentocore.model.Addresses((Vector<String>)client.execute("call", parameters));
  }
  
  /**
   * Get all Usergroups in Magento
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Groups getGroups() throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("customer_group.list");
    return new org.macniel.magentocore.model.Groups((Vector<String>)client.execute("call", parameters));
  }
  
  /**
   * Fetch all Countries
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Countries getCountries() throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("country.list");
    return new org.macniel.magentocore.model.Countries((Vector<String>)client.execute("call", parameters));
  }
  
  /**
   * Fetch all Regions of given Country
   * @param countryId
   * @return
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Regions getRegions(String countryId) throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("region.list");
    Vector arguments = new Vector();
    arguments.add(countryId);
    parameters.add(arguments);
    return new org.macniel.magentocore.model.Regions((Vector<String>)client.execute("call", parameters));
  }
  
  /**
   * Fetch All Orders from Customer with given customerId
   * @param customerId 
   * @return All Order from given Customer
   * @throws Exception 
   */
  public org.macniel.magentocore.model.Orders getOrders(int customerId) throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("sales_order.list");
    Orders o = new org.macniel.magentocore.model.Orders((Vector<String>)client.execute("call", parameters));
    o.filterByCustomerId(customerId);
    return o;
    
  }
  /**
   * Fetch One Order with given IncrementId
   * @param shipmentIncrementId
   * @return The Order with matching IncrementId
   * @throws Exception
   */
  public org.macniel.magentocore.model.Order getOrder(int shipmentIncrementId) throws Exception {
    Vector parameters = new Vector();
    parameters.add(sessionId);
    parameters.add("sales_order.info");
    Vector arguments = new Vector();
    arguments.add(shipmentIncrementId);
    parameters.add(arguments);
    Order o = new org.macniel.magentocore.model.Order((Hashtable<String, String>)client.execute("call", parameters));
    return o;
    
  }
  
  /**
   * Login binded Magento XMLRPC Instance
   * @param apiUser 
   * @param apiKey
   * @return
   * @throws Exception 
   */
  public MagentoCore login(String apiUser, String apiKey) throws Exception {
    Vector<String> parameters = new Vector<String>();
    parameters.add(apiUser);
    parameters.add(apiKey);
    sessionId = (String) client.execute("login", parameters);
    return this;
  }
  
  public MagentoCore() {
    try {
      trustAllCerts = new TrustManager[] {
        new X509TrustManager() {

        @Override
        public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
          
        }

        @Override
        public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
          
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
          return null;
        }
      }
      };
      SSLContext sc = SSLContext.getInstance("SSL");
      HostnameVerifier hv = new HostnameVerifier() {

        @Override
        public boolean verify(String string, SSLSession ssls) {
          return true;
        }
      };
      sc.init(null, trustAllCerts, new java.security.SecureRandom());
    } catch ( Exception e ) {}
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    MagentoCore core = new MagentoCore();
    try {
      core.connect("https://ssl.tutech.de/shop/api/xmlrpc");
      core.login("ijfp-api-user", "1jfp457r4");
      
      // set up dictionaries
      Countries c = core.getCountries();
      
      for ( Customer customer : core.getCustomers()) {
        System.out.println("\n" + customer.getLastname() 
                + (customer.getMiddlename()!=null?" " + customer.getMiddlename(): "") 
                + (customer.getFirstname()!=null? ", " + customer.getFirstname(): ""));
        
        Addresses s = core.getAddresses(customer.getCustomerId());
        if ( s.getLength() == 0 )
          System.out.println("Keine Anschriften hinterlegt");
        for ( Address address : s ) {
          if ( address.isDefaultShipping() && address.isDefaultBilling() ) {
            System.out.println("Haupt Liefer- und Rechnungsanschrift:");
          } else if ( address.isDefaultBilling() ) {
            System.out.println("Haupt Rechnungsanschrift:");
          } else if ( address.isDefaultShipping() ) {
            System.out.println("Haupt Lieferanschrift:");
          }
          
          
        System.out.println("\t" + address.getFirstname() 
                            + (address.getMiddlename()!="" ? " " + address.getMiddlename():"")
                            + (address.getLastname()!="" ? " " + address.getLastname():""));
        System.out.println("\t" + address.getStreet());
        System.out.println("\t" + address.getPostcode() + " " + address.getCity());
        System.out.println("\t" + c.getCountryByCountryId(address.getCountryId()).getName());
	
        Orders orders = core.getOrders(customer.getCustomerId());
        SimpleDateFormat sdf = new SimpleDateFormat("d.MM.yyyy");
        for ( Order order : orders ) {
          System.out.printf("Bestellung am %s umfasst %d Produkt%s %.2f %3s :\n"
                            ,sdf.format(order.getCreatedAt())
                            ,order.getItemCount() 
                            ,(order.getItemCount()!=1?"e":"") 
                            ,order.getTotalDue()
                            ,order.getCurrencyCode());
          Cart cart = core.getCart(order.getQuoteId());
          for ( CartContent cc : cart) {
            Products ps = core.getProducts(cc.getProductId());
            for ( Product product : ps ) {
              if ( product.getType().equals("virtual") )
                System.out.print("\t"); 
              System.out.println("\t"+ product.getName());
            }
          }
        }
        }
      }
      
    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }
}
