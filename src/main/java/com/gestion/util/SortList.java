package com.gestion.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {

	public static void main(String args[]) {
		
		SortList tester= new SortList();
		List<String> names1 =  new ArrayList<String>();
		List<String> names2 =  new ArrayList<String>();
		
		names1.add("D");
		names1.add("C");
		names1.add("B");
		names1.add("A");
		
		names2.add("F");
		names2.add("E");
		names2.add("H");
		names2.add("G");
		
		System.out.println("JAVA 7");
		System.out.println(names1);
		tester.sort7(names1);
		System.out.println(names1);
		System.out.println("JAVA 8");
		System.out.println(names2);
		tester.sort8(names2);
		System.out.println(names2);
		
	}

	// sort using java 7
	private void sort7(List<String> list) {
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
	}

	// sort using java 8
	
	private void sort8(List<String> list) {
		Collections.sort(list, (s1,s2) -> s1.compareTo(s2));
	}
	

}
