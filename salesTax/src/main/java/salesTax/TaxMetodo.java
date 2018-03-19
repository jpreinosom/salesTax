package salesTax;

import java.math.BigDecimal;

public class TaxMetodo {

	private final String name;
	private final BigDecimal rate;
	private final TaxEligibilidad eligibilityCheck;

	public TaxMetodo(String name, BigDecimal rate, TaxEligibilidad eligibilityCheck) {
		this.name = name;
		this.rate = rate;
		this.eligibilityCheck = eligibilityCheck;
	}

	public TaxMetodo(String name, BigDecimal rate) {
		this.name = name;
		this.rate = rate;
		this.eligibilityCheck = null;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public boolean isEligible(OrdenEntry entry) {
		return eligibilityCheck == null || eligibilityCheck.isEligible(entry);
	}

	public Precio calculate(Precio amount) {
		return amount.multiply(rate);
	}

}
