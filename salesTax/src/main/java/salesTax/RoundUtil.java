package salesTax;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class RoundUtil {

	/*
	 * Method Round values of tax to the nearest 0.05 
	 * */
public static Precio roundPrecio(Precio taxAmount){
	DecimalFormat formatter = null;
	String x[] = taxAmount.toString().split("\\.");
	String segundoDecimal = x[1].substring(1, 2);
	Integer segDecimal = new Integer(segundoDecimal);
	if(segDecimal < 2 ){
		formatter = new DecimalFormat("#0.#");
		String monto = formatter.format(taxAmount.getPrecio().floatValue());
		monto = monto.replaceAll("\\,", "\\.");
		taxAmount = new Precio(monto.toString());
	}
	if(segDecimal > 1 && segDecimal < 4 ){
		formatter = new DecimalFormat("#.#5");
		String monto = formatter.format(taxAmount.getPrecio().floatValue());
		monto = monto.replaceAll("\\,", "\\.");
		taxAmount = new Precio(monto.toString());
	}
	if(segDecimal > 5 ){
		BigDecimal round = taxAmount.getPrecio().setScale(1, BigDecimal.ROUND_UP);
		taxAmount = new Precio(round.toString());
	}
	return taxAmount;
}
}
