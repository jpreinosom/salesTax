package salesTax;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import salesTax.RoundUtil;

public class TaxMetodoPractica implements AplicarImpuesto {

	public TaxMetodoPractica() {

	}

	private final List<TaxMetodo> taxes = new ArrayList<TaxMetodo>();
	private static final BigDecimal localTax = new BigDecimal(0.10);
	private static final BigDecimal importedTax = new BigDecimal(0.05);

	public void add(TaxMetodo tax) {
		taxes.add(tax);
	}

	public Collection<TaxEntry> apply(ProductoEntry entry) {
		List<TaxEntry> entries = new ArrayList<TaxEntry>();
		BigDecimal impuesto = new BigDecimal(0);
		/*
		 * first ask if the product is imported to calculate the tax, if it is, 
		 * you should also ask if it belongs to the group of products exempted to complete the imported tax,
		 *  otherwise being a local product only asks about the products exempted to calculate the tax 
		 * */
		for (TaxMetodo tax : taxes) {
			if (entry.getProducto().isImportado()) {
				impuesto = impuesto.add(importedTax);
				if (tax.isEligible(entry)) {
					impuesto = impuesto.add(localTax);
				}
			} else {
				if (tax.isEligible(entry)) {
					impuesto = impuesto.add(localTax);
				}
			}
			TaxMetodo cantidadImpuesto = new TaxMetodo("ImpuestoTotal", impuesto);
			if(cantidadImpuesto.getRate().signum() > 0){
				TaxEntry taxEntry = apply(cantidadImpuesto, entry);
				entries.add(taxEntry);
			}
		}
		return entries;
	}

	private TaxEntry apply(TaxMetodo tax, ProductoEntry entry) {
		Precio taxAmount = tax.calculate(entry.getPrecio());
		/*
		 * After calculate the tax this value must be rounded in roundPrecio Method
		 * */
		taxAmount = RoundUtil.roundPrecio(taxAmount);
		return new TaxEntry(entry, tax, taxAmount);
	}

	public ProductoEntry UpdateAmount(ProductoEntry entry) {
		ProductoEntry prodEntry = entry;
		BigDecimal impuesto = new BigDecimal(0);
		/*
		 * first ask if the product is imported to calculate the tax, if it is, 
		 * you should also ask if it belongs to the group of products exempted to complete the imported tax,
		 *  otherwise being a local product only asks about the products exempted to calculate the tax 
		 * */
		for (TaxMetodo tax : taxes) {
			if (entry.getProducto().isImportado()) {
				impuesto = impuesto.add(importedTax);
				if (tax.isEligible(entry)) {
					impuesto = impuesto.add(localTax);
				}
			} else {
				if (tax.isEligible(entry)) {
					impuesto = impuesto.add(localTax);
				}
			}
			TaxMetodo cantidadImpuesto = new TaxMetodo("ImpuestoTotal", impuesto);
			if(cantidadImpuesto.getRate().signum() > 0){
				prodEntry = update(cantidadImpuesto, entry);
			}
		}
		return prodEntry;
	}

	private ProductoEntry update(TaxMetodo tax, ProductoEntry entry) {
		Precio taxAmount = tax.calculate(entry.getPrecio());
		/*
		 * After calculate the tax this value must be rounded in roundPrecio Method
		 * */
		taxAmount = RoundUtil.roundPrecio(taxAmount);
		/*
		 * update the value of the product, add the tax value 
		 * */
		Precio newPrecio = taxAmount.add(entry.getPrecio());
		return new ProductoEntry(entry.getProducto(), newPrecio, entry.getCantidad());
	}

}
