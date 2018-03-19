package salesTax;

import java.math.BigDecimal;
import java.util.*;


public class Orden {
  
  private final AplicarImpuesto taxingPractice;
  private final List<ProductoEntry> entries = new ArrayList<ProductoEntry>();
  private final List<TaxEntry> taxEntries = new ArrayList<TaxEntry>();

  public Orden(AplicarImpuesto taxingPractice) {
    this.taxingPractice = taxingPractice;
  }
/*
 * method that performs the calculation of taxes on purchases and stores them in a list 
 * to be shown on the ballot, and that also performs the update of the values of the products including the tax 
 * */
  public void add(Producto producto, int cantidad) {
    ProductoEntry entry = new ProductoEntry (producto, producto.getPrecio(), cantidad);
    taxEntries.addAll(taxingPractice.apply(entry));
    entries.add(taxingPractice.UpdateAmount(entry));
  }

  /*
   * Method Return SubTotal of amount of purchases
   * */
  public Precio getSubTotal() {
    return getTotal(entries);
  }
/*
 * Method Return Total of Taxes of purchases
 * */
  public Precio getTaxTotal() {
    return getTotal(taxEntries);
  }
  
  /*
   * Method Return Total of amount of purchases
   * */
  public Precio getTotal() {
    return getSubTotal().add(getTaxTotal());
  }
  
  private Precio getTotal(Iterable<? extends OrdenEntry> entries) {
    Precio total = new Precio("0.00");
    for (OrdenEntry entry : entries) {
      total = total.add(entry.getPrecio());
    }
    return total;    
  }
/*
 * Method print all purchase
 * */
  public void print(Receipt receipt) {
    receipt.start();
    for (ProductoEntry entry : entries) receipt.printProduct(entry);
    receipt.printTaxTotal(getTaxTotal());
    receipt.printSubTotal(getSubTotal());
    receipt.end();
  }

}
