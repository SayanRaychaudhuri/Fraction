public class Fraction {
private int numerator;
private int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public Fraction reciprocal() {
		if (numerator<0) {
			numerator*=-1;
			denominator*=-1;
		}
		Fraction reciprocal = new Fraction(denominator,numerator);
		return reciprocal;
	}
	
	public Fraction add(Fraction f) {
		int d = f.denominator*denominator; //common denominator
		int n = f.denominator*numerator + denominator*f.numerator;
		return new Fraction(n,d);
	}
	
	public Fraction subtract(Fraction f) {
		int d = f.denominator*denominator; //common denominator
		int n = f.denominator*numerator - denominator*f.numerator;
		return new Fraction(n,d);
	}
	
	public Fraction multiply(Fraction f) {
		int n = f.numerator * numerator;
		int d = f.denominator * denominator;
		return new Fraction(n,d);
	}

	public Fraction divide(Fraction f) {
		int divNum= numerator*f.denominator;
		int divDen= denominator*f.numerator;
		if(divDen<0) {
			return new Fraction(divNum*(-1), divDen*(-1));
		} else {
			return new Fraction(divNum, divDen);
			}
	}
	
	public boolean equals(Fraction f) {
		return numerator*f.denominator == denominator*f.numerator ? true : false;
	}
	
	public String toString() {
		return String.valueOf(numerator)+"/"+String.valueOf(denominator);
	}

}