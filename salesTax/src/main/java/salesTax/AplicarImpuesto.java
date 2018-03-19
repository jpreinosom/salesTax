package salesTax;

import java.util.Collection;

public interface AplicarImpuesto {

  Collection<TaxEntry> apply(ProductoEntry entry);
  
  ProductoEntry UpdateAmount(ProductoEntry entry);

}