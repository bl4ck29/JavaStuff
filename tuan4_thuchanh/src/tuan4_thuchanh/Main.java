package tuan4_thuchanh;

public class Main {
	public Double PhepTinh(String num1, String num2, String dau) {
		try {
			switch(dau) {
			case "+":
				return (Double.parseDouble(num1) + Double.parseDouble(num2));
			case "-":
				return (Double.parseDouble(num1) - Double.parseDouble(num2));
			case "*":
				return (Double.parseDouble(num1) * Double.parseDouble(num2));
			case "/":
				return (Double.parseDouble(num1) / Double.parseDouble(num2));
			}
		}
		catch(java.lang.ArithmeticException err_DivideBy0) {
			return null;
		}
		catch(java.lang.NumberFormatException err_NumberFormat) {
			return null;
		}
		return null;
	}
}
