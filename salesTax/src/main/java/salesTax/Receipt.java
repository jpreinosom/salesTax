package salesTax;

public interface Receipt {
  void start();
  void printProduct(ProductoEntry entry);
  void printTax(TaxEntry entry);
  void printSubTotal(Precio subTotal);
  void printTaxTotal(Precio taxTotal);
  void printTotal(Precio total);
  void end();
}
