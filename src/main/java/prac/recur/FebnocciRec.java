package prac.recur;

import java.util.HashMap;
import java.util.Map;

public class FebnocciRec {

	private static int counter = 0;
	private static Map<Integer, Integer> processed = null;

	public static void main(String[] args) {
		int number = 10;
		processed = new HashMap<>(number);
		int result = fSeries(number);
		result = fSeriesNew(number, 0);

		System.out.println("Result : " + result);
	}

	private static int fSeries(int number) {
		if (!processed.containsKey(number)) {
			counter++;
			System.out.println(counter + " Processing for number: " + number);
			if (number <= 1) {
				return number;
			}
			int numberMinusOne = (fSeries(number - 1));
			int numberMinusTwo = (fSeries(number - 2));
			processed.put(number - 1, numberMinusOne);
			processed.put(number - 2, numberMinusTwo);

			System.out.println("numberMinusOne:" + numberMinusOne + "\tnumberMinusTwo:" + numberMinusTwo);
			return numberMinusOne + numberMinusTwo;
		} else {
			return processed.get(number);
		}
	}

	private static int fSeriesNew(int number, int sum) {
		if (number >= 1) {
			sum = sum + fSeriesNew(number - 1, sum);
			System.out.println("number:" + number + "\tsum:" + sum);

		}
		return sum;
	}

	/*
	 * public static void doAction(int number) {
	 * 
	 * if (number == 0) { System.out.print("0\t"); } else if (number == 1) {
	 * System.out.print("1\t"); } else if (number > 1) { int result =
	 * fSeries(number); System.out.println("Result : " + result); } else {
	 * System.out.println("invalid number!"); }
	 * 
	 * }
	 */

}
