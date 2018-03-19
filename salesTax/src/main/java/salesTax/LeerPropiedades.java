package salesTax;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeerPropiedades {

	public static String leer(String nombreArchivo, String nombrePropiedad) {
		Properties prop = new Properties();
		InputStream input = null;
		String propiedad = "";
		try {
			String filename = nombreArchivo;
    		input = LeerPropiedades.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		}
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			propiedad = prop.getProperty(nombrePropiedad);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return propiedad;
	}
}
