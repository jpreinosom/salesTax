package salesTax;

public class Producto {

  private final String nombre;
  private final TipoProducto tipo;
  private final OrigenProducto origen;
  private final Precio precio;
  
  public Producto(String nombre, TipoProducto tipo, OrigenProducto origen, Precio precio) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.origen = origen;
    this.precio = precio;
  }

  public String getNombre() {
    return this.nombre;
  }
  
  public TipoProducto getTipo() {
    return this.tipo;
  }
 
  public boolean isImportado() {
    return origen == OrigenProducto.IMPORTED;
  }

	public Precio getPrecio() {
		return precio;
	}
  
}
