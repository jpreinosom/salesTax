package salesTax;
import java.math.BigDecimal;

public class CalcularPrecio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println();
		
		//SET TAX CONFIGURATION
		
		TaxMetodo impuestoBasico = new TaxMetodo("IMBasico", new BigDecimal("0.10"), TaxExcepciones.excepto(TipoProducto.BOOK, TipoProducto.FOOD, TipoProducto.MEDICAL));

	    TaxMetodoPractica taxes = new TaxMetodoPractica();
	    taxes.add(impuestoBasico);
		
		//INPUT 1 
		//creation of products from properties files
		Producto prod1 = new Producto(LeerPropiedades.leer("input1.properties", "item1")
				, TipoProducto.BOOK
				, OrigenProducto.LOCAL
				, new Precio(LeerPropiedades.leer("input1.properties", "price1")));
		Producto prod2 = new Producto(LeerPropiedades.leer("input1.properties", "item2")
				, TipoProducto.MUSIC
				, OrigenProducto.LOCAL
				, new Precio(LeerPropiedades.leer("input1.properties", "price2")));
		Producto prod3 = new Producto(LeerPropiedades.leer("input1.properties", "item3")
				, TipoProducto.FOOD
				, OrigenProducto.LOCAL
				, new Precio(LeerPropiedades.leer("input1.properties", "price3")));
		
		
		// Inicialite taxes in purchase order
	   Orden orden = new Orden(taxes);
	    // Add items in order
	    orden.add(prod1, 1);
	    orden.add(prod2, 1);
	    orden.add(prod3, 1);

	    // print the receipt
	    SimpleReceipt receipt = new SimpleReceipt(System.out);
	    orden.print(receipt);
	    
	  //INPUT 2 
	  //creation of products from properties files
	     prod1 = new Producto(LeerPropiedades.leer("input2.properties", "item1")
	  				, TipoProducto.FOOD
	  				, OrigenProducto.IMPORTED
	  				, new Precio(LeerPropiedades.leer("input2.properties", "price1")));
	     prod2 = new Producto(LeerPropiedades.leer("input2.properties", "item2")
	  				, TipoProducto.PERFUME
	  				, OrigenProducto.IMPORTED
	  				, new Precio(LeerPropiedades.leer("input2.properties", "price2")));
	  		
	  		
	  		
	  		// Inicialite taxes in purchase order
	      orden = new Orden(taxes);
	  	    // Add items in order
	  	    orden.add(prod1, 1);
	  	    orden.add(prod2, 1);
	  	   

	  	    // print the receipt
	  	    receipt = new SimpleReceipt(System.out);
	  	    orden.print(receipt);
	  	    
	  	//INPUT 3 
	  	//creation of products from properties files
	     prod1 = new Producto(LeerPropiedades.leer("input3.properties", "item1")
					, TipoProducto.PERFUME
					, OrigenProducto.IMPORTED
					, new Precio(LeerPropiedades.leer("input3.properties", "price1")));
	     prod2 = new Producto(LeerPropiedades.leer("input3.properties", "item2")
					, TipoProducto.PERFUME
					, OrigenProducto.LOCAL
					, new Precio(LeerPropiedades.leer("input3.properties", "price2")));
	     prod3 = new Producto(LeerPropiedades.leer("input3.properties", "item3")
					, TipoProducto.MEDICAL
					, OrigenProducto.LOCAL
					, new Precio(LeerPropiedades.leer("input3.properties", "price3")));
			Producto prod4 = new Producto(LeerPropiedades.leer("input3.properties", "item4")
					, TipoProducto.FOOD
					, OrigenProducto.IMPORTED
					, new Precio(LeerPropiedades.leer("input3.properties", "price4")));
			
			
			// Inicialite taxes in purchase order
			 orden = new Orden(taxes);
		    // Add items in order
		    orden.add(prod1, 1);
		    orden.add(prod2, 1);
		    orden.add(prod3, 1);
		    orden.add(prod4, 1);

		    //  print the receipt
		    orden.print(receipt);
	}
}
