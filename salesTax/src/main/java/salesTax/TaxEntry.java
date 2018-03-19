package salesTax;

import java.math.BigDecimal;

public class TaxEntry implements OrdenEntry {

  private final ProductoEntry taxedEntry;
  private final TaxMetodo tax;
  private final Precio precio;

  public TaxEntry(ProductoEntry taxedEntry, TaxMetodo tax, Precio precio) {
    this.taxedEntry = taxedEntry;
    this.tax = tax;
    this.precio = precio;
  }

  public Producto getProducto() {
    return taxedEntry.getProducto();
  }

  public String getProductName() {
    return getProducto().getNombre();
  }
    
  public String getTaxName() {
    return tax.getName();
  }
  
  public BigDecimal getTaxRate() {
    return tax.getRate();
  }

public Precio getPrecio() {
	 return precio;
}

}
