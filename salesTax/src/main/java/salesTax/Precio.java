package salesTax;

import java.math.*;

public class Precio {

  public Precio (String precio) {
    this.precio = new BigDecimal(precio);
  }
  
  
  private final BigDecimal precio;

  private Precio(BigDecimal amount) { 
    this.precio = amount.setScale(2, RoundingMode.UP);
  }
  
  @Override public int hashCode() {
    return precio.hashCode();
  }
  
  @Override public boolean equals(Object other) {
    if (other == null) return false;
    return other instanceof Precio && equals((Precio)other);
  }
  
  public boolean equals(Precio other) {
    return precio.equals(other.getPrecio());
  }
  
  public BigDecimal getPrecio() {
    return precio;
  }

  public Precio add(Precio other) {
    return new Precio(precio.add(other.precio));
  }

  public Precio multiply(int times) {
    return multiply(new BigDecimal(times));
  }
  
  public Precio multiply(String factor) {
    return multiply(new BigDecimal(factor));
  }

  public Precio multiply(BigDecimal factor) {
    return new Precio(precio.multiply(factor));
  }

  @Override public String toString() {
    return "$" + precio;
  }

}
