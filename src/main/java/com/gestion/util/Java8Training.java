package com.gestion.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Training {

	public static void main(String[] args) {

		// Stream.of(val1, val2, val3….)

		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stream.forEach(p -> System.out.println(p));

		// Stream.of(arrayOfElements)

		Stream<Integer> stream1 = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		stream1.forEach(p -> System.out.println(p));

		// List.stream()

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < 10; i++) {
			list.add(i);
		}

		Stream<Integer> stream2 = list.stream();
		stream2.forEach(p -> System.out.println(p));

		// Stream.generate() or Stream.iterate()

//         Stream<Date> stream3 = Stream.generate(() -> { return new Date(); });
//         stream3.forEach(p -> System.out.println(p));

		// String chars or String tokens

		IntStream stream4 = "12345_abcdefg".chars();
		stream4.forEach(p -> System.out.println(p));

		// OR

		Stream<String> stream5 = Stream.of("A$B$C".split("\\$"));
		stream5.forEach(p -> System.out.println(p));
	}

	static void convertStreamToList() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		Stream<Integer> stream = list.stream();
		List<Integer> evenNumbersList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.print(evenNumbersList);
	}

	static void convertStreamToArray() {

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		Stream<Integer> stream = list.stream();
		Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
		System.out.print(evenNumbersArr);
	}

}
