package core.printing;

import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;

public class PrintingNumbers {

	public static void main(String[] args) {

		float balanceDelta = 6267451.589f;
		System.out.format(
				"Amount gained or lost since last statement: $ %(,.2f \n",
				balanceDelta);
		System.out.format(
				"Amount gained or lost since last statement: $ %(.2f \n",
				balanceDelta);

		System.out.printf("Decimal:      %f\n", Math.PI);
		System.out.printf("Scientific notation: %e\n", Math.PI);
		System.out.printf("Scientific notation: %E\n", Math.PI);
		System.out.printf("Decimal/Scientific: %g\n", Math.PI);
		System.out.printf("Decimal/Scientific: %G\n", Math.PI);
		System.out.printf("Lowercase Hexadecimal: %a\n", Math.PI);
		System.out.printf("Uppercase Hexadecimal: %A\n", Math.PI);

		System.out.printf("%x\n", -15);
		
		double d = Double.MIN_VALUE;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(Integer.MAX_VALUE);
		System.out.println(nf.format(d));

		System.out.println(String.format("%s,%s", 123400, 567800));
		System.out.println(StringUtils.leftPad("1010", 8, '0'));  
	}

}
