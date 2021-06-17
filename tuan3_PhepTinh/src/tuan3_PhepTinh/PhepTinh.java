package tuan3_PhepTinh;
import java.util.Stack;

public class PhepTinh {
	public static void main(String[] args) {
		String[] phepTinh = "100 / 5 - 12 * 9 + 1".split(" ");
		Stack<Double> stNumber = new Stack<Double>();
		Stack<String> stOperator = new Stack<String>();
		int i = 0;
		while(i < phepTinh.length) {
			switch(phepTinh[i]) {
			case "*":
				stNumber.push(stNumber.pop() * Double.parseDouble(phepTinh[i+1]));
				i += 2;
				break;
			case "/":
				stNumber.push(stNumber.pop() / Double.parseDouble(phepTinh[i+1]));
				i += 2;
				break;
			case "+":
				stOperator.push("+");
				i += 1;
				break;
			case "-":
				stOperator.push("-");
				i += 1;
				break;
			default:
				stNumber.push(Double.parseDouble(phepTinh[i]));
				i += 1;
				break;
			}
		}
		Boolean checker = true;
		Double result = stNumber.pop();
		while(checker) {
			String dau = stOperator.pop();
			if(dau == "+" & stOperator.peek() == "-") {result = (-stNumber.pop() + result);}
			if(dau == "+") {result += stNumber.pop();}
			if(dau == "-") {result = stNumber.pop() - result;}
			if(stOperator.isEmpty() || stNumber.isEmpty()) {checker = false;}
		}
		System.out.println(result);
	}
}
