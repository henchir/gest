package com.gestion.util;

public class MainB {
	public static boolean isBetween(int x, int lower, int upper) {
		return lower <= x && x <= upper;
	}

	public static int solution(int[] A) {
		int res = 0;
		int length = A.length;
		boolean b = true;
		boolean b1 = true;
		boolean valide = true;
		try {
			for (int i = 0; i < length; i++) {
				if (A[i] < -1 || A[i] > 199999) {
					valide = false;
				}
			}

			if (valide) {
				for (int i = 0; i < length; i++) {

					if (A[i] != -1 && b) {
						res++;
					} else {

						b = false;
						if (i * 2 < length && b1) {
							res += 2;
							b1 = false;
						} else {
							if (b) {
								res++;
							}
						}
					}
				}
			}

		} catch (Exception ex) {
			System.out.println("Array[N], N is an integer within the range[-1..N-1");
		}

		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 4, 1, 5, 2, 3, 6, 1, 9, 4, 6, -1 };
		System.out.println(String.valueOf(solution(A)));
	}

}
