package salesTax;

public class ProductoEntry implements OrdenEntry {

  private final Precio precio;
  private final Producto producto;
  private final int cantidad;

  public ProductoEntry(Producto producto, Precio precio, int cantidad) {
    this.producto = producto;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public Precio getPrecio() {
    return precio.multiply(cantidad);
  }

  public Producto getProducto() {
    return producto;
  }
  
  public String getProductName() {
    return producto.getNombre();
  }
  
  public int getCantidad() {
    return cantidad;
  }
}
