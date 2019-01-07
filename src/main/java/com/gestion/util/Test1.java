package com.gestion.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {

//		int[] t = { -5, -4, 10, 3, 4, 5, 6, 7, 8, 9 };
//
//		System.out.println("le nombre plus proche de 0 est = " + getPlusProcheDeZero(t));
//
		Integer[] array = { -10, -5, -3, -2, -1, 10, 3, 4, 5, 6, 7, 8, 9 , 11};
//
//		Arrays.sort(array, Comparator.comparingInt(Math::abs));
//
		Integer minNumber = Stream.of(array).min(Comparator.comparing(Math::abs)).get();

		System.out.println(minNumber);
//		System.out.println("le nombre plus proche de 0 est = " + array[0]);
//		
//		LocalDate d1 = LocalDate.of(2014, 01, 01);
//		LocalDate d2 = LocalDate.of(2015, 02, 12);
//		Period diff = diffBetweenTwoDate(d1,d2);
//		 
//		System.out.printf("Difference is %d years, %d months and %d days old",
//		                    diff.getYears(), diff.getMonths(), diff.getDays());

//		forEachOverStream();
	}

	static int getPlusProcheDeZero(int[] array) {
		int p = Arrays.stream(Arrays.stream(array).filter(x -> x > 0).toArray()).min().getAsInt();
		int p1 = Arrays.stream(Arrays.stream(array).filter(x -> x < 0).toArray()).max().getAsInt();
		if (Math.abs(p) <= Math.abs(p1)) {
			return p;
		} else {
			return p1;
		}
	}

	static Period diffBetweenTwoDate(LocalDate date1, LocalDate date2) {
		return Period.between(date1, date2);
	}

	static void difference_between_two_dates_java8() {
		LocalDate dateOfBirth = LocalDate.of(1980, Month.JULY, 4);
		LocalDate currentDate = LocalDate.now();
		long diffInDays = ChronoUnit.DAYS.between(dateOfBirth, currentDate);
		long diffInMonths = ChronoUnit.MONTHS.between(dateOfBirth, currentDate);
		long diffInYears = ChronoUnit.YEARS.between(dateOfBirth, currentDate);
	}

	public void difference_between_two_dates_durationin_smaller_time() {
		LocalDateTime dateTime = LocalDateTime.of(1988, 7, 4, 0, 0);
		LocalDateTime dateTime2 = LocalDateTime.now();
		long diffInNano = ChronoUnit.NANOS.between(dateTime, dateTime2);
		long diffInSeconds = ChronoUnit.SECONDS.between(dateTime, dateTime2);
		long diffInMilli = ChronoUnit.MILLIS.between(dateTime, dateTime2);
		long diffInMinutes = ChronoUnit.MINUTES.between(dateTime, dateTime2);
		long diffInHours = ChronoUnit.HOURS.between(dateTime, dateTime2);
	}

	public void difference_between_two_dates_duration() {
		LocalDateTime dateTime = LocalDateTime.of(1988, 7, 4, 0, 0);
		LocalDateTime dateTime2 = LocalDateTime.now();
		int diffInNano = java.time.Duration.between(dateTime, dateTime2).getNano();
		long diffInSeconds = java.time.Duration.between(dateTime, dateTime2).getSeconds();
		long diffInMilli = java.time.Duration.between(dateTime, dateTime2).toMillis();
		long diffInMinutes = java.time.Duration.between(dateTime, dateTime2).toMinutes();
		long diffInHours = java.time.Duration.between(dateTime, dateTime2).toHours();
	}

	static void forEachExp() {
		HashMap<String, Integer> map = new HashMap<>();

		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

		Consumer<Map.Entry<String, Integer>> action = entry -> {
			System.out.println("Key is : " + entry.getKey());
			System.out.println("Value is : " + entry.getValue());
		};

		map.entrySet().forEach(action);
	}

	static void forEachExp2() {
		HashMap<String, Integer> map = new HashMap<>();

		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

		// 1. Map entries
		Consumer<Map.Entry<String, Integer>> action = System.out::println;

		map.entrySet().forEach(action);

		// 2. Map keys
		Consumer<String> actionOnKeys = System.out::println;

		map.keySet().forEach(actionOnKeys);

		// 3. Map values
		Consumer<Integer> actionOnValues = System.out::println;

		map.values().forEach(actionOnValues);
	}

	static void forEachExpUsingList() {
		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		Consumer<Integer> action = System.out::println;

		numberList.forEach(action);
	}

	static void forEachOverStream() {
		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		Consumer<Integer> action = System.out::println;

		numberList.stream().filter(n -> n % 2 == 0).forEach(action);
	}
}
