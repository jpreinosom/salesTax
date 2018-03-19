package salesTax;

import java.io.PrintStream;

public class SimpleReceipt implements Receipt {

  private final PrintStream out;
  
  public SimpleReceipt(PrintStream out) {
    this.out = out;
  }

  public void start() {
    out.println("------------------ THIS IS YOUR ORDER ------------------");
  }

  public void printProduct(ProductoEntry entry) {
    out.printf("(%03d) %35s ----- %8s\n", entry.getCantidad(), entry.getProductName(), entry.getPrecio());
  }
  public void printTax(TaxEntry entry) {
    out.printf("(%3s) %35s ----- %8s\n", entry.getTaxName(), entry.getProductName(), entry.getPrecio());
  }

  public void printSubTotal(Precio subTotal) {
    out.printf("%41s ----- %8s\n", "TOTAL", subTotal);
  }

  public void printTaxTotal(Precio taxTotal) {
    out.printf("%41s ----- %8s\n", "TAX TOTAL", taxTotal);
  }

  public void printTotal(Precio total) {
    out.printf("%41s ----- %8s\n", "TOTAL", total);
  }

  public void end() {
    out.println("------------------------ THANKS ------------------------");
  }
 
}
