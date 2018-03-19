package salesTax;

import java.util.*;

public class TaxExcepciones implements TaxEligibilidad {

  public static TaxExcepciones excepto(TipoProducto... types) {
    return new TaxExcepciones(types);
  }
  
  private final List<TipoProducto> types;
  
  private TaxExcepciones(TipoProducto... types) {
    this.types = Arrays.asList(types);
  }
  
  public boolean isEligible(OrdenEntry entry) {
    return !types.contains(entry.getProducto().getTipo());
  }

}
