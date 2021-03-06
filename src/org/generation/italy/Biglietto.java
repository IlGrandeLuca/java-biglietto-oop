package org.generation.italy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
	// Room 1
	// Constants
	static final BigDecimal KM_PRICE = new BigDecimal("0.21");
	static final BigDecimal DISCOUNT_OVER65 = new BigDecimal("0.6");
	static final BigDecimal DISCOUNT_UNDER12 = new BigDecimal("0.8");
	static final int NORMAL_DUR = 30;
	static final int FLEXIBLE_DUR = 90;

	// Attributes
	private int age, km;
	private LocalDate date;
	private boolean flexible;

	// Methods
	public Biglietto(int age, int km, boolean flexible) throws Exception {
		this.age = age;
		this.km = km;
		this.flexible = flexible;
		date = LocalDate.now();
		if (!isValidAge() || !isValidKm()) {
			throw new Exception("Invalid value");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public static BigDecimal getKmPrice() {
		return KM_PRICE;
	}

	public static BigDecimal getDiscountOver65() {
		return DISCOUNT_OVER65;
	}

	public static BigDecimal getDiscountUnder12() {
		return DISCOUNT_UNDER12;
	}

	private boolean isValidAge() {
		if (age > 0 && age <= 150)
			return true;
		else
			return false;
	}

	private boolean isValidKm() {
		if (km > 0 && km <= 100000)
			return true;
		else
			return false;
	}

	public BigDecimal calculatePrice() {
		if(flexible)
			return calculateDiscount().multiply(BigDecimal.valueOf(km).multiply(BigDecimal.valueOf(1.10)));
		else
			return calculateDiscount().multiply(BigDecimal.valueOf(km));
	}

	private BigDecimal calculateDiscount() {
		if (age <= 12)
			return KM_PRICE.multiply(DISCOUNT_UNDER12);
		else if (age >= 65)
			return KM_PRICE.multiply(DISCOUNT_OVER65);
		else
			return KM_PRICE;
	}
	
	public LocalDate calculateExpire() {
		if(flexible)
			return date.plusDays(FLEXIBLE_DUR);
		else
			return date.plusDays(NORMAL_DUR);
	}
}
