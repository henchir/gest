package com.gestion.util;

public class MainA {
	public static boolean isBetween(int x, int lower, int upper) {
		return lower <= x && x <= upper;
	}

	public static int solution(int A) {
		String result = "";
		String strA = String.valueOf(A);
		try {
			if (isBetween(A, 0, 99) || A == 100000000) {
				return A;
			} else if (isBetween(A, 100, 999)) {
				result = "" + strA.charAt(0) + strA.charAt(2) + strA.charAt(1);
			} else if (isBetween(A, 1000, 9999)) {
				result = "" + strA.charAt(0) + strA.charAt(3) + strA.charAt(1) + strA.charAt(2);
			} else if (isBetween(A, 10000, 99999)) {
				result = "" + strA.charAt(0) + strA.charAt(4) + strA.charAt(1) + strA.charAt(3) + strA.charAt(2);
			} else if (isBetween(A, 100000, 999999)) {
				result = "" + strA.charAt(0) + strA.charAt(5) + strA.charAt(1) + strA.charAt(4) + strA.charAt(2)
						+ strA.charAt(3);
			} else if (isBetween(A, 1000000, 9999999)) {
				result = "" + strA.charAt(0) + strA.charAt(6) + strA.charAt(1) + strA.charAt(5) + strA.charAt(2)
						+ strA.charAt(4) + strA.charAt(3);
			} else if (isBetween(A, 10000000, 99999999)) {
				result = "" + strA.charAt(0) + strA.charAt(7) + strA.charAt(1) + strA.charAt(6) + strA.charAt(2)
						+ strA.charAt(5) + strA.charAt(3) + strA.charAt(4);
			} else {
				result ="0";
			}
		} catch (NumberFormatException ex) {
			System.out.println("Only integer within [0 .. 100000000]");
		}

		return Integer.parseInt(result);
	}

	public static void main(String[] args) {
		System.out.println(String.valueOf(solution(12345678)));
	}

}
